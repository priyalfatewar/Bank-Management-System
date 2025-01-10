// import { Component } from '@angular/core';
// import { TransactionService } from '../services/transaction.service';
// import { Observable } from 'rxjs';

// @Component({
//   selector: 'app-transfer-money',
//   templateUrl: './transfer-money.component.html',
//   styleUrls: ['./transfer-money.component.css']
// })
// export class TransferMoneyComponent {

//   senderAccountNumber: string = '';
//   receiverAccountNumber: string = '';
//   amount: number = 0;
//   senderIfscCode: string = '';
//   receiverIfscCode: string = '';
//   transactionStatus: string = '';
//   errorMessage: string = '';
//   successMessage: string = '';
//   isLoading: boolean = false; // Add loading state

//   constructor(private transactionService: TransactionService) { }

//   // Transfer money
//   transferMoney(): void {
//     // Reset the messages before starting a new transfer attempt
//     this.errorMessage = '';
//     this.successMessage = '';

//     // Validate fields before making the API call
//     if (!this.senderAccountNumber || !this.receiverAccountNumber || !this.amount || !this.senderIfscCode || !this.receiverIfscCode) {
//       this.errorMessage = 'Please fill in all fields!';
//       return;
//     }

//     // Start the loading indicator
//     this.isLoading = true;

//     // Call the transfer money service
//     this.transactionService.transferMoney(
//       this.senderAccountNumber,
//       this.receiverAccountNumber,
//       this.amount,
//       this.senderIfscCode,
//       this.receiverIfscCode
//     ).subscribe(
//       (data) => {
//         // Handle success
//         this.isLoading = false;
//         this.successMessage = 'Money transferred successfully!';
//         this.transactionStatus = data; // Assuming data contains transactionStatus
//       },
//       (error) => {
//         // Handle error
//         this.isLoading = false;
//         this.errorMessage = error?.error?.message || 'Error during money transfer'; // Display backend error message if available
//       }
//     );
//   }
// }


import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../services/transaction.service';  // Make sure this is the correct path
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transfer-money',
  templateUrl: './transfer-money.component.html',
  styleUrls: ['./transfer-money.component.css']
})
export class TransferMoneyComponent implements OnInit{

  // Form fields for sender, receiver, amount, and IFSC codes
  senderAccountNumber: any = '';
  receiverAccountNumber: string = '';
  amount: number = 0;
  senderIfscCode: string = '';
  receiverIfscCode: string = '';

  // Variables to hold status messages
  transactionStatus: string = '';  
  errorMessage: string = '';
  successMessage: string = '';

  // Loading state to show a spinner or disable buttons
  isLoading: boolean = false; 

  constructor(private transactionService: TransactionService,private router:Router) { }
ngOnInit(): void {
  const accNo = sessionStorage.getItem('AccNo');
  this.senderAccountNumber = accNo ? +accNo : 0;
  this.senderIfscCode= sessionStorage.getItem('IFSCcode')||'';
}
  // Transfer money function
  transferMoney(): void {
    // Reset the status messages before a new transaction attempt
    this.errorMessage = '';
    this.successMessage = '';

    // Validate all the required fields
    if (!this.senderAccountNumber || !this.receiverAccountNumber || !this.amount || !this.senderIfscCode || !this.receiverIfscCode) {
      this.errorMessage = 'Please fill in all fields!';
      return;  // Stop further execution if validation fails
    }
    if(this.amount<=0){
      this.errorMessage = 'Amount must be not less than 0 ';
      return;
    }

    // Start loading indicator while making the API request
    this.isLoading = true;

    // Call the transferMoney method from the service
    this.transactionService.transferMoney(
      this.senderAccountNumber,
      this.receiverAccountNumber,
      this.amount,
      this.senderIfscCode,
      this.receiverIfscCode
    ).subscribe(
      (data) => {
        // On successful transfer
        this.isLoading = false;
        if(data==="Sender or Receiver account not found."){
          alert("Sender or Receiver account not found.");
          return;
        }
        this.successMessage = 'Money transferred successfully!';
        this.transactionStatus = data;  // Assuming the backend sends back transaction status
        alert("Money transferred successfully!");
        this.router.navigate(['/transactions']);
        
      },
      (error) => {
        // On error, stop loading and display the error message
        this.isLoading = false;
        if (error?.error?.message) {
          this.errorMessage = error.error.message;  // Display error message from backend if available
        } else {
          this.errorMessage = 'Error during money transfer. Please try again.';
        }
      }
    );
  }
}

