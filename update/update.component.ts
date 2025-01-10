import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  userDetails: any = {};  // Object to store user details
  userId: string = '';  // Store the dynamic ID passed to the route

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    // Get the userId from the route (assuming you pass the ID as a URL parameter)
    this.userId = this.route.snapshot.paramMap.get('id')!;

    // Get the user from localStorage and set the userId from there
    const userFromStorage =sessionStorage.getItem('SSNID');
    if (userFromStorage) {
     
      this.userId = userFromStorage; // Use ssnid from localStorage
    }

    // Fetch user data from the backend
    this.fetchUserDetails();
  }

  // Method to fetch user details by ID
  fetchUserDetails(): void {
    this.http.get(`http://localhost:8086/users/${this.userId}`)
      .subscribe(
        (response: any) => {
          this.userDetails = response; // Store the user data returned from the backend
          console.log('Fetched user details:', this.userDetails);  // Check the response
        },
        (error) => {
          console.error('Error fetching user details:', error);
        }
      );
  }

  // Method to update only the email
  updateUser(): void {
    if (this.userDetails.ssnid && this.userDetails.email) {
      // Prepare data for update: Only email is changed, rest of the fields remain the same
      const updatedUser = {
        ssnid: this.userDetails.ssnid,  // Keep the same ssnid
        firstname: this.userDetails.firstname,  // Keep the same firstname
        lastname: this.userDetails.lastname,  // Keep the same lastname
        email: this.userDetails.email,  // Update the email only
        dateofbirth: this.userDetails.dateofbirth,  // Keep the same date of birth
        aadharNumber: this.userDetails.aadharNumber,  // Keep the same Aadhar number
        panNumber: this.userDetails.panNumber,  // Keep the same PAN number
        password: this.userDetails.password,  // Keep the same password
        confirmPassword: this.userDetails.confirmPassword  // Keep the same confirmPassword
      };

      // Send PUT request to update only the email
      this.http.put(`http://localhost:8086/users/update`, updatedUser)
        .subscribe(
          (response) => {
            console.log('User email updated successfully:', response);

            // Save updated email in localStorage (assuming other details stay the same)
            const updatedUserInLocalStorage = { ...this.userDetails, email: this.userDetails.email };
            localStorage.setItem('user', JSON.stringify(updatedUserInLocalStorage));

            // Show success message
            alert('Email Update Successful!');

            // Redirect to dashboard after successful update
            this.router.navigate(['/customer-dashboard']);
          },
          (error) => {
            console.error('Error updating user:', error);
            alert('Error updating user details. Please try again later.');
          }
        );
    } else {
      alert('Please enter a valid email!');
    }
  }
}
