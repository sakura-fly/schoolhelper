package com.schoolhepler.service.impl;


import com.schoolhepler.dao.BaseDao;
import com.schoolhepler.dao.impl.UserDao;
import com.schoolhepler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends BaseServiceImpl<User> {

    private
    UserDao userDao;

    @Autowired
    public UserService( UserDao userDao) {
        super.dao = userDao;
        this.userDao = userDao;
    }
}
