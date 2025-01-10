import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) { }

  canActivate(): Observable<boolean> | Promise<boolean> | boolean {
    // Check if sessionStorage contains a logged-in user (check for username or other session data)
    const username = sessionStorage.getItem('username');
    
    if (username) {
      // User is logged in, allow access to the route
      return true;
    } else {
      // User is not logged in, redirect to login page
      this.router.navigate(['/']);
      return false;
    }
  }
}
  

