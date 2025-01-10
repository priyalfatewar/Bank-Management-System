package com.tcs.Bank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.Bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    // You can define custom query methods if needed, e.g.:
    //Optional<Account> findByAccountNumber(String accountNumber);
	
	
}
