package com.schoolhepler.dao.impl;

import com.schoolhepler.dao.BaseDao;
import com.schoolhepler.util.DBUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    String table;


    @Resource
    SessionFactory sessionFactory;
    @Override
    public List<T> list(T t) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<T> r = new ArrayList<>();
        try {
            NativeQuery sql = DBUtil.getQuerySql(session, table, t);
            sql.addEntity(t.getClass());
            r=  sql.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return r;
    }

    @Override
    public T find(T t) {
        return list(t).get(0);
    }

    @Override
    public int add(T t) {
        Session session = sessionFactory.openSession();
        Transaction tt = session.beginTransaction();
        int stat = 1;
        try {
            session.save(t);
            tt.commit();
        } catch (Exception e) {
            e.printStackTrace();
            stat = -1;
        }finally {
            session.close();
        }
        return stat;
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
