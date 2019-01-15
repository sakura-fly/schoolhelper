package com.schoolhepler.ctr;

import com.schoolhepler.model.User;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;
import com.schoolhepler.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class AuthCtr {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public ResponseOneModel<User> login(String acc, String pwd) {
        User u = new User();
        u.setAcc(acc);
        u.setPwd(pwd);
        return userService.login(u);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel regist(User u) {
        return userService.add(u);
    }
}
