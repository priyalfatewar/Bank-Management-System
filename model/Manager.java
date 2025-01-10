package com.example.demo.model;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;



@Entity

public class Manager {



  @Id

  @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generated ID

  private Long id;



  private String firstName;

  private String lastName;

  private String email; // Email is now just a normal field, not a unique identifier

  private String department;

  private boolean deleted;



  public boolean isDeleted() {

		return deleted;

	}



	public void setDeleted(boolean deleted) {

		this.deleted = deleted;

	}



	// Constructors, Getters, and Setters

  public Manager() {}



  public Manager(String firstName, String lastName, String email, String department) {

    this.firstName = firstName;

    this.lastName = lastName;

    this.email = email;

    this.department = department;

    this.deleted=deleted;

  }



  public Long getId() {

    return id;

  }



  public void setId(Long id) {

    this.id = id;

  }



  public String getFirstName() {

    return firstName;

  }



  public void setFirstName(String firstName) {

    this.firstName = firstName;

  }



  public String getLastName() {

    return lastName;

  }



  public void setLastName(String lastName) {

    this.lastName = lastName;

  }



  public String getEmail() {

    return email;

  }



  public void setEmail(String email) {

    this.email = email;

  }



  public String getDepartment() {

    return department;

  }



  public void setDepartment(String department) {

    this.department = department;

  }

}











/*

 * package com.example.demo.model;

 * 

 * 

 * import jakarta.persistence.Entity;

 * 

 * import jakarta.persistence.GeneratedValue;

 * 

 * import jakarta.persistence.GenerationType;

 * 

 * import jakarta.persistence.Id;

 * 

 * 

 * 

 * @Entity

 * 

 * public class Manager {

 * 

 * 

 * 

 * @Id

 * 

 * @GeneratedValue(strategy = GenerationType.IDENTITY)

 * 

 * private Long id;

 * 

 * 

 * 

 * private String name;

 * 

 * private String mobileNumber;

 * 

 * private String emailAddress;

 * 

 * private String employeeId;

 * 

 * 

 * 

 * // Constructors

 * 

 * public Manager() {}

 * 

 * 

 * 

 * public Manager(String name, String mobileNumber, String emailAddress, String

 * employeeId) {

 * 

 * this.name = name;

 * 

 * this.mobileNumber = mobileNumber;

 * 

 * this.emailAddress = emailAddress;

 * 

 * this.employeeId = employeeId;

 * 

 * }

 * 

 * 

 * 

 * // Getters and Setters

 * 

 * public Long getId() {

 * 

 * return id;

 * 

 * }

 * 

 * 

 * 

 * public void setId(Long id) {

 * 

 * this.id = id;

 * 

 * }

 * 

 * 

 * 

 * public String getName() {

 * 

 * return name;

 * 

 * }

 * 

 * 

 * 

 * public void setName(String name) {

 * 

 * this.name = name;

 * 

 * }

 * 

 * 

 * 

 * public String getMobileNumber() {

 * 

 * return mobileNumber;

 * 

 * }

 * 

 * 

 * 

 * public void setMobileNumber(String mobileNumber) {

 * 

 * this.mobileNumber = mobileNumber;

 * 

 * }

 * 

 * 

 * 

 * public String getEmailAddress() {

 * 

 * return emailAddress;

 * 

 * }

 * 

 * 

 * 

 * public void setEmailAddress(String emailAddress) {

 * 

 * this.emailAddress = emailAddress;

 * 

 * }

 * 

 * 

 * 

 * public String getEmployeeId() {

 * 

 * return employeeId;

 * 

 * }

 * 

 * 

 * 

 * public void setEmployeeId(String employeeId) {

 * 

 * this.employeeId = employeeId;

 * 

 * }

 * 

 * }

 */