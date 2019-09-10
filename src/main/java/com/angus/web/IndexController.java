package com.angus.web;

import com.angus.dao.pojo.Message;
import com.angus.dao.pojo.MusicInfo;
import com.angus.dao.pojo.User;
import com.angus.service.MusicInfoService;
import com.angus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    private static final String ACCOUNT = "account";
    @Autowired
    private MusicInfoService musicInfoService;
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
        String userName = user.getUserName();
        String passWord = user.getPassWord();

        List<User> userResults = null;
//        userResults = userService.getUserByNameAndPassword(user);
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
    @RequestMapping("/editUserInfo")
    public String editUserInfo(HttpServletRequest request,Integer id,User user) {
        httpSession.setAttribute("wrongMessage","");
        if(!userSessionCheck(request)){
            //如果session信息中没有用户信息
            return LOGIN;
        }
        return INDEX;
    }

    @RequestMapping("/accountShow")
    public String getAccount(ModelMap map){

        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setUserName("1");
        user.setRightLevel(1);
        userList.add(user);
        User user1 = new User();
        user1.setId(2);
        user1.setUserName("2");
        user1.setRightLevel(2);
        userList.add(user1);


        map.put("userList", userList);

        return "account";
    }


    @RequestMapping("/music")
    @ResponseBody
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfo(null);
        return musicInfoList;
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
