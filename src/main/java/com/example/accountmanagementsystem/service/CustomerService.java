package com.example.accountmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.accountmanagementsystem.entity.Account;
import com.example.accountmanagementsystem.entity.CustomerInfo;
import com.example.accountmanagementsystem.repository.CustomerInfoRepo;

@Service
public class CustomerService {
    private CustomerInfoRepo customerInfoRepo;

    public CustomerService(CustomerInfoRepo customerInfoRepo){
        this.customerInfoRepo = customerInfoRepo;
    }

    public void addCustomer(CustomerInfo customerInfo){
        customerInfoRepo.save(customerInfo);
    }

    public List<CustomerInfo> allCustomer(){
        return customerInfoRepo.findAll();
    }

    public CustomerInfo findCustomerById(int customerId){
        return customerInfoRepo.findById(customerId).orElseThrow(() -> new RuntimeException("no Customer with id:" + customerId + "available"));
    }

    public String updateCustomerInfo(CustomerInfo cInfo, int customerId){
        CustomerInfo existingCustomer = customerInfoRepo.findById(customerId).orElseThrow(() -> new RuntimeException("no Customer with id:" + customerId + "available"));


        existingCustomer.setFirstName(cInfo.getFirstName());
        existingCustomer.setLastName(cInfo.getLastName());
        existingCustomer.setAddress(cInfo.getAddress());
        existingCustomer.setEmail(cInfo.getEmail());
        existingCustomer.setPhoneNum(cInfo.getPhoneNum());

        customerInfoRepo.save(existingCustomer);


        return "customer with id:" + customerId +"successfuly updated";
        
    }

    public String deleteStudentById(int customerId){
        customerInfoRepo.deleteById(customerId);

        return "account with id: " + customerId + "has been deleted successfuly";
    }


    public List<Account> getAccountByEmail(String email){
        return customerInfoRepo.findAccountByEmail(email);
    }

}
