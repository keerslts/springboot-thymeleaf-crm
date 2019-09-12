package com.angus.web;

import com.angus.dao.pojo.User;
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
    private static final String EDIT_USER_INFO = "editUserInfo";
    private static final String CUSTOMER_SYSTEM_SHOW = "customerSystemShow";

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession httpSession;

    /**
     * 展示登陆界面
     * 该方法中的user给前台返回
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/customerSystemShow")
    public String showLogin(HttpServletRequest request, User user) {

        return CUSTOMER_SYSTEM_SHOW;
    }


}
