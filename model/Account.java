package com.tcs.Bank.model;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@Column(nullable = false, unique = true)
	 @JsonProperty("ssnId")
    private String SSNId;  // Randomly generated SSNId
	
    @Column(nullable = false, unique = true)
    private String AccountNumber;  // Randomly generated Account Number

    @Column(nullable = false)
    private String AccountName;

    @Column(nullable = false)
    private String IfscCode;  // Randomly generated IFSC Code

    @Column(nullable = false)
    private String AccountType;
    @Column(nullable = false)
    private Double balance;
    
    @Column(nullable = false)
    private String status;
    

    public void setBalance(Double balance) {
		this.balance = balance;
	}

	// Default constructor (required by JPA)
    public Account() {}

    // Parametrized constructor
    public Account(String SSNId,String accountName, String accountType, Double balance) {
        this.SSNId = SSNId;
        this.AccountNumber = generateRandomAccountNumber();
        this.IfscCode = generateRandomIfscCode();
        this.AccountName = accountName;
        this.AccountType = accountType;
        this.balance=balance;
        this.status= "Active";    }

    // Generate random SSNId (e.g., "SSN123456789")
//    private String generateRandomSSNId() {
//        String randomSSN = "SSN" + String.format("%09d", new Random().nextInt(1000000000));
//        return randomSSN;
//    }

    // Generate random Account Number (e.g., "1234567890")
    private String generateRandomAccountNumber() {
        return String.format("%10d", new Random().nextInt(1000000000));  // 10-digit account number
    }

    // Generate random IFSC Code (e.g., "HDFC0001234")
    private String generateRandomIfscCode() {
        String bankCode = "HDFC";  // Example: HDFC for HDFC Bank
        String branchCode = String.format("%04d", new Random().nextInt(10000));  // 4-digit branch code
        return bankCode + branchCode;
    }

    // Additional Method: Update Account Name
    public void updateAccountName(String newAccountName) {
        this.AccountName = newAccountName;
    }

    // Additional Method: Update Account Type
    public void updateAccountType(String newAccountType) {
        this.AccountType = newAccountType;
    }

    // Additional Method: Print Account Info
    public void printAccountInfo() {
        System.out.println("Account Info: ");
        System.out.println("SSNId: " + this.SSNId);
        System.out.println("Account Number: " + this.AccountNumber);
        System.out.println("Account Name: " + this.AccountName);
        System.out.println("IFSC Code: " + this.IfscCode);
        System.out.println("Account Type: " + this.AccountType);
    }

    // Getters and Setters
    public String getSSNId() {
        return SSNId;
    }

    public void setSSNId(String SSNId) {
        this.SSNId = SSNId;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getIfscCode() {
        return IfscCode;
    }

    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    // Override toString method for better readability
//    @Override
//    public String toString() {
//        return "Account{" +
//                "SSNId='" + SSNId + '\'' +
//                ", AccountNumber='" + AccountNumber + '\'' +
//                ", AccountName='" + AccountName + '\'' +
//                ", IfscCode='" + IfscCode + '\'' +
//                ", AccountType='" + AccountType + '\'' +
//                '}';
//    }

	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Enum for account status
    
}
