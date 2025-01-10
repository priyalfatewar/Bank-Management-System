
import { Component, OnInit } from '@angular/core';

import { Manager } from '../manager.model';

import { ManagerService } from '../manager.service';



@Component({

  selector: 'app-manager',

  templateUrl: './manager.component.html',

  styleUrls: ['./manager.component.css']

})

export class ManagerComponent implements OnInit {

  departments: string[] = [
    'HR',
    'Finance',
    'Operations',
    'Sales',
    'IT'
  ];

  managers: Manager[] = [];

  currentManager: Manager = { id: 0, firstName: '', lastName: '', email: '', department: '',deleted:false };



  constructor(private managerService: ManagerService) { }



  ngOnInit(): void {

    this.loadManagers();

  }



  // Fetch all managers from the service

  loadManagers(): void {

    this.managerService.getManagers().subscribe(data => {

      this.managers = data;

    });

  }



  // Add a new manager

  addManager(): void {

    if (this.isValidManager(this.currentManager)) {

      this.managerService.createManager(this.currentManager).subscribe(() => {

        this.loadManagers(); // Refresh the list

        this.resetForm(); // Reset the form for a new entry

      });

    } else {

      alert("Please fill out all fields correctly.");

    }

  }



  // Update an existing manager

  updateManager(): void {

    if (this.isValidManager(this.currentManager)) {

      this.managerService.updateManager(this.currentManager).subscribe(() => {

        this.loadManagers(); // Refresh the list

        this.resetForm(); // Reset the form after the update

      });

    } else {

      alert("Please fill out all fields correctly.");

    }

  }



  // Delete a manager by ID

  deleteManager(id: number): void {

    this.managerService.deleteManager(id).subscribe(() => {

      this.loadManagers(); // Refresh the list after deletion

    });

  }



  // Set the current manager for editing (fills the form)

  setCurrentManager(manager: Manager): void {

    this.currentManager = { ...manager }; // Use spread to copy the manager's data

  }



  isValidName(name: string): boolean {

    const nameRegex = /^[A-Za-z]+$/;

    return nameRegex.test(name);

  }

  

  isValidEmail(email: string): boolean {

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    return emailRegex.test(email);

  }

  



  // Reset the form to add a new manager (set ID back to 0)

  resetForm(): void {

    this.currentManager = { id: 0, firstName: '', lastName: '', email: '', department: '',deleted:false };

  }



  // Check if the current manager's fields are valid (validation with regex)

  isValidManager(manager: Manager): boolean {

    // Regex for validating email format

    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;



    // Regex for validating names (only alphabetic characters and spaces)

    const nameRegex = /^[A-Za-z]+$/;



    // Check if the fields are valid

    return (

      nameRegex.test(manager.firstName) && 

      nameRegex.test(manager.lastName) &&

      emailRegex.test(manager.email) && 

      manager.department !== ''

    );

  }

}