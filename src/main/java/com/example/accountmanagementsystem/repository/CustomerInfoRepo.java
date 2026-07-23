package com.example.accountmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.entity.CustomerInfo;

public interface CustomerInfoRepo extends JpaRepository<CustomerInfo, Integer>{

    List<Account> findAccountByEmail(String email);

} 
