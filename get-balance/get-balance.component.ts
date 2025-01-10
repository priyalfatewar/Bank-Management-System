import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../services/transaction.service';  // Adjust path as necessary

@Component({
  selector: 'app-get-balance',
  templateUrl: './get-balance.component.html',
  styleUrls: ['./get-balance.component.css']
})
export class GetBalanceComponent implements OnInit{
  accountNumber: string = sessionStorage.getItem('AccNo')||'';  // The account number input by the user
  balance: number | undefined;  // To hold the balance after fetching from the server
  errorMessage: string | undefined;  // To display any error messages
  successMessage: string | undefined;  

  constructor(private transactionService: TransactionService) {}
  ngOnInit(): void {
    this.accountNumber = sessionStorage.getItem('AccNo')||'';
  }
  // Method to get balance from the backend
  getBalance(): void {
    this.errorMessage = undefined;
    this.successMessage = undefined;

    if (!this.accountNumber) {
      this.errorMessage = "Account number is required!";
      return;
    }

    // Call the getBalance method from TransactionService
    this.transactionService.getBalance(this.accountNumber).subscribe(
      (response) => {
        
        
        
        this.balance = response;
        this.successMessage = `Balance fetched successfully`;
      },
      (error) => {
        // Handle error response
        this.errorMessage = `Error: ${error.message}`;
        this.balance = undefined;
      }
    );
  }
}
