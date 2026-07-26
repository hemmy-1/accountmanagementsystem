package com.example.accountmanagementsystem.service;

import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.entity.Account.AccountStatus;
import com.example.accountmanagementsystem.entity.Transaction;
import com.example.accountmanagementsystem.enums.TransactionType;
import com.example.accountmanagementsystem.repository.AccountRepo;
import com.example.accountmanagementsystem.repository.TransactionRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;
    private final AccountRepo accountRepo;

    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

   
    @Transactional
    public Transaction deposit(int accountNum, int amount, String description) {
        // Rule: Deposit amount must be greater than zero
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        Account account = accountRepo.findByAccountNum(accountNum) 
        
                .orElseThrow(() -> new RuntimeException("Account not found with account number: " + accountNum));


        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot deposit into an inactive or closed account.");
        }

        account.setAccountBalance(account.getAccountBalance() + amount);
        accountRepo.save(account);

        // Rule: Create and save transaction record
        Transaction transaction = new Transaction(
                amount,
                // (description != null) ? description : "Deposit",
                "des",
                account,
                TransactionType.DEPOSIT
            );

        return transactionRepo.save(transaction);
    }

   
    @Transactional
    public Transaction withdraw(int accountNum, int amount, String description) {
        // Rule: Withdrawal amount must be greater than zero
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        Account account = accountRepo.findByAccountNum(accountNum)
                .orElseThrow(() -> new RuntimeException("Account not found with account number: " + accountNum));


                if (account.getStatus() != Account.AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot withdraw from an inactive or closed account.");
        }

        // Rule: Account must have sufficient balance
        if (account.getAccountBalance() < amount) {
            throw new IllegalArgumentException(
                    "Insufficient funds. Current balance is: " + account.getAccountBalance());
        }

        // Rule: Update account balance
        account.setAccountBalance(account.getAccountBalance() - amount);
        accountRepo.save(account);

        // Rule: Create transaction record
        Transaction transaction = new Transaction(
                amount,
                description != null ? description : "Withdrawal",
                account, TransactionType.WITHDRAWAL
             );

        return transactionRepo.save(transaction);
    }

    

    
    public List<Transaction> getTransactionHistory(int accountNum) {
        if (accountRepo.existsByAccountNum(accountNum)) {
            throw new RuntimeException("Account not found with account number: " + accountNum);
        } 
        if(transactionRepo.existsByAccountNum(accountNum)){
            throw new RuntimeException("no transaction found");
        }
        return transactionRepo.findByAccountAccountNum(accountNum);
    }
}