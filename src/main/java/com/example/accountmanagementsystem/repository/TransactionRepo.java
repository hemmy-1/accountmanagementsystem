package com.example.accountmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountmanagementsystem.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

    List<Transaction> findByAccountAccountId(int accountId);

    List<Transaction> findByAccountAccountNum(int accountNum);
    
    boolean existsByAccountNum(int accountNum);

}