package com.example.accountmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountmanagementsystem.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
    
}