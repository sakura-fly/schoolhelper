package com.schoolhepler.dao.impl;

import com.schoolhepler.model.User;
import com.schoolhepler.util.DBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends BaseDaoImpl<User> {
    public UserDao() {
        super.table = "User";
    }


}
