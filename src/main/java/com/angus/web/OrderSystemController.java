package com.angus.web;

import com.angus.dao.pojo.Order;
import com.angus.dao.pojo.OrderCustomer;
import com.angus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderSystemController
{

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String ADD_NEW_ORDER = "addNewOrder";
    private static final String ORDER_SYSTEM_SHOW = "orderSystemShow";
    private static final String EDIT_ORDER_INFO = "editOderInfo";

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

    @RequestMapping("/addNewOrderShow")
    private String addNewOrderShow(OrderCustomer orderCustomer) {

        return ADD_NEW_ORDER;
    }

    @RequestMapping("/addNewOrder")
    public String addNewOrder(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer, ModelMap map) {

//        orderService.addNewOrder(order);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }
    @RequestMapping("/addNewOrder2")
    public String addNewOrderLast(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer,Integer id, ModelMap map) {

//        orderService.addNewOrder(order);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/editOrderInfo")
    public String editOrderInfo(HttpServletRequest request, @ModelAttribute("order") Order order) {


        Order currentOrder = orderService.getOrderById(order.getId());
        order.setId(currentOrder.getId());
        order.setCharge(currentOrder.getCharge());
        order.setMoneySituation(currentOrder.getMoneySituation());
        order.setOrderDate(currentOrder.getOrderDate());
        order.setOrderNumber(currentOrder.getOrderNumber());
        order.setServiceProject(currentOrder.getServiceProject());
        order.setServiceStatus(currentOrder.getServiceStatus());

        return EDIT_ORDER_INFO;
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        orderService.updateOrder(order);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/deleteCurrentOrder")
    public String deleteOrder(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        orderService.deleteOrderById(order.getId());
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }
}
