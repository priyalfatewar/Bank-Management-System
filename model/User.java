package com.example.Sprint4.model;

import java.time.LocalDate;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") 
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-increment ID
    private String ssnid;  // Auto-generated ID for SSN

    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateofbirth;
    private String aadharNumber;  // 12 digits Aadhar number
    private String panNumber;  // PAN number (matches PAN format)
    private String password;  // Password (will be hashed before saving)
    private boolean isDeleted=false;
    

	// Removed confirmPassword from the entity
    private transient String confirmPassword;  // Only used for validation purposes (not stored in DB)

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor for convenience
    public User(String firstname, String lastname, String email, LocalDate dateofbirth, String aadharNumber,
                String panNumber, String password,boolean isdeleted) {
        this.ssnid=generateRandomSSNId();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.password = password;
        this.isDeleted=false;
       
    }
//     Generate random SSNId (e.g., "SSN123456789")
  private String generateRandomSSNId() {
      String randomSSN = "SSN" + String.format("%09d", new Random().nextInt(1000000000));
      return randomSSN;
  }
    
    public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
    // Getters and Setters
    public String getSsnid() {
        return ssnid;
    }

    public void setSsnid(String ssnid) {
        this.ssnid = ssnid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
