package com.angus.web;

import com.angus.dao.pojo.MusicInfo;
import com.angus.dao.pojo.User;
import com.angus.service.MusicInfoService;
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

    /**
     * 该方法中的user给前台返回
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String getLogin(HttpServletRequest request, User user) {

        return LOGIN;
    }

    /**
     * 该方法中的user为前台填入的信息
     * @param user
     * @param rs
     * @param request
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String add (@ModelAttribute("user") @Validated User user,
                       BindingResult rs,HttpServletRequest request)
    {
//        Integer id = (Integer)session.getAttribute("id");
        HttpSession session = request.getSession();
        session.setAttribute("rightLevel",1);
        session.setAttribute("userName",user.getUserName());

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
