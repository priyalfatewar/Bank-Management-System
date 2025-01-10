package com.tcs.Bank.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.Bank.model.Account;
import com.tcs.Bank.service.AccountService;

// Allow requests from Angular frontend (localhost:4200)
@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) 
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create a new account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
    	//System.out.println(account.getSSNId() + account.getAccountName()+ account.getAccountType()+ account.getBalance());
        return accountService.createAccount(account.getSSNId(),account.getAccountName(), account.getAccountType(), account.getBalance());
    }

    // Get account by SSN
    @GetMapping("/{ssnId}")
    public ResponseEntity<Account> getAccount(@PathVariable("ssnId") String ssnId) {
    	System.out.println(ssnId);
        Account account = accountService.getAccountBySSN(ssnId);
      System.out.println(account.getSSNId() + account.getAccountName()+ account.getAccountType()+ account.getBalance());
        if (account == null || account.getStatus() == "DELETED") {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Account not found or deleted
        }
        return ResponseEntity.ok(account);
    }

    @PutMapping("/update/{SSNId}/name")
    public Account updateAccountName(@PathVariable String SSNId, @RequestParam String newAccountName) {
        return accountService.updateAccountName(SSNId, newAccountName);
    }

    @PutMapping("/update/{SSNId}/type")
    public Account updateAccountType(@PathVariable String SSNId, @RequestParam String newAccountType) {
        return accountService.updateAccountType(SSNId, newAccountType);
    }

    // Delete account
    @DeleteMapping("/{SSNId}")
    public Account deleteAccount(@PathVariable String SSNId)  {
        
		try {
			return accountService.softDeleteAccount(SSNId);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
