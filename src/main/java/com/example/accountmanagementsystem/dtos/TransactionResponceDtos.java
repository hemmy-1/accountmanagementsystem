package com.example.accountmanagementsystem.dtos;


import java.time.LocalDateTime;
import jakarta.persistence.*;


public class TransactionResponceDtos {
  
        private String id;
    
        public enum TransactionType {
            DEPOSIT, WITHDRAWAL
        }
    
        private int amount;
        private String description;
    
        @Column(name = "transaction_date", nullable = false, updatable = false)
        private LocalDateTime transactionDate;
    
        @Enumerated(EnumType.STRING)
        private TransactionType transactionType;
    
        // Many transactions belong to one account
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "account_id", nullable = false)
        private Account account;
    
        // Mandatory default constructor for Hibernate
        public Transaction() {
        }
    
        public Transaction(int amount, String description, TransactionType transactionType, Account account) {
            this.amount = amount;
            this.description = description;
            this.transactionType = transactionType;
            this.account = account;
        }
    
        @PrePersist
        protected void onCreate() {
            this.transactionDate = LocalDateTime.now();
        }
    
    
        public String getId() {
            return id;
        }
    
        public void setId(String id) {
            this.id = id;
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
    
        public TransactionType getTransactionType() {
            return transactionType;
        }
    
        public void setTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
        }
    
        public Account getAccount() {
            return account;
        }
    
        public void setAccount(Account account) {
            this.account = account;
        }
    }




