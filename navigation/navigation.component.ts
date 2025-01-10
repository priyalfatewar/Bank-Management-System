import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {
  

  constructor(private router: Router) { }

  // Method to handle logout
  onLogout(): void {
    // Clear the session storage (e.g., username, any other session data)
    sessionStorage.clear();

    // Redirect to the login page (or home page)
    this.router.navigate(['/']);
  }
}