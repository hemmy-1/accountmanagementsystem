package com.example.accountmanagementsystem.dtos;

import com.example.accountmanagementsystem.enums.AccountType;


public class AccountRequestDto {

    private Integer customerId;
    private AccountType accountType;
    private Integer initialBalance;

    public AccountRequestDto() {
    }

 
    public AccountRequestDto(Integer customerId, AccountType accountType, Integer initialBalance) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Integer getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Integer initialBalance) {
        this.initialBalance = initialBalance;
    }
}