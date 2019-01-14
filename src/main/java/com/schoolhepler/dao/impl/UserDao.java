package com.schoolhepler.dao.impl;

import com.schoolhepler.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDaoImpl<User> {
    public UserDao() {
        super.table = "User";
    }
}
