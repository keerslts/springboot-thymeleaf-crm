package com.angus.service;

import com.angus.dao.pojo.Order;
import com.angus.dao.pojo.OrderCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface OrderService
{

    List<Order> getAllOrders();

    void addNewOrder(Order order);

    Order getOrderById(Integer id);

    void updateOrder(Order order);

    void deleteOrderById(Integer id);

    List<Map> getAllOrderCustomers();

    List<Map> getOrderCustomerById(Integer id);

    void updateRelatedCustomer(OrderCustomer orderCustomer);

    void insertRelatedCustomer(OrderCustomer orderCustomer);

    Integer getResOrderCustomer(OrderCustomer orderCustomer);

    void deleteResOrderCustomerByOrderId(Integer orderId);

    ArrayList<Integer> getLastOrderNumber();

    int getOrderByEncode(String orderEncode);

    List<Map> getOrderCustomersByCustomerId(Integer customerId);
}
