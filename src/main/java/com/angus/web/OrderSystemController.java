package com.angus.web;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.Order;
import com.angus.service.CustomerService;
import com.angus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderSystemController
{

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String ADD_NEW_CUSTOMER = "addNewCustomer";
    private static final String ORDER_SYSTEM_SHOW = "orderSystemShow";
    private static final String EDIT_CUSTOMER_INFO = "editCustomerInfo";

    @Autowired
    private OrderService orderService;
    ;
    @Autowired
    private HttpSession httpSession;

    /**
     * 展示登陆界面
     * 该方法中的user给前台返回
     * @return
     */
    @RequestMapping("/orderSystemShow")
    public String showOrderList(ModelMap map) {

        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    private void getAllOrders(ModelMap map) {

        List<Order> orderList = new ArrayList<Order>();
        orderList = orderService.getAllOrders();
        map.put("orderList", orderList);
    }

    @RequestMapping("/addNewCustomerShow")
    private String addNewCustomerShow(Customer customer) {

        return ADD_NEW_CUSTOMER;
    }

    @RequestMapping("/addNewCustomer")
    public String addNewUser(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        orderService.addNewOrder(order);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/editCustomerInfo")
    public String editUserInfo(HttpServletRequest request, @ModelAttribute("order") Order order) {


        Order currentOrder = orderService.getOrderById(order.getId());
        order.setId(currentOrder.getId());
        order.setCharge(currentOrder.getCharge());
        order.setMoneySituation(currentOrder.getMoneySituation());
        order.setOrderDate(currentOrder.getOrderDate());
        order.setOrderNumber(currentOrder.getOrderNumber());
        order.setServiceProject(currentOrder.getServiceProject());
        order.setServiceStatus(currentOrder.getServiceStatus());

        return EDIT_CUSTOMER_INFO;
    }

    @RequestMapping("/updateCustomer")
    public String updateUser(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        orderService.updateOrder(order);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/deleteCurrentCustomer")
    public String deleteCustomer(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        orderService.deleteOrderById(order.getId());
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }
}
