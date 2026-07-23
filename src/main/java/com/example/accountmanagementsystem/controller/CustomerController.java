package com.example.accountmanagementsystem.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.accountmanagementsystem.service.CustomerService;


@RestController

public class CustomerController {
    CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    
}
