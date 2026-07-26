package com.example.accountmanagementsystem.dtos;

import java.time.LocalDateTime;
import com.example.accountmanagementsystem.enums.AccountStatus;
import com.example.accountmanagementsystem.enums.AccountType;

public class AccountResponseDto {

    private int accountId;
    private int accountNum;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private int accountBalance;
    private LocalDateTime createdAt;

    // Instead of the whole entity, include light customer details
    private int customerId;
    private String customerName;

    // Default Constructor
    public AccountResponseDto() {
    }

    // All-Args Constructor
    public AccountResponseDto(int accountId, int accountNum, AccountType accountType,
            AccountStatus accountStatus, int accountBalance,
            LocalDateTime createdAt, int customerId, String customerName) {
        this.accountId = accountId;
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.createdAt = createdAt;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    // --- GETTERS AND SETTERS ---

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}