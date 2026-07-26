package com.example.accountmanagementsystem.dtos;

import com.example.accountmanagementsystem.enums.TransactionType;


public class TransactionRequestDto {

    private Integer accountNum;
    private Integer amount;   
    private TransactionType transactionType;
    private String description;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(Integer accountNum, Integer amount, TransactionType transactionType,
            String description) {
        this.accountNum = accountNum;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
    }


    public Integer getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}