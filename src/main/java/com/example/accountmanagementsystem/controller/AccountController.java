package com.example.accountmanagementsystem.controller;

import com.example.accountmanagementsystem.dtos.AccountRequestDto;
import com.example.accountmanagementsystem.dtos.AccountResponseDto;
import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.enums.AccountType;
import com.example.accountmanagementsystem.repository.AccountRepo;
import com.example.accountmanagementsystem.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // POST Endpoint: Create account
    // Expects JSON body: { "customerId": 1, "accountType": "SAVINGS",
    // "initialBalance": 5000 }
    @PostMapping("/create")
    public AccountResponseDto createBankAccount(@RequestBody AccountRequestDto cAccount ) {
        int customerId = cAccount.getCustomerId();
        AccountType type = cAccount.getAccountType();
        int initialBalance = cAccount.getInitialBalance();
        

        AccountResponseDto createdAccount = accountService.createAccount(customerId, type, initialBalance);
        return AccountResponseDto;
    }
    
    public AccountResponseDto createBankAccount(@Valid @RequestBody AccountRequestDto cAccount) {

        // Pull the values out of the request DTO
        int customerId = cAccount.getCustomerId();
        AccountType type = cAccount.getAccountType();
        int initialBalance = cAccount.getInitialBalance();

        // Pass them to your service
        AccountResponseDto createdAccount = accountService.createAccount(customerId, type, initialBalance);

        onseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getCustomerAccounts(@PathVariablreturn new Respe int customerId) {
        List<Account> accounts = accountService.getAccountsByCustomer(customerId);
        return ResponseEntity.ok(accounts);
    }
}