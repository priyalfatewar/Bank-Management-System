package com.example.bankmanager.controller;

import java.util.List;
import java.util.Optional;
import com.example.bankmanager.model.Employee;
import com.example.bankmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) 
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        try {
            Employee updatedEmp = employeeService.updateEmployee(id, updatedEmployee);
            return ResponseEntity.ok(updatedEmp);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Show all active employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees(); // Fetch only active employees
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return no content if no active employees are found
        }
        return ResponseEntity.ok(employees);  // Return the list of active employees
    }

    // Soft delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteEmployee(@PathVariable Long id) {
        try {
            employeeService.softDeleteEmployee(id);  // Soft delete employee
            return ResponseEntity.noContent().build();  // Return no content after successful soft delete
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Employee not found
        }
    }
}


















/*
 * package com.example.bankmanager.controller; import java.util.List; import
 * java.util.Optional; import com.example.bankmanager.model.Employee; import
 * com.example.bankmanager.service.EmployeeService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.*;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/employees") public class EmployeeController {
 * 
 * @Autowired private EmployeeService employeeService;
 * 
 * // Create employee
 * 
 * @PostMapping public ResponseEntity<Employee> createEmployee(@RequestBody
 * Employee employee) { Employee createdEmployee =
 * employeeService.createEmployee(employee); return
 * ResponseEntity.ok(createdEmployee); }
 * 
 * // Update employee
 * 
 * @PutMapping("/{id}") public ResponseEntity<Employee>
 * updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee)
 * { try { Employee updatedEmp = employeeService.updateEmployee(id,
 * updatedEmployee); return ResponseEntity.ok(updatedEmp); } catch
 * (RuntimeException e) { return ResponseEntity.notFound().build(); } }
 * 
 * // Get employee by ID
 * 
 * @GetMapping("/{id}") public ResponseEntity<Employee>
 * getEmployeeById(@PathVariable Long id) { Optional<Employee> employee =
 * employeeService.getEmployeeById(id); return
 * employee.map(ResponseEntity::ok).orElseGet(() ->
 * ResponseEntity.notFound().build()); }
 * 
 * //show all employees
 * 
 * @GetMapping public ResponseEntity<List<Employee>> getAllEmployees() {
 * List<Employee> employees = employeeService.getAllEmployees(); // Service
 * method to fetch all employees if (employees.isEmpty()) { return
 * ResponseEntity.noContent().build(); // No employees found } return
 * ResponseEntity.ok(employees); // Return all employees }
 * 
 * // Soft delete employee
 * 
 * @DeleteMapping("/{id}") public ResponseEntity<Void>
 * softDeleteEmployee(@PathVariable Long id) { try {
 * employeeService.softDeleteEmployee(id); // Soft delete employee return
 * ResponseEntity.noContent().build(); // Return no content after successful
 * soft delete } catch (RuntimeException e) { return
 * ResponseEntity.notFound().build(); // Employee not found } } }
 */