// import { Component } from '@angular/core';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-navbar',
//   templateUrl: './navbar.component.html',
//   styleUrls: ['./navbar.component.css']
// })
// export class NavbarComponent {

//   constructor(private router: Router) { }



//   // Method to handle logout

//   onLogout(): void {

//     // Clear the session storage (e.g., username, any other session data)

//     sessionStorage.clear();



//     // Redirect to the login page (or home page)

//     this.router.navigate(['/']);

//   }
// }
import { Component } from '@angular/core';

import { Router } from '@angular/router';



@Component({

  selector: 'app-navbar',

  templateUrl: './navbar.component.html',

  styleUrls: ['./navbar.component.css']

})

export class NavbarComponent {



  constructor(private router: Router) { }







  // Method to handle logout



  onLogout(): void {



    // Clear the session storage (e.g., username, any other session data)



    sessionStorage.clear();







    // Redirect to the login page (or home page)



    this.router.navigate(['/']);



  }

}