package com.angus.web;

import com.angus.dao.pojo.User;
import com.angus.service.UserService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    private static final String EDIT_USER_INFO = "editUserInfo";
    private static final String ADD_NEW_USER = "addNewUser";

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
    @RequestMapping("/login")
    public String showLogin(HttpServletRequest request, User user) {

        return LOGIN;
    }

    /**
     * 判断登陆信息，并将登陆用户信息存入session中
     * 该方法中的user为前台填入的信息
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String getLoginResult (@ModelAttribute("user") @Validated User user,
//                                  @ModelAttribute("message") Message message,
                                  HttpServletRequest request)
    {
        httpSession = request.getSession();
        //获取填入的用户信息
//        String userName = user.getUserName();
//        String passWord = user.getPassWord();

        List<User> userResults = null;
        userResults = userService.getUserByNameAndPassword(user);
        //没有查到登录用户
        if(userResults==null||userResults.size()==0){
            httpSession.setAttribute("wrongMessage","未查询到当前用户！");
//            message.setWrongMessage("未查询到当前用户！");
            return LOGIN;
        }

        httpSession.setAttribute("wrongMessage","");
        //查询到登陆用户，默认只取第一个用户（不允许同名同密码用户）
        User currentUser = userResults.get(0);

        httpSession.setAttribute("rightLevel",currentUser.getRightLevel());
        httpSession.setAttribute("id",currentUser.getId());
        httpSession.setAttribute("userName",user.getUserName());

        //验证成功，我们可以返回到自己想去的界面了，我这个地方直接返回到添加的界面
        return INDEX;
    }

    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request) {
        if(!userSessionCheck(request)){
            //如果session信息中没有用户信息
            return LOGIN;
        }
        return INDEX;
    }

    /**
     * 查询某个用户并返回给用户编辑界面
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/editUserInfo")
    public String editUserInfo(HttpServletRequest request, @ModelAttribute("user") User user) {
//        httpSession.setAttribute("wrongMessage","");

        if(!userSessionCheck(request)){
            //如果session信息中没有用户信息
            return LOGIN;
        }

        User currentUser = userService.getUserById(user.getId());
        user.setId(currentUser.getId());
        user.setUserName(currentUser.getUserName());
        user.setPassWord(currentUser.getPassWord());
        user.setRightLevel(currentUser.getRightLevel());

        return EDIT_USER_INFO;
    }

    @RequestMapping("/accountShow")
    public String getAccount(ModelMap map){

        getAllAccount(map);
        return ACCOUNT;
    }

    public void getAllAccount(ModelMap map){

        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUser();
//        User user = new User();
//        user.setId(1);
//        user.setUserName("1");
//        user.setRightLevel(1);
//        user.setPassWord("1");
//        userList.add(user);
//        User user1 = new User();
//        user1.setId(2);
//        user1.setUserName("2");
//        user1.setRightLevel(2);
//        user1.setPassWord("2");
//        userList.add(user1);


        map.put("userList", userList);

    }


    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, @ModelAttribute("user") User user, ModelMap map) {

        userService.updateUser(user);
        getAllAccount(map);
        return ACCOUNT;
    }

    @RequestMapping("/deleteCurrentUser")
    public String deleteUser(HttpServletRequest request, @ModelAttribute("user") User user, ModelMap map) {

        userService.deleteUserById(user.getId());
        getAllAccount(map);
        return ACCOUNT;
    }

    @RequestMapping("/addNewUserShow")
    public String addNewUserShow(HttpServletRequest request, User user) {
//        if(!userSessionCheck(request)){
//            //如果session信息中没有用户信息
//            return LOGIN;
//        }
        return ADD_NEW_USER;
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(HttpServletRequest request, @ModelAttribute("user") User user, ModelMap map) {

        userService.addNewUser(user);
        getAllAccount(map);
        return ACCOUNT;
    }


    public boolean userSessionCheck(HttpServletRequest request){

        boolean flag = true;
        httpSession = request.getSession();
        String userName = (String)httpSession.getAttribute("userName");
        if(null==userName){
            flag = false;
        }

        return flag;
    }
}
