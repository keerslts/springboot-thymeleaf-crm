package com.angus.service;

import com.angus.dao.pojo.Customer;

import java.util.List;

public interface CustomerService
{

    List<Customer> getAllCustomers();

    void addNewCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    void updateFollowRecord(Customer customer);
}
