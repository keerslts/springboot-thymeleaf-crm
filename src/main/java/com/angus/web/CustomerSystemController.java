package com.angus.web;

import com.angus.dao.pojo.Customer;
import com.angus.dao.pojo.User;
import com.angus.service.CustomerService;
import com.angus.service.UserService;
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
public class CustomerSystemController
{

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String ADD_NEW_CUSTOMER = "addNewCustomer";
    private static final String CUSTOMER_SYSTEM_SHOW = "customerSystemShow";
    private static final String EDIT_CUSTOMER_INFO = "editCustomerInfo";

    @Autowired
    private CustomerService customerService;
    ;
    @Autowired
    private HttpSession httpSession;

    /**
     * 展示登陆界面
     * 该方法中的user给前台返回
     * @return
     */
    @RequestMapping("/customerSystemShow")
    public String showLogin(ModelMap map) {

        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    private void getAllCustomers(ModelMap map) {

        List<Customer> customerList = new ArrayList<Customer>();
        customerList = customerService.getAllCustomers();
        map.put("customerList", customerList);
    }

    @RequestMapping("/addNewCustomerShow")
    private String addNewCustomerShow(Customer customer) {

        return ADD_NEW_CUSTOMER;
    }

    @RequestMapping("/addNewCustomer")
    public String addNewUser(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        customerService.addNewCustomer(customer);
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    @RequestMapping("/editCustomerInfo")
    public String editUserInfo(HttpServletRequest request, @ModelAttribute("customer") Customer customer) {


        Customer currentCustomer = customerService.getCustomerById(customer.getId());
        customer.setId(currentCustomer.getId());
        customer.setBusiness(currentCustomer.getBusiness());
        customer.setCooperationStatus(currentCustomer.getCooperationStatus());
        customer.setDistrict(currentCustomer.getDistrict());
        customer.setEmail(currentCustomer.getEmail());
        customer.setLinkMan(currentCustomer.getLinkMan());
        customer.setName(currentCustomer.getName());
        customer.setPhoneNumber(currentCustomer.getPhoneNumber());

        return EDIT_CUSTOMER_INFO;
    }

    @RequestMapping("/updateCustomer")
    public String updateUser(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        customerService.updateCustomer(customer);
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }

    @RequestMapping("/deleteCurrentCustomer")
    public String deleteCustomer(HttpServletRequest request, @ModelAttribute("customer") Customer customer, ModelMap map) {

        customerService.deleteCustomerById(customer.getId());
        getAllCustomers(map);
        return CUSTOMER_SYSTEM_SHOW;
    }
}
