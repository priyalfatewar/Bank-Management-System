import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {


    employee: Employee = {
      id: 0,
      name: '',
      position: '',
      department: '',
      salary: 0,
      status: 'active'  // Add status property and set it to 'active' by default
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
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  // Create employee
  createEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe(() => {
      this.router.navigate(['/employee-list']);
    });
  }

}
