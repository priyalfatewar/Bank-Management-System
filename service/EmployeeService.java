package com.example.bankmanager.service;

import com.example.bankmanager.model.Employee;
import com.example.bankmanager.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update employee by ID
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);

        // Check if employee exists
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();

            // Boolean flag to check if any field is updated
            boolean isUpdated = false;

            // Only update the fields that have changed (i.e., different from existing values)
            
            // Check if the name is different and non-empty (do not update with empty name)
            if (updatedEmployee.getName() != null && !updatedEmployee.getName().isEmpty() && !updatedEmployee.getName().equals(existingEmployee.getName())) {
                existingEmployee.setName(updatedEmployee.getName());
                isUpdated = true;
            }

            // Check if the position is different and non-empty (do not update with empty position)
            if (updatedEmployee.getPosition() != null && !updatedEmployee.getPosition().isEmpty() && !updatedEmployee.getPosition().equals(existingEmployee.getPosition())) {
                existingEmployee.setPosition(updatedEmployee.getPosition());
                isUpdated = true;
            }

            // Check if the department is different and non-empty (do not update with empty department)
            if (updatedEmployee.getDepartment() != null && !updatedEmployee.getDepartment().isEmpty() && !updatedEmployee.getDepartment().equals(existingEmployee.getDepartment())) {
                existingEmployee.setDepartment(updatedEmployee.getDepartment());
                isUpdated = true;
            }

            // Check if the salary is different
            if (updatedEmployee.getSalary() != null && !updatedEmployee.getSalary().equals(existingEmployee.getSalary())) {
                existingEmployee.setSalary(updatedEmployee.getSalary());
                isUpdated = true;
            }

            // Check if the status is different
            if (updatedEmployee.getStatus() != null && !updatedEmployee.getStatus().equals(existingEmployee.getStatus())) {
                existingEmployee.setStatus(updatedEmployee.getStatus());
                isUpdated = true;
            }

            // If any field was updated, save the employee
            if (isUpdated) {
                return employeeRepository.save(existingEmployee);
            } else {
                // If no fields were updated, we can return the existing employee without saving
                return existingEmployee;
            }
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
    	
        List<Employee> res = employeeRepository.findAll();
        List<Employee> src = new ArrayList<>();
        String s = "active";
        
        for(Employee i: res) {
        	if(i.getStatus().equalsIgnoreCase(s)) {
        		src.add(i);
        	}
        }
        return src;
    }
    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findByStatus("active");  // Use the custom query to fetch active employees
    }

    // Soft delete employee by ID (mark as DELETED)
    public void softDeleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee empToDelete = employee.get();
            empToDelete.setStatus("deleted");  // Mark the employee as deleted
            employeeRepository.save(empToDelete);  // Save the updated employee with status 'DELETED'
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}
