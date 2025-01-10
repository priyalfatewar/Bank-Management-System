import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomerComponent {
  customer = {
    ssnid: '',  // Auto-generated SSNID
    firstName: '',
    lastName: '',
    email: '',
    dob: '',  // Will be renamed to dateofbirth when sending the data
    aadhar: '',
    pan: '',
    password: '',
    confirmPassword: ''  // Added confirm password
  };
  

  constructor(private http: HttpClient, private router: Router) {}
  today: string = '';  // To store today's date in YYYY-MM-DD format
  minDate: string = '';  // To store the minimum date for 18 years age restriction

  ngOnInit(): void {
    // Get today's date
    const currentDate = new Date();
    this.today = this.formatDate(currentDate);

    // Get the minimum date (18 years ago)
    const minAgeDate = new Date();
    minAgeDate.setFullYear(minAgeDate.getFullYear() - 18);
    this.minDate = this.formatDate(minAgeDate);
  }

  // Helper function to format date as YYYY-MM-DD
  formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
  // Generate a 7-digit SSNID (between 1000000 and 9999999)
  // generateSSNID(): string {
  //   return (Math.floor(1000000 + Math.random() * 9000000)).toString();
  // }

  onSubmit(form: any) {
    // Check if the form is valid
    if (form.valid) {
      // Password validation check
      if (this.customer.password !== this.customer.confirmPassword) {
        alert('Passwords do not match.');
        return;
      }

      // Additional custom validation checks can go here
      if (!this.isValidEmail(this.customer.email)) {
        alert('Please provide a valid email address.');
        return;
      }

      const dob = new Date(this.customer.dob);
    const today = new Date();
    if (dob > today) {
      alert('Date of Birth cannot be in the future.');
      return;
    }

    // Age validation: Check if the user is at least 18 years old
    const minAgeDate = new Date(this.minDate);
    if (dob > minAgeDate) {
      alert('You must be at least 18 years old.');
      return;
    }

      // Prepare the payload to match the backend's expected structure
      const payload = {
        ssnid: this.customer.ssnid,
        firstname: this.customer.firstName,
        lastname: this.customer.lastName,
        email: this.customer.email,
        dateofbirth: this.customer.dob,  // Using 'dateofbirth' instead of 'dob'
        aadharNumber: this.customer.aadhar,  // Using 'aadharNumber' instead of 'aadhar'
        panNumber: this.customer.pan,  // Using 'panNumber' instead of 'pan'
        password: this.customer.password,
        confirmPassword: this.customer.confirmPassword
      };

      console.log('Customer Registration Details:', payload);

      // Define the expected response structure
      interface RegistrationResponse {
        ssnid: string;  // SSN ID returned by the backend
      }

      // Send data to the backend API
      this.http.post<RegistrationResponse>('http://localhost:8086/users/register', payload)
        .pipe(
          catchError(error => {
            console.error('Error occurred while sending data', error);
            alert('Registration failed, please try again.');
            return of(null); // Return a fallback observable to handle errors gracefully
          })
        )
        .subscribe(response => {
          if (response) {
            console.log('Registration Successful');
            // Display SSN ID from response in the alert
            alert(`Registration successful! Your SSN ID is: ${response.ssnid}`);
            this.router.navigate(['/customer-login']);
          }
        });

    } else {
      console.log('Form is not valid');
      alert('Please fill in all the required fields.');
    }
  }

  // Example of custom validation: Check if email is valid
  isValidEmail(email: string): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
  }
}
