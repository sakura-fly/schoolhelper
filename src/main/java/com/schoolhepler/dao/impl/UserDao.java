package com.schoolhepler.dao.impl;

import com.schoolhepler.model.User;
import com.schoolhepler.util.DBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao extends BaseDaoImpl<User> {
    public UserDao() {
        super.table = "User";
    }


    //  重写查询方法，不要密码字段
    @Override
    public List<User> list(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> r = new ArrayList<>();
        try {
            NativeQuery sql = DBUtil.getQuerySql(session, table, user, "username", "acc", "wx", "qq", "phone", "name", "time");
            sql.addEntity(User.class);
            r = sql.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return r;
    }
}
