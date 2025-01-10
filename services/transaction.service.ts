import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl: string = 'http://localhost:9098/transactions'; // Spring Boot Backend URL


  constructor(private http: HttpClient) { }

  // Transfer money from one account to another
//   transferMoney(senderAccountNumber: string, receiverAccountNumber: string, 
//     amount: number, senderIfscCode: string, receiverIfscCode: string): Observable<string> {
// const body = { 
// senderAccountNumber, 
// receiverAccountNumber, 
// amount, 
// senderIfscCode, 
// receiverIfscCode 
// };

// return this.http.post<string>(`${this.baseUrl}/transactions/transfer`, body, { responseType: 'text' as 'json' });
// }
transferMoney(senderAccountNumber: string, receiverAccountNumber: string, 
  amount: number, senderIfscCode: string, receiverIfscCode: string): Observable<string> {
const body = { 
senderAccountNumber, 
receiverAccountNumber, 
amount, 
senderIfscCode, 
receiverIfscCode 
};

// Send the POST request with the responseType set to 'text'
return this.http.post<string>(`${this.baseUrl}/transfer`, body, { responseType: 'text' as 'json' });
}




  // Get transaction history
  getTransactionHistory(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/history`);
  }
  getTransactionHistoryByAcc(accountNumber: string): Observable<any> {
   
    
    return this.http.get<any>(`${this.baseUrl}/history/${accountNumber}`);
  }

  // Get balance of a specific account
  getBalance(accountNumber: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/balance/${accountNumber}`);
  }
}
