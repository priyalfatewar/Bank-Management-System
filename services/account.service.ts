import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl: string = 'http://localhost:9098/accounts'; // Adjust the URL if necessary

  constructor(private http: HttpClient) { }

  // Create a new account
  createAccount(ssnId: string,accountName: string, accountType: string, balance: number): Observable<any> {
    const body = { ssnId,accountName, accountType, balance };
    console.log("Request body:", body);  // Log to check the request data
    return this.http.post<any>(`${this.baseUrl}`, body);
  }

  // Get account details by SSN
  getAccountDetails(ssnId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${ssnId}`);
  }

 // account.service.ts

 updateAccountName(accountNumber: string, newAccountName: string): Observable<any> {
  const url = `${this.baseUrl}/update/${accountNumber}/name?newAccountName=${newAccountName}`;
  return this.http.put<any>(url, {}); 
}

updateAccountType(accountNumber: string, newAccountType: string): Observable<any> {
  const url = `${this.baseUrl}/update/${accountNumber}/type?newAccountType=${newAccountType}`;
  return this.http.put<any>(url, {}); 
}



  // Delete an account
  deleteAccount(SSNId: string): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${SSNId}`);
  }
}
