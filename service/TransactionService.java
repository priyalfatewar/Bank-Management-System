package com.tcs.Bank.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Bank.dao.AccountRepository;
import com.tcs.Bank.dao.TransactionRepository;
import com.tcs.Bank.model.Account;
import com.tcs.Bank.model.Transaction;

@Service
public class TransactionService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	
//	public String transferMoney(String senderAccountNumber, String receiverAccountNumber, double amount, String senderIfscCode, String receiverIfscCode) {
//        // Retrieve the sender and receiver accounts
//		List<Account> senderO = accountRepository.findAll();
//        
//        List<Account> receiverO = accountRepository.findAll();
//        System.out.println(senderAccountNumber);
//        System.out.println(senderO.get(0));
//        // Check if both sender and receiver accounts exist
//        if (senderO.isEmpty() || receiverO.isEmpty()) {
//            return "Sender or Receiver account not found.";
//        }
//        Account sender = null;
//        Account receiver=null;
//        for(Account i: senderO) {
//        	
//        	if(i.getAccountNumber().trim().equalsIgnoreCase(senderAccountNumber.trim())) {
//        	 sender = i;
//        	 System.out.println(i.getAccountName());
//        	 break;
//        	}
//        }
//        for(Account i: receiverO) {
//        	if(i.getAccountNumber().trim().equalsIgnoreCase(senderAccountNumber.trim())) {
//        		 receiver = i;
//        	}
//        }
//        
//      
//
//        // Check if the sender has sufficient balance
//        if (sender.getBalance() < amount) {
//            return "Insufficient balance in sender's account.";
//        }
//
//        // Deduct the amount from the sender's account
//        sender.setBalance(sender.getBalance() - amount);
//        accountRepository.save(sender);
//
//        // Add the amount to the receiver's account
//        receiver.setBalance(receiver.getBalance() + amount);
//        accountRepository.save(receiver);
//
//        // Create a new transaction
//        Transaction transaction = new Transaction(receiverIfscCode, receiverIfscCode, amount, receiverIfscCode, receiverIfscCode);
//        transaction.setTransactionStatus("Success");
//        transactionRepository.save(transaction);
//
//        return "Transaction successful!";
//        }
        
	
	
	public String transferMoney(String senderAccountNumber, String receiverAccountNumber, 
            double amount, String senderIfscCode, String receiverIfscCode) {
// Retrieve the sender and receiver accounts
List<Account> senderO = accountRepository.findAll();
List<Account> receiverO = accountRepository.findAll();

// Check if both sender and receiver accounts exist
if (senderO.isEmpty() || receiverO.isEmpty()) {
return "Sender or Receiver account not found.";
}

Account sender = null;
Account receiver = null;

// Find sender and receiver accounts
for (Account account : senderO) {
if (account.getAccountNumber().trim().equalsIgnoreCase(senderAccountNumber.trim())) {
sender = account;
break;
}
}
for (Account account : receiverO) {
if (account.getAccountNumber().trim().equalsIgnoreCase(receiverAccountNumber.trim())) {
receiver = account;
break;
}
}

// Check if sender or receiver was not found
if (sender == null || receiver == null) {
return "Sender or Receiver account not found.";
}

// Check if the sender has sufficient balance
if (sender.getBalance() < amount) {
return "Insufficient balance in sender's account.";
}

// Deduct the amount from the sender's account
sender.setBalance(sender.getBalance() - amount);
accountRepository.save(sender);

// Add the amount to the receiver's account
receiver.setBalance(receiver.getBalance() + amount);
accountRepository.save(receiver);

// Create a new transaction and save it
Transaction transaction = new Transaction(senderAccountNumber, receiverAccountNumber, amount, senderIfscCode, receiverIfscCode);
transaction.setTransactionStatus("Success");
transactionRepository.save(transaction);

return "Transaction successful!";
}

	
	
	
	
	
	
	
        public List<Transaction> getTransactionHistory() {
            return transactionRepository.findAll();
        }
        public List<Transaction> getTransactionHistoryByUser(String saccno) {
            return transactionRepository.findBySenderAccountNumber(saccno);
         }


        public double getBalance(String accountNumber) {
            // Retrieve all accounts
            List<Account> allAccounts = accountRepository.findAll();

            // Iterate through the list to find the account with the matching account number
            for (Account account : allAccounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account.getBalance();  // Return the balance if account is found
                }
            }

            // If the account is not found, return 0.0 or throw an exception if preferred
            return 0.0;  // Default value when account is not found
        }


	
    }

