package com.schoolhepler.dao.impl;

import com.schoolhepler.dao.ThingDao;
import com.schoolhepler.util.DBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class ThingDaoImpl<T> extends BaseDaoImpl<T> implements ThingDao<T> {
    @Override
    public List<T> query(T t) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<T> r = new ArrayList<>();
        try {
            NativeQuery sql = DBUtil.getQuerySqlOrLike(session, table, t);
            sql.addEntity(t.getClass());
            r = sql.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return r;
    }

    @Override
    public long querycount(T t) {
        return 0;
    }
}
