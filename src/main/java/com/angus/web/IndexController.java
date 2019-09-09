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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
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
     * @param rs
     * @param request
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String getLoginResult (@ModelAttribute("user") @Validated User user,
                                  @ModelAttribute("message") Message message,
                                  BindingResult rs,
                                  HttpServletRequest request)
    {
        httpSession = request.getSession();
        //获取填入的用户信息
        String userName = user.getUserName();
        String passWord = user.getPassWord();

        List<User> userResults = null;
//        List<User> userResults = userService.getUserByNameAndPassword(user);
        //没有查到登录用户
        if(userResults==null||userResults.size()==0){
            httpSession.setAttribute("wrongMessage","未查询到当前用户！");
            message.setWrongMessage("为查询到当前用户！");
            return LOGIN;
        }

        //查询到登陆用户，默认只取第一个用户（不允许同名同密码用户）
        User currentUser = userResults.get(0);


        httpSession.setAttribute("rightLevel",currentUser.getRightLevel());
        httpSession.setAttribute("id",currentUser.getId());
        httpSession.setAttribute("userName",user.getUserName());

        if (rs.hasErrors()) {
            for (ObjectError error : rs.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "index";
        }

        //验证成功，我们可以返回到自己想去的界面了，我这个地方直接返回到添加的界面
        return "index";
    }

    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") MusicInfo musicInfo) {
        return INDEX;
    }

    @RequestMapping("/account")
    public String getAccount(ModelMap map){

        MusicInfo person = new MusicInfo();
        person.setId(1);
        person.setMusicName("zs");

        map.put("person", person);

        return "account";
    }


    @RequestMapping("/music")
    @ResponseBody
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfo(null);
        return musicInfoList;
    }

}
