package com.angus.dao.mapper;

import com.angus.dao.pojo.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderMapper
{

    List<Order> getAllOrders ();

    void addNewOrder (Order order);

    Order getOrderById (Integer id);

    void deleteOrderById (Integer id);

    void updateOrder (Order order);

    ArrayList<Integer> getLastOrderNumber();

    int getOrderByEncode(String orderEncode);
}
