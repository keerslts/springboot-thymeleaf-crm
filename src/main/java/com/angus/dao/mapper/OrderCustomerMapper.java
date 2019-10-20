package com.angus.dao.mapper;

import com.angus.dao.pojo.Order;
import com.angus.dao.pojo.OrderCustomer;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

public interface OrderCustomerMapper
{

    List<Map> getAllOrderCustomers();

    List<Map> getOrderCustomerById(Integer id);

    void updateRelatedCustomer(Integer Id, Integer customerId);

    void insertRelatedCustomer(Integer orderId, Integer customerId);

    Integer getResOrderCustomer(Integer customerId, Integer orderId);

    void deleteResOrderCustomerByOrderId(Integer orderId);
}
