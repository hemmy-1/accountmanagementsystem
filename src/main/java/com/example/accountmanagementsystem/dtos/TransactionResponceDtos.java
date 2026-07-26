package com.example.accountmanagementsystem.dtos;


import java.time.LocalDateTime;

import com.example.accountmanagementsystem.enums.TransactionType;



public class TransactionResponceDtos {
  
        private String id;
        TransactionType transactionType2;
        private int amount;
        private String description;
        private LocalDateTime transactionDate;
        private int accountNum;
    
            public TransactionResponceDtos() {
        }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public TransactionType getTransactionType2() {
                return transactionType2;
            }

            public void setTransactionType2(TransactionType transactionType2) {
                this.transactionType2 = transactionType2;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public LocalDateTime getTransactionDate() {
                return transactionDate;
            }

            public void setTransactionDate(LocalDateTime transactionDate) {
                this.transactionDate = transactionDate;
            }

            public int getAccountNum() {
                return accountNum;
            }

            public void setAccountNum(int accountNum) {
                this.accountNum = accountNum;
            }
        
    
        
    }




