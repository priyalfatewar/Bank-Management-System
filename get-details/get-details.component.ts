import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-get-details',
  templateUrl: './get-details.component.html',
  styleUrls: ['./get-details.component.css']
})
export class AccountDetailsComponent implements OnInit {

  SSNId: string = '';
  account: any;
  errorMessage: string = '';

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

  // Get account details by SSN
  getAccountDetails(): void {
    if (!this.SSNId) {
      this.errorMessage = 'Please provide a valid SSN!';
      return;
    }
    this.accountService.getAccountDetails(this.SSNId).subscribe(
      (data) => {
        console.log('Received account data:', data);  // Log the received data to verify
        if (data) {
          this.account = data;
        } else {
          this.errorMessage = 'Account not found';
        }
      },
      (error) => {
        this.errorMessage = 'Account not found';
      }
    );
  }
}
