package com.angus.dao.mapper;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.Order;
import java.util.List;

public interface OrderMapper
{

    List<Order> getAllOrders ();

    void addNewOrder (Order order);

    Order getOrderById (Integer id);

    void deleteOrderById (Integer id);

    void updateOrder (Order order);
}
