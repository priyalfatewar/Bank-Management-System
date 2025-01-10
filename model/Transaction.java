package com.tcs.Bank.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;  
    //private String SSNId;
    private String senderAccountNumber; 
    private String receiverAccountNumber;  
    private double amount;  
    private Date transactionDate;  // This stores the date of the transaction
    private String senderIfscCode;  
    public String receiverIfscCode;  
    private String transactionStatus;  // Status like "Pending", "Completed", "Failed"

    // Default constructor (required by JPA)
    public Transaction() {}

    // Constructor to create a new transaction
    public Transaction(String senderAccountNumber, String receiverAccountNumber, double amount, String senderIfscCode, String receiverIfscCode) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.senderIfscCode = senderIfscCode;
        this.receiverIfscCode = receiverIfscCode;
        this.transactionDate = new Date(System.currentTimeMillis());  // Set the transaction date to current time
        this.transactionStatus = "Pending";  // Initially set the transaction status to "Pending"
    }

    // Getters and Setters
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSenderIfscCode() {
        return senderIfscCode;
    }

    public void setSenderIfscCode(String senderIfscCode) {
        this.senderIfscCode = senderIfscCode;
    }

    public String getReceiverIfscCode() {
        return receiverIfscCode;
    }

    public void setReceiverIfscCode(String receiverIfscCode) {
        this.receiverIfscCode = receiverIfscCode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", senderAccountNumber='" + senderAccountNumber + '\'' +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", senderIfscCode='" + senderIfscCode + '\'' +
                ", receiverIfscCode='" + receiverIfscCode + '\'' +
                ", transactionStatus='" + transactionStatus + '\'' +
                '}';
    }

//	public static void main(String[] args) {
//		SSNId
//	}
}
