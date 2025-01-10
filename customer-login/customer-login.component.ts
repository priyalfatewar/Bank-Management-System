import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TransactionService } from '../services/transaction.service';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent {
  loginData = {
    ssnid: '',  // Using SSN ID instead of email
    password: ''
  };

  loginError: boolean = false;
  errorMessage: string = '';
  authService: any;

  constructor(private http: HttpClient, private router: Router, private TransactionService:TransactionService, private AccountService:AccountService ) {}

  onSubmit(form: NgForm): void {
    if (form.invalid) {
      this.errorMessage = 'Invalid SSN ID or password. Please try again.';
      this.loginError = true;
      return;
    }

    const { ssnid, password } = this.loginData;

    // Make a GET request to fetch user details by SSN ID
    console.log(ssnid);
    
    this.http.get<any>(`http://localhost:8086/users/${ssnid}`)
      .subscribe(
        (response: any) => {
         //console.log(response.deleted);
          if(response.deleted){
            this.errorMessage = 'Your Account is Deleted. Contact with Bank for Further Details.';
            this.loginError = true;
          }
          else{
          // Check if the returned user has a matching password
          if (response && response.password === password) {
           // console.log('Login successful:', response);
            this.loginError = false;
            alert('Login successful!');
            sessionStorage.setItem('SSNID',response.ssnid);
            sessionStorage.setItem('Name',response.firstname +' '+ response.lastname);
            
            // Save the user details in localStorage
            
          
            this.AccountService.getAccountDetails(response.ssnid).subscribe(
                    (data:any) => {
                      sessionStorage.setItem('AccNo',data.accountNumber);
                      sessionStorage.setItem('IFSCcode',data.ifscCode);
                      sessionStorage.setItem('AccType',data.accountType);
                      
                    },
                    (error) => {
                      console.log(error);
                    }
                  );

            // Navigate to the dashboard after successful login
            this.router.navigate(['/customer-dashboard']);
          } else {
            // Password does not match
            this.errorMessage = 'Invalid password. Please try again.';
            this.loginError = true;
          }
        }
        },
        (error) => {
          // Handle login error response
          console.error('Login failed:', error);
          this.errorMessage = error.error?.message || 'User not found or invalid credentials.';
          this.loginError = true;
        }
      );
      this.authService.login(ssnid, password).then(() => {
        this.loginError = false;
        this.router.navigate(['/customer-dashboard']);  // Redirect to dashboard on successful login
      }).catch((error: { error: string; }) => {
        this.errorMessage = error.error || 'Login failed. Please try again.';
        this.loginError = true;
      });
    }
}
