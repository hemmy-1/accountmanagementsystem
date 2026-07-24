package com.example.accountmanagementsystem.entity;

import java.time.LocalDateTime;

import com.example.accountmanagementsystem.enums.TransactionType;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public TransactionType tranctionType;

    private int amount;
    private String description;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction() {
    }

    public Transaction(int amount, String description, Account account, TransactionType transactionType) {
        this.amount = amount;
        this.description = description;
        this.tranctionType = transactionType;
        this.account = account;
    }

    public TransactionType getTranctionType() {
        return tranctionType;
    }

    public void setTranctionType(TransactionType tranctionType) {
        this.tranctionType = tranctionType;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}