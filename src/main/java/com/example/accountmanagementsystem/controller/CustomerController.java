package com.example.accountmanagementsystem.controller;

import com.example.accountmanagementsystem.dtos.CustomerInfoRequestDtos;
import com.example.accountmanagementsystem.dtos.CustomerInfoResponseDtos;
import com.example.accountmanagementsystem.entity.CustomerInfo;
import com.example.accountmanagementsystem.repository.CustomerInfoRepo;
import com.example.accountmanagementsystem.service.CustomerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public CustomerInfoResponseDtos registerCustomer(@RequestBody CustomerInfoRequestDtos customers) {

       int id = customerService.addCustomer(customers);
         
        return new CustomerInfoResponseDtos(id, customers.getFirstName(), customers.getLastName(), customers.getEmail(), customers.getPhoneNum(), customers.getAddress() );
    }

    @GetMapping("/{customerId}")
    public CustomerInfo getCustomerById (@PathVariable int customerId) {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping("/all")
    public List<CustomerInfo> getAllCustomers(){
        return customerService.allCustomer();
    }


    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable int customerId, @RequestBody CustomerInfo customerInfo){
        return customerService.updateCustomerInfo(customerInfo, customerId);
    }


}