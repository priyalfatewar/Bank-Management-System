package com.tcs.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.Bank.model.Transaction;
import com.tcs.Bank.service.TransactionService;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/transactions")
//@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) 

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Transfer money from one account to another

//    @PostMapping("/transfer")
//    public String transferMoney(@RequestBody Transaction transaction) {
//        return transactionService.transferMoney(transaction.getSenderAccountNumber(), 
//                                                transaction.getReceiverAccountNumber(), 
//                                                transaction.getAmount(), 
//                                                transaction.getSenderIfscCode(), 
//                                                transaction.getReceiverIfscCode());
//    }
//
//
//    // Get all transactions (transaction history)
//    @GetMapping("/history")
//    public List<Transaction> getTransactionHistory() {
//        return transactionService.getTransactionHistory();
//    }

    // Get balance of a specific accoun
    
    @CrossOrigin("*")
    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody Transaction transaction) {
        // Call the transferMoney service method
        String result = transactionService.transferMoney(
                transaction.getSenderAccountNumber(), 
                transaction.getReceiverAccountNumber(), 
                transaction.getAmount(), 
                transaction.getSenderIfscCode(), 
                transaction.getReceiverIfscCode()
        );
        
        // Return the result as a response
        return ResponseEntity.ok(result);
    }

    @GetMapping("/balance/{accountNumber}")
    public double getBalance(@PathVariable String accountNumber) throws AccountNotFoundException {
        return transactionService.getBalance(accountNumber);
    }
    @GetMapping("/history/{accountNumber}")
    public List<Transaction> hisorybyuser(@PathVariable String accountnumber) {
    	return transactionService.getTransactionHistoryByUser(accountnumber);
    }
}
