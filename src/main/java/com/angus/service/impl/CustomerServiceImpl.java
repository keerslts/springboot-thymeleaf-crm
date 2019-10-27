package com.angus.service.impl;

import com.angus.dao.mapper.CustomerMapper;
import com.angus.dao.mapper.UserMapper;
import com.angus.dao.pojo.Customer;
import com.angus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomers() {

        return customerMapper.getAllCustomers();
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerMapper.addNewCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteCustomerById(id);
    }

    @Override
    public void updateFollowRecord(Customer customer) {
        customerMapper.updateFollowRecord(customer);
    }
}
