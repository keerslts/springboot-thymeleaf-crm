package com.angus.web;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.OrderCustomer;
import com.angus.service.CustomerService;
import com.angus.util.PageListMapUtil;
import com.angus.util.ThymeleafUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerSystemController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String ADD_NEW_CUSTOMER = "addNewCustomer";
    private static final String CUSTOMER_SYSTEM_SHOW = "customerSystemShow";
    private static final String EDIT_CUSTOMER_INFO = "editCustomerInfo";
    private static final String VIEW_CUSTOMER_INFO = "viewCustomerInfo";
    private static final String CHOOSE_ONE_CUSTOMER = "chooseOneCustomer";

    @Autowired
    private CustomerService customerService;
    ;
    @Autowired
    private HttpSession httpSession;

    /**
     * 展示登陆界面
     *
     * @return
     */
    @RequestMapping("/customerSystemShow")
    public String showCustomerSystem(ModelMap map) {

        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    private void getAllCustomers(ModelMap map) {

        List<Customer> customerList = new ArrayList<Customer>();
        customerList = customerService.getAllCustomers();
        map.put("customerList", customerList);
    }

    @RequestMapping("/addNewCustomerShow")
    private String addNewCustomerShow(@ModelAttribute("customer") Customer customer,
                                      @ModelAttribute("pageListMapUtil")
                                                      PageListMapUtil pageListMapUtil) {

        List a = new ArrayList();
        a.add("2");
        a.add("5");
        customer.setServiceType(a);
        customer.setBusiness("建筑助剂");
        customer.setCustomerBelong("xxx");

//        serviceTypeList.add("2");
//        serviceTypeList.add("5");
//        serviceTypeList.add("57");


        return ADD_NEW_CUSTOMER;
    }

    @RequestMapping("/addNewCustomer")
    public String addNewCustomer(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map, @ModelAttribute("serviceTypeList") ArrayList<String> serviceTypeList) {

        customerService.addNewCustomer(customer);
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    @RequestMapping("/editCustomerInfo")
    public String editCustomerInfo(HttpServletRequest request, @ModelAttribute("customer") Customer customer) {


        Customer currentCustomer = customerService.getCustomerById(customer.getCustomerId());
        customer.setCustomerId(currentCustomer.getCustomerId());
        customer.setBusiness(currentCustomer.getBusiness());
        customer.setCooperationStatus(currentCustomer.getCooperationStatus());
        customer.setDistrict(currentCustomer.getDistrict());
        customer.setEmail(currentCustomer.getEmail());
        customer.setLinkMan(currentCustomer.getLinkMan());
        customer.setName(currentCustomer.getName());
        customer.setPhoneNumber(currentCustomer.getPhoneNumber());

        return EDIT_CUSTOMER_INFO;
    }

    @RequestMapping("/viewCustomerInfo")
    public String viewCustomerInfo(HttpServletRequest request, @ModelAttribute("customer") Customer customer) {


        Customer currentCustomer = customerService.getCustomerById(customer.getCustomerId());
        customer.setCustomerId(currentCustomer.getCustomerId());
        customer.setBusiness(currentCustomer.getBusiness());
        customer.setCooperationStatus(currentCustomer.getCooperationStatus());
        customer.setDistrict(currentCustomer.getDistrict());
        customer.setEmail(currentCustomer.getEmail());
        customer.setLinkMan(currentCustomer.getLinkMan());
        customer.setName(currentCustomer.getName());
        customer.setPhoneNumber(currentCustomer.getPhoneNumber());

        return VIEW_CUSTOMER_INFO;
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        customerService.updateCustomer(customer);
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    @RequestMapping("/deleteCurrentCustomer")
    public String deleteCustomer(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        customerService.deleteCustomerById(customer.getCustomerId());
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    @RequestMapping("/addRelatedCustomer")
    public String addRelatedCustomer(HttpServletRequest request, @ModelAttribute("orderCustomer")
            OrderCustomer orderCustomer, ModelMap map) {

        getAllCustomers(map);
        map.put("orderCustomerId", orderCustomer.getId());
        return CHOOSE_ONE_CUSTOMER;
    }
}
