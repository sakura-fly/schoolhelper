package com.schoolhepler.ctr;


import com.schoolhepler.model.User;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserCtr {

    @Resource
    private UserService service;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseListModel<User> list(User user){
        return service.list(user);
    }


}
