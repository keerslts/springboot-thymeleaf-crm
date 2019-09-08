package com.angus.web;

import com.angus.dao.pojo.MusicInfo;
import com.angus.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final String INDEX = "index";
    private static final String LOGIN = "login";
    @Autowired
    private MusicInfoService musicInfoService;

    @RequestMapping("/login")
    public String getLogin(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        return LOGIN;
    }
    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
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
