package com.angus.web;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.Order;
import com.angus.dao.pojo.OrderCustomer;
import com.angus.service.CustomerService;
import com.angus.service.OrderService;
import com.angus.util.PageListMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderSystemController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String ADD_NEW_ORDER = "addNewOrder";
    private static final String ORDER_SYSTEM_SHOW = "orderSystemShow";
    private static final String EDIT_ORDER_INFO = "editOrderInfo";

    @Autowired
    private OrderService orderService;
    ;
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CustomerService customerService;

    /**
     * 展示登陆界面
     * 该方法中的user给前台返回
     *
     * @return
     */
    @RequestMapping("/orderSystemShow")
    public String showOrderList(ModelMap map) {

        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    private void getAllOrders(ModelMap map) {

        List<Map> orderCustomerList = new ArrayList<Map>();
        orderCustomerList = orderService.getAllOrderCustomers();
        map.put("orderCustomerList", orderCustomerList);
    }

    @RequestMapping("/addNewOrderShow")
    private String addNewOrderShow(@ModelAttribute("orderCustomer") OrderCustomer orderCustomer, @ModelAttribute("pageListMapUtil") PageListMapUtil pageListMapUtil) {

        Customer customer = customerService.getCustomerById(orderCustomer.getCustomer().getCustomerId());
        orderCustomer.setCustomer(customer);
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderEncode(createOrderEncode(order));
        orderCustomer.setOrder(order);

        return ADD_NEW_ORDER;
    }

    private String createOrderEncode(Order order) {

        String encode = "ZKCH";

        Date date = new Date();
        String year = String.format("%tY", date);
        encode = encode + year;
        String month = String.format("%tm", date);
        encode = encode + month + "1";
        ArrayList<Integer> lastOrderNumber = orderService.getLastOrderNumber();
        if (lastOrderNumber != null && lastOrderNumber.size() > 0) {
            order.setOrderNumber(lastOrderNumber.get(lastOrderNumber.size() - 1) + 1);
            encode = encode + formatOrderNumber(lastOrderNumber.get(lastOrderNumber.size() - 1));
        } else {
            order.setOrderNumber(1);
            encode = encode + "0001";
        }

        return encode;
    }

    private String formatOrderNumber(Integer encode) {
        encode = encode + 1;
        int count = 0;
        String tempString = "";
        int tempEncode = encode;

        while (encode / 10 > 0) {
            encode = encode / 10;
            count++;
        }
        for (int i = 3 - count; i > 0; i--) {
            tempString = tempString + "0";
        }

        return tempString + tempEncode;
    }

    @RequestMapping("/addNewOrder")
    public String addNewOrder(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer, ModelMap map) {
        //毛利=“实际价格”—“常化所成本”—“联泓成本”，
        int realCharge = 0;
        int wwCost = 0;
        int chCost = 0;
        int lhCost = 0;
        int accountCharge = 0;
        if(null!=orderCustomer.getOrder().getRealCharge()){
            realCharge = orderCustomer.getOrder().getRealCharge();
        }
        if(null!=orderCustomer.getOrder().getWWCost()){
            wwCost = orderCustomer.getOrder().getWWCost();
        }
        if(null!=orderCustomer.getOrder().getCHCost()){
            chCost = orderCustomer.getOrder().getCHCost();
        }
        if(null!=orderCustomer.getOrder().getLHCost()){
            lhCost = orderCustomer.getOrder().getLHCost();
        }
        if(null!=orderCustomer.getOrder().getAccountCharge()){
            accountCharge = orderCustomer.getOrder().getAccountCharge();
        }
        orderCustomer.getOrder().setCalculateCharge(realCharge - wwCost - chCost - lhCost);
        orderCustomer.getOrder().setTailCharge(realCharge - accountCharge);
        orderService.addNewOrder(orderCustomer.getOrder());
        int orderId = orderService.getOrderByEncode(orderCustomer.getOrder().getOrderEncode());
        orderCustomer.getOrder().setOrderId(orderId);
        orderService.insertRelatedCustomer(orderCustomer);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/updateCurrentCustomer")
    public String updateCurrentCustomer(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer) {

        if (orderCustomer.getId() == 0) {
            orderService.insertRelatedCustomer(orderCustomer);
            orderCustomer.setId(orderService.getResOrderCustomer(orderCustomer));
        } else {
            orderService.updateRelatedCustomer(orderCustomer);
        }
        return EDIT_ORDER_INFO;
    }

    @RequestMapping("/editOrderInfo")
    public String editOrderInfo(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer,@ModelAttribute("pageListMapUtil") PageListMapUtil pageListMapUtil) {

        List<Map> orderCustomerList = new ArrayList<Map>();
        orderCustomerList = orderService.getOrderCustomerById(orderCustomer.getId());
        if (orderCustomerList.size()>0){
            Order tempOrder = orderService.getOrderById((Integer) orderCustomerList.get(0).get("orderId"));
            Customer tempCustomer = customerService.getCustomerById((Integer) orderCustomerList.get(0).get("customerId"));
            orderCustomer.setOrder(tempOrder);
            orderCustomer.setCustomer(tempCustomer);
        }
        return EDIT_ORDER_INFO;
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer, ModelMap map) {

        orderCustomer.getOrder().setCalculateCharge(orderCustomer.getOrder().getRealCharge() - orderCustomer.getOrder().getWWCost() - orderCustomer.getOrder().getCHCost() - orderCustomer.getOrder().getLHCost());
        orderCustomer.getOrder().setTailCharge(orderCustomer.getOrder().getRealCharge() - orderCustomer.getOrder().getAccountCharge());
        orderService.updateOrder(orderCustomer.getOrder());
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/deleteCurrentOrder")
    public String deleteOrder(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer, ModelMap map) {

        orderService.deleteOrderById(orderCustomer.getOrder().getOrderId());
        orderService.deleteResOrderCustomerByOrderId(orderCustomer.getOrder().getOrderId());
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/editOrderCustomer")
    public String editOrderCustomer(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {


        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/findOrdersByCustomerId")
    public String findOrdersByCustomerId(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        getOrdersByCustomerId(map,customer.getCustomerId());
        return ORDER_SYSTEM_SHOW;
    }

    private void getOrdersByCustomerId(ModelMap map, Integer customerId) {

        List<Map> orderCustomerList = new ArrayList<Map>();
//        orderList = orderService.getAllOrders();
        orderCustomerList = orderService.getOrderCustomersByCustomerId(customerId);
        map.put("orderCustomerList", orderCustomerList);

    }


}
