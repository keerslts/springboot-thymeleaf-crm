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
//        orderList = orderService.getAllOrders();
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
        orderCustomer.getOrder().setCalculateCharge(orderCustomer.getOrder().getRealCharge() - orderCustomer.getOrder().getCHCost() - orderCustomer.getOrder().getLHCost());
        orderService.addNewOrder(orderCustomer.getOrder());
        int orderId = orderService.getOrderByEncode(orderCustomer.getOrder().getOrderEncode());
        orderCustomer.getOrder().setOrderId(orderId);
        orderService.insertRelatedCustomer(orderCustomer);
        getAllOrders(map);
        return ORDER_SYSTEM_SHOW;
    }

    @RequestMapping("/updateCurrentCustomer")
    public String updateCurrentCustomer(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer) {

//        orderService.addNewOrder(order);
        if (orderCustomer.getId() == 0) {
            orderService.insertRelatedCustomer(orderCustomer);
            orderCustomer.setId(orderService.getResOrderCustomer(orderCustomer));
        } else {
            orderService.updateRelatedCustomer(orderCustomer);
        }
        editOrderInfo(request, orderCustomer);
        return EDIT_ORDER_INFO;
    }

    @RequestMapping("/editOrderInfo")
    public String editOrderInfo(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer) {
//    public String editOrderInfo(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer,String id) {

        List<Map> orderCustomerList = new ArrayList<Map>();
        orderCustomerList = orderService.getOrderCustomerById(orderCustomer.getId());
//        map.put("orderCustomerList", orderCustomerList);

        if (orderCustomerList.size() == 0) {

            Order tempOrder = orderService.getOrderById(orderCustomer.getOrder().getOrderId());
            orderCustomer.setCustomer(new Customer());
            orderCustomer.setOrder(tempOrder);
            orderCustomer.setId(0);
            return EDIT_ORDER_INFO;
        }

        orderCustomer.setCustomer(new Customer());
        orderCustomer.setOrder(new Order());
        orderCustomer.getCustomer().setCustomerId((Integer) orderCustomerList.get(0).get("customerId"));
        orderCustomer.getCustomer().setBusiness((String) orderCustomerList.get(0).get("business"));
        orderCustomer.getCustomer().setPhoneNumber((String) orderCustomerList.get(0).get("phoneNumber"));
        orderCustomer.getCustomer().setName((String) orderCustomerList.get(0).get("name"));
        orderCustomer.getCustomer().setLinkMan((String) orderCustomerList.get(0).get("linkMan"));
        orderCustomer.getCustomer().setEmail((String) orderCustomerList.get(0).get("email"));
        orderCustomer.getCustomer().setDistrict((String) orderCustomerList.get(0).get("district"));
        orderCustomer.getCustomer().setCooperationStatus((String) orderCustomerList.get(0).get("cooperationStatus"));
        orderCustomer.getOrder().setOrderId((Integer) orderCustomerList.get(0).get("orderId"));
//        orderCustomer.getOrder().setServiceStatus((String) orderCustomerList.get(0).get("serviceStatus"));
//        orderCustomer.getOrder().setServiceProject((String) orderCustomerList.get(0).get("serviceProject"));
//        orderCustomer.getOrder().setOrderNumber((String) orderCustomerList.get(0).get("orderNumber"));
        orderCustomer.getOrder().setOrderDate((Date) orderCustomerList.get(0).get("orderDate"));
//        orderCustomer.getOrder().setMoneySituation((String) orderCustomerList.get(0).get("moneySituation"));
        orderCustomer.getOrder().setCharge((Integer) orderCustomerList.get(0).get("charge"));
        orderCustomer.getOrder().setOrderName((String) orderCustomerList.get(0).get("orderName"));
        return EDIT_ORDER_INFO;
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(HttpServletRequest request, @ModelAttribute("orderCustomer") OrderCustomer orderCustomer, ModelMap map) {

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
    public String findOrdersByCustomerId(HttpServletRequest request, @ModelAttribute("order") Order order, ModelMap map) {

        getOrdersByCustomerId(map,order.getOrderId());
        return ORDER_SYSTEM_SHOW;
    }

    private void getOrdersByCustomerId(ModelMap map, Integer orderId) {

        List<Map> orderCustomerList = new ArrayList<Map>();
//        orderList = orderService.getAllOrders();
        orderCustomerList = orderService.getAllOrderCustomers();
        map.put("orderCustomerList", orderCustomerList);

    }


}
