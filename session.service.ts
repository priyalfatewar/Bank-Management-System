// session.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { }

  // Set the user session in local storage
  setSession(user: any): void {
    localStorage.setItem('user', JSON.stringify(user));
  }

  // Get the user session from local storage
  getSession(): any {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
  }

  // Clear the user session
  clearSession(): void {
    localStorage.removeItem('user');
  }

  // Check if user is logged in
  isLoggedIn(): boolean {
    return this.getSession() !== null;
  }
}
