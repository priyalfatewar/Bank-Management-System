package com.example.bankmanager.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    
    private String name;
    private String position;
    private String department;
    private Double salary;
    private String status;  // New field added

    // Default constructor
    public Employee() {}

    // Constructor without 'id' since it's auto-generated
    public Employee(String name, String position, String department, Double salary, String status) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.status = status;  // Initialize the 'status' field
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}