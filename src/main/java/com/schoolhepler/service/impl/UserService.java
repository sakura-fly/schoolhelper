package com.schoolhepler.service.impl;


import com.schoolhepler.dao.impl.UserDao;
import com.schoolhepler.model.User;
import com.schoolhepler.model.response.ResponseOneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseServiceImpl<User> {

    private
    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        super.dao = userDao;
        this.userDao = userDao;
    }

    public ResponseOneModel<User> login(User u) {
        ResponseOneModel<User> r = new ResponseOneModel<>();
        u = dao.find(u);
        if (u == null) {
            reserr(r);
            return r;
        }
        u.setPwd("");
        resSuccess(r);
        r.setModel(u);
        return r;
    }

}
