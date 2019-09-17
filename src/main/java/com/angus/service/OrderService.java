package com.angus.service;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.Order;

import java.util.List;

public interface OrderService
{

    List<Order> getAllOrders();

    void addNewOrder(Order order);

    Order getOrderById(Integer id);

    void updateOrder(Order order);

    void deleteOrderById(Integer id);
}
