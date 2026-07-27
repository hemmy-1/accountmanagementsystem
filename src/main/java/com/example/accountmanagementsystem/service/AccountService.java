package com.example.accountmanagementsystem.service;

import java.util.List;
import java.util.Random;

import com.example.accountmanagementsystem.dtos.AccountResponseDto;
import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.entity.CustomerInfo;
import com.example.accountmanagementsystem.enums.AccountStatus;
import com.example.accountmanagementsystem.enums.AccountType;
import com.example.accountmanagementsystem.repository.AccountRepo;
import com.example.accountmanagementsystem.repository.CustomerInfoRepo;

public class AccountService {
    private AccountRepo accountRepo;
    private CustomerInfoRepo customerInfoRepo;


    public AccountService(AccountRepo accountRepo, CustomerInfoRepo customerInfoRepo){
        this.accountRepo = accountRepo;
        this.customerInfoRepo = customerInfoRepo;     
    }

    public int createAccount(int customerId, AccountType type, int accountBalance){

        CustomerInfo customerInfo = customerInfoRepo.findById(customerId).orElseThrow(() -> new RuntimeException("No cu:" + customerId + "available"));

        Account newAccount = new Account();

        newAccount.setCustomerInfo(customerInfo);
        newAccount.setAccountType(type);
        newAccount.setAccountBalance(accountBalance);
        newAccount.setAccountStatus(AccountStatus.ACTIVE);

        int generatedNum = 1000000000 + new Random().nextInt(900000000);
        newAccount.setAccountNum(generatedNum);

         Account savedAccount = accountRepo.save(newAccount);
        return savedAccount.getAccountNum();
    }


    public Account getAccountByAccountNumber(int accountNum) {
        return accountRepo.findByAccountNum(accountNum).orElseThrow(() -> new RuntimeException("There is no registered account with the account number: " + accountNum));
    }


    public List<Account> getAllAccount(){
        return accountRepo.findAll();
    }

    public void closeAccountById(int accountId) {
        Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));
        
        account.setAccountStatus(AccountStatus.CLOSED);
        accountRepo.save(account);
    }


}
