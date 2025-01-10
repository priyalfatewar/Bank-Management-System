package com.example.bankmanager.repository;

import com.example.bankmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find all employees who are not deleted
    List<Employee> findByStatusNot(String status);  // Exclude employees with status 'DELETED'

    // Optionally, you can also add a method to get only active employees if needed
    List<Employee> findByStatus(String status);
}
