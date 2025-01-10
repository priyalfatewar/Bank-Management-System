import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Import Router for navigation
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  SSNId: string = sessionStorage.getItem('SSNID')|| '';
  newAccountName: string = '';
  newAccountType: string = '';
  newAccountBalance: number = 0;
  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;
  accountId: string = '';  // This will store the account ID after creation

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
    this.SSNId= sessionStorage.getItem('SSNID')|| '';
    this.newAccountName = sessionStorage.getItem('Name')||'';
    this.newAccountType = sessionStorage.getItem('AccType')||'';
  }

  // Create a new account
  createAccount(): void {
    if (!this.newAccountName || !this.newAccountType || this.newAccountBalance <= 0) {
      this.errorMessage = 'Please fill in all fields correctly!';
      return;
    }
    this.isLoading = true;
   // console.log(this.SSNId,this.newAccountName, this.newAccountType, this.newAccountBalance);
    this.accountService.createAccount(this.SSNId,this.newAccountName, this.newAccountType, this.newAccountBalance).subscribe(
      (data) => {
        
        
        this.isLoading = false;
        this.successMessage = 'Account created successfully!';
        this.accountId = data.accountNumber;  // Store the account ID for navigation
        

        // Redirect to the dashboard after account creation
        sessionStorage.setItem('AccType',this.newAccountType);
        sessionStorage.setItem('AccNo',data.accountNumber);
        sessionStorage.setItem('IFSCcode',data.ifscCode);
        this.router.navigate(['/customer-dashboard']);
      },
      (error) => {
        this.isLoading = false;
        this.errorMessage = 'Error creating account';
      }
    );
  }
}
