package com.angus.dao.mapper;

import com.angus.dao.pojo.Customer;
import java.util.List;


public interface CustomerMapper
{

    List<Customer> getAllCustomers();

    void addNewCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);

    void updateCustomer(Customer customer);

    void updateFollowRecord(Customer customer);
}
