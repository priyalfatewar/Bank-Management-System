package com.tcs.Bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.Bank.model.Account;
import com.tcs.Bank.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can add custom queries if needed, for example:
     List<Transaction> findBySenderAccountNumber(String senderAccountNumber);
     //List<Account> findByAccountNumber(String accountNumber);
}
