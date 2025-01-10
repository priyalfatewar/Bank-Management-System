// import { Component } from '@angular/core';

// import { Router } from '@angular/router';



// @Component({

//   selector: 'app-login',

//   templateUrl: './login.component.html',

//   styleUrls: ['./login.component.css']

// })

// export class LoginComponent {

//   username: string = '';

//   password: string = '';

//   errorMessage: string = '';



//   // Predefined credentials for login

//   private predefinedUsername = 'admin';

//   private predefinedPassword = 'admin123';



//   constructor(private router: Router) {}

//   // Handle login form submission

//   onLogin(): void {

//     if (this.username === this.predefinedUsername && this.password === this.predefinedPassword) {

//       sessionStorage.setItem('username',this.username);
      
//       // Redirect to customer registration page upon successful login

//       this.router.navigate(['/manager']);

//     } else {

//       // Display error message if credentials are incorrect

//       this.errorMessage = 'Incorrect username or password.';

//     }

//   }

// }

import { Component } from '@angular/core';



import { Router } from '@angular/router';







@Component({



  selector: 'app-login',



  templateUrl: './login.component.html',



  styleUrls: ['./login.component.css']



})



export class LoginComponent {



  username: string = '';



  password: string = '';



  errorMessage: string = '';







  // Predefined credentials for login



  private predefinedUsername = 'admin';



  private predefinedPassword = 'admin123';







  constructor(private router: Router) {}



  // Handle login form submission



  onLogin(): void {



    if (this.username === this.predefinedUsername && this.password === this.predefinedPassword) {



      sessionStorage.setItem('username',this.username);

      // Redirect to customer registration page upon successful login



      this.router.navigate(['/manager']);



    } else {



      // Display error message if credentials are incorrect



      this.errorMessage = 'Incorrect username or password.';



    }



  }



}