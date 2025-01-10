import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})

export class DeleteAccountComponent implements OnInit {

  SSNId: string = sessionStorage.getItem('SSNID')||'';
  errorMessage: string = '';
  successMessage: string = '';
  AccInfo:any;

  constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountService) { }
  ngOnInit(): void {
    this.SSNId = this.route.snapshot.paramMap.get('SSNId') || '';  // Get accountId from the URL
    if (this.SSNId) {
      this.deleteAccount();
    }
    this.SSNId = sessionStorage.getItem('SSNID')||'';
  }

  getAccountDetails(): void {
    
    this.accountService.getAccountDetails(this.SSNId).subscribe(
      (data:any) => {
        this.AccInfo = data;
       // console.log(this.AccInfo);
      },
      (error) => {
        this.errorMessage = 'Account not found';
      }
    );
  }

  // Delete account
  deleteAccount(): void {
    if (!this.SSNId) {
      this.errorMessage = 'Please provide a valid SSN!';
      return;
    }
    // if(this.SSNId){
    //   this.getAccountDetails();
    //   //console.log(this.AccInfo);
    //   if(this.AccInfo.balance!=0){
    //     alert("Unable to delete account. Account Balance is: "+this.AccInfo.balance);
    //     this.router.navigate(['/customer-dashboard']);
    //     return;
    //   } 
    // }

    this.accountService.deleteAccount(this.SSNId).subscribe(
      (data) => {
        this.successMessage = 'Account deleted successfully!';
        alert("Your account is deleted Successfully");
        this.router.navigate(['/customer-dashboard']);
        sessionStorage.removeItem('AccType');
        sessionStorage.removeItem('AccNo');
      },
      (error) => {
        this.errorMessage = 'Error deleting account';
      }
    );
  }
}
