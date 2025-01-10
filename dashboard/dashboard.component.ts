import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {
    accountId: any;  // Store account ID from the URL
    SSNID: string = sessionStorage.getItem('SSNID')|| '';
    accountName:string=sessionStorage.getItem('Name')|| '';
    accountType:string=sessionStorage.getItem('AccType')|| '';
    accountNumber:string=sessionStorage.getItem('AccNo')|| '';
    constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountService) { }
  
    ngOnInit(): void {
      //this.accountId = this.route.snapshot.paramMap.get('accountId') || '';  // Get accountId from the URL
      this.accountId =sessionStorage.getItem('SSNID') || '';
      this.accountName=sessionStorage.getItem('Name')|| '';
      this.accountType=sessionStorage.getItem('AccType')|| '';
      this.accountNumber=sessionStorage.getItem('AccNo')|| '';
    }
    
  
 
   
  
    // Navigate to the Update Account page
    updateAccount(): void {
      this.router.navigate(['/update', this.accountId]);
    }
  
    // Navigate to the Delete Account page
    deleteAccount(): void {
      this.router.navigate(['/delete', this.accountId]);
    }
  }
  
// export class DashboardComponent implements OnInit {

//   accountId: string = '';  // Store account ID from the URL
//   account1: any;
//   errorMessage: string = '';
//   successMessage: string = '';

//   constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountService) { }

//   ngOnInit(): void {
//     this.accountId = this.route.snapshot.paramMap.get('accountId') || '';  // Get accountId from the URL
//     //this.accountId =sessionStorage.getItem('SSNID') || '';
    
//     if (this.accountId) {
      
//       this.getAccountDetails();
//     }
//   }

//   // Fetch account details
//   getAccountDetails(): void {
    
//     this.accountService.getAccountDetails(this.accountId).subscribe(
//       (data:any) => {
//         this.account1 = data;
//       },
//       (error) => {
//         this.errorMessage = 'Account not found';
//       }
//     );
//   }

//   // Navigate to the Update Account page
//   updateAccount(): void {
//     this.router.navigate(['/update', this.accountId]);
//   }

//   // Navigate to the Delete Account page
//   deleteAccount(): void {
//     this.router.navigate(['/delete', this.accountId]);
//   }
// }
