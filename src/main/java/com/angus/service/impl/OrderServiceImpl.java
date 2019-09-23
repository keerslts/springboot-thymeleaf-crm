package com.angus.service.impl;

import com.angus.dao.mapper.CustomerMapper;
import com.angus.dao.mapper.OrderMapper;
import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.Order;
import com.angus.service.CustomerService;
import com.angus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrders ()
    {
        return orderMapper.getAllOrders();
    }

    @Override
    public void addNewOrder (Order order)
    {
        orderMapper.addNewOrder(order);
    }

    @Override
    public Order getOrderById (Integer id)
    {
        return orderMapper.getOrderById(id);
    }

    @Override
    public void updateOrder (Order order)
    {
        orderMapper.updateOrder(order);
    }

    @Override
    public void deleteOrderById (Integer id)
    {
        orderMapper.deleteOrderById(id);
    }
}
