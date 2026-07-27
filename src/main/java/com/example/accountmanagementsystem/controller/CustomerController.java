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
    private CustomerInfoRepo customerInfoRepo;

    public CustomerController(CustomerService customerService, CustomerInfoRepo customerInfoRepo) {
        this.customerService = customerService;
        this.customerInfoRepo = customerInfoRepo;
    }

    @PostMapping("/create")
    public CustomerInfoResponseDtos createBankAccount(@RequestBody CustomerInfoRequestDtos customers) {

        CustomerInfo addCustomers = new CustomerInfo();

        addCustomers.setFirstName(customers.getFirstName());
        addCustomers.setLastName(customers.getLastName());
        addCustomers.setPhoneNum(customers.getPhoneNum());
        addCustomers.setAddress(customers.getAddress());
        addCustomers.setEmail(customers.getEmail());

        customerInfoRepo.save(addCustomers);
        return new CustomerInfoResponseDtos();
    };

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