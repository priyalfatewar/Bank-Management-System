package com.tcs.Bank.service;


import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Bank.dao.AccountRepository;
import com.tcs.Bank.model.Account;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create a new account with random details
    public Account createAccount(String SSNId,String accountName, String accountType,double balance) {
    	//System.out.println(SSNId + accountName +  accountType+ balance);
        Account account = new Account(SSNId,accountName, accountType, balance);
        return accountRepository.save(account);
    }

    // Get account by SSNId
    public Account getAccountBySSN(String ssnId) {
    	List<Account> dt = accountRepository.findAll();
    	for(Account i:dt) {
    		if(i.getSSNId().equalsIgnoreCase(ssnId)) {
    			Account dt1 = i;
    			return dt1;
    		}
    	}
        return null;
    }

    // Update account name by SSNId
    public Account updateAccountName(String SSNId, String newAccountName) {
        Optional<Account> accountOptional = accountRepository.findById(SSNId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setAccountName(newAccountName);
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    // Update account type by SSNId
    public Account updateAccountType(String SSNId, String newAccountType) {
        Optional<Account> accountOptional = accountRepository.findById(SSNId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setAccountType(newAccountType);
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    // Method to delete an account by SSNId
    public void deleteAccount(String SSNId) {
        accountRepository.deleteById(SSNId);
    }
    public Account softDeleteAccount(String SSNId) throws AccountNotFoundException {
        Optional<Account> account = accountRepository.findById(SSNId);
        if (account.isPresent()) {
        	Account account1 = account.get();
            account1.setStatus("DELETED");  
            accountRepository.save(account1);
            return account1;// Update the account in the DB
        } else {
            throw new AccountNotFoundException("Account not found for SSN: " + SSNId);
        }
		
    }
}
