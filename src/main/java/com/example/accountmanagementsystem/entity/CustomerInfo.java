package com.example.accountmanagementsystem.entity;

public class CustomerInfo {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNum;
    private String address;

    public CustomerInfo(){

    }
    
    public CustomerInfo(int customerId, String firstName, String lastName, String email, int phoneNum, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

      

}
