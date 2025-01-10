import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../services/transaction.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {
  transactions: any[] = [];
  errorMessage: string = '';
accountNumber:string='';
  constructor(private transactionService: TransactionService,private router:Router) {}
ngOnInit(): void {
    this.accountNumber=sessionStorage.getItem('AccNo')?.trim()||'';
    
}
  getTransactionHistory(): void {
    this.transactionService.getTransactionHistoryByAcc(this.accountNumber).subscribe(
      (data) => {
        //console.log(data,this.accountNumber);
        this.transactions = data;
      },
      (error) => {
        this.errorMessage = 'Error fetching transaction history.';
      }
    );
  }
}
