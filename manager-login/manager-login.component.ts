import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-login',
  templateUrl: './manager-login.component.html',
  styleUrls: ['./manager-login.component.css']
})
export class ManagerLoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  // Predefined credentials for login
  private predefinedUsername = 'manager';
  private predefinedPassword = 'manager123';

  constructor(private router: Router) {}

  // Handle login form submission
  onLogin(): void {
    if (this.username === this.predefinedUsername && this.password === this.predefinedPassword) {
      // Redirect to customer registration page upon successful login
      sessionStorage.setItem('username', this.username);

      this.router.navigate(['/employee-create']);
    } else {
      // Display error message if credentials are incorrect
      this.errorMessage = 'Incorrect username or password.';
    }
  }
}

