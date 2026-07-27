package com.example.accountmanagementsystem.controller;

import com.example.accountmanagementsystem.dtos.AccountRequestDto;
import com.example.accountmanagementsystem.dtos.AccountResponseDto;
import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.enums.AccountType;
import com.example.accountmanagementsystem.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

   
    @PostMapping("/create")
    public AccountResponseDto createBankAccount(@RequestBody AccountRequestDto cAccount ) {
        int customerId = cAccount.getCustomerId();
        AccountType type = cAccount.getAccountType();
        int initialBalance = cAccount.getInitialBalance();
        

        AccountResponseDto createAcc = accountService.createAccount(customerId, type, initialBalance);
        return createAcc;
    }
    
    

    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getCustomerAccounts(@PathVariable int customerId) {
        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }


}