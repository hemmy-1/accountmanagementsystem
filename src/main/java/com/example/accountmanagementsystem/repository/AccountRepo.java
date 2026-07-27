package com.example.accountmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountmanagementsystem.entity.Account;


public interface AccountRepo extends JpaRepository<Account, Integer> {

    Optional<Account> findByAccountNum(int accountNum);
    
    boolean existsByAccountNum(int accountNum);
    
    List<Account> findByCustomerInfoCustomerId(int customerId);

    
} 
