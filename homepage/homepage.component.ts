// // src/app/homepage/homepage.component.ts
// import { Component } from '@angular/core';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-homepage',
//   templateUrl: './homepage.component.html',
//   styleUrls: ['./homepage.component.css']
// })
// export class HomepageComponent {

//   constructor(private router: Router) {}

//   loginAs(role: string) {
//     // Redirect to appropriate login page or dashboard based on role
//     if (role === 'admin') {
//       this.router.navigate(['/loginAdmin']); // replace with your actual route
//     } else if (role === 'manager') {
//       this.router.navigate(['/loginmanager']); // replace with your actual route
//     } else if (role === 'customer') {
//       this.router.navigate(['/customers']); // replace with your actual route
//     }
//   }
// }
// src/app/homepage/homepage.component.ts

import { Component } from '@angular/core';

import { Router } from '@angular/router';



@Component({

  selector: 'app-homepage',

  templateUrl: './homepage.component.html',

  styleUrls: ['./homepage.component.css']

})

export class HomepageComponent {



  constructor(private router: Router) {}



  loginAs(role: string) {

    // Redirect to appropriate login page or dashboard based on role

    if (role === 'admin') {

      this.router.navigate(['/loginAdmin']); // replace with your actual route

    } else if (role === 'manager') {

      this.router.navigate(['/loginmanager']); // replace with your actual route

    } else if (role === 'customer') {

      this.router.navigate(['/customers']); // replace with your actual route

    }

  }

}