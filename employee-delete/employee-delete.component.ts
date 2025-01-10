import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  employeeId!: number;  // This will bind to the input field
  employee: Employee | undefined;

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Initialize employeeId if needed
  }

  // Fetch employee details based on entered employeeId
  loadEmployee(): void {
    if (this.employeeId) {
      this.employeeService.getEmployee(this.employeeId).subscribe((data) => {
        this.employee = data;
      }, error => {
        alert('Employee not found!');
        this.employee = undefined; // Reset the employee details if not found
      });
    }
  }

  // Delete employee and navigate back to the list
  deleteEmployee(): void {
    if (this.employeeId) {
      if (confirm('Are you sure you want to delete this employee?')) {
        this.employeeService.deleteEmployee(this.employeeId).subscribe(() => {
          alert('Employee deleted successfully.');
          this.router.navigate(['/list']);  // Navigate back to employee list
        }, error => {
          alert('Error: Employee not found or could not be deleted.');
        });
      }
    } else {
      alert('Please enter a valid employee ID.');
    }
  }

  // Cancel deletion and go back to employee list
  cancel(): void {
    this.router.navigate(['/employee-list']); // Navigate back to employee list
  }
}
