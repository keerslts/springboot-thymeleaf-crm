package com.angus.service.impl;

import com.angus.dao.mapper.OrderCustomerMapper;
import com.angus.dao.mapper.OrderMapper;
import com.angus.dao.pojo.Order;
import com.angus.dao.pojo.OrderCustomer;
import com.angus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderCustomerMapper orderCustomerMapper;

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

    @Override
    public List<Map> getAllOrderCustomers() {

        return orderCustomerMapper.getAllOrderCustomers();
    }

    @Override
    public List<Map> getOrderCustomerById(Integer id) {
       return orderCustomerMapper.getOrderCustomerById(id);
    }

    @Override
    public void updateRelatedCustomer(OrderCustomer orderCustomer) {
        orderCustomerMapper.updateRelatedCustomer(orderCustomer.getId(),orderCustomer.getCustomer().getCustomerId());
    }

    @Override
    public void insertRelatedCustomer(OrderCustomer orderCustomer) {
        orderCustomerMapper.insertRelatedCustomer(orderCustomer.getOrder().getOrderId(),orderCustomer.getCustomer().getCustomerId());
    }

    @Override
    public Integer getResOrderCustomer(OrderCustomer orderCustomer) {
        return orderCustomerMapper.getResOrderCustomer(orderCustomer.getCustomer().getCustomerId(),orderCustomer.getOrder().getOrderId());
    }

    @Override
    public void deleteResOrderCustomerByOrderId(Integer orderId) {
        orderCustomerMapper.deleteResOrderCustomerByOrderId(orderId);
    }


}
