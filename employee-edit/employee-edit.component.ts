import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  employee: Employee = {
    id: 0,  // Default ID can be 0 or another value
    name: '',
    position: '',
    department: '',
    salary: 0,
    status: 'active'  // Default status is 'active'
  };
  departments: string[] = [
    'HR',
    'Finance',
    'Operations',
    'Sales',
    'IT'
  ];
  positions: string[] = [
    'Manager',
    'Software Engineer',
    'HR Executive',
    'Sales Executive',
    'Accountant'
  ];

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Get employee id from the URL (route parameter)
    const id = Number(this.route.snapshot.paramMap.get('id'));

    // Fetch the employee details by the id from the EmployeeService
    if (id) {
      this.employeeService.getEmployee(id).subscribe((data: Employee) => {
        this.employee = data;
      });
    }
  }

  // Update employee details
  updateEmployee(): void {
    // Create a new object to send for updating, excluding id and status
    const updatedEmployee: Employee = {
      id: this.employee.id,               // Keep the existing id
      name: this.employee.name,           // Keep the existing name (don't change it)
      status: this.employee.status,       // Keep the existing status (read-only)
      position: this.employee.position,   // Editable field
      department: this.employee.department, // Editable field
      salary: this.employee.salary         // Editable field
    };

    // Check if employee id exists before updating
    if (this.employee.id) {
      this.employeeService.updateEmployee(this.employee.id, updatedEmployee).subscribe(() => {
        // Navigate back to the employee list or home page after updating
        this.router.navigate(['/employee-list']);
      });
    } else {
      console.error('Employee ID is missing!');
    }
  }
}
