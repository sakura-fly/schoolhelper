package com.schoolhepler.dao.impl;

import com.schoolhepler.dao.BaseDao;
import com.schoolhepler.util.DBUtil;
import com.schoolhepler.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
            Query query = HibernateUtils.getQuery(session, t);
            r = query.list();
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
        List<T> l = list(t);
        if (l.size() == 0)
            return null;
        return l.get(0);
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
            boolean isDuplicate = false;
            // 判断是否是用户名重复
            try {
                // 获取异常是否是Duplicate
                isDuplicate = e.getCause().getCause().getMessage().contains("Duplicate");
                // 打印异常名
                System.out.println(e.getCause().getCause().getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                // 如果是重复就设置状态码是-3
                if (isDuplicate){
                    stat = -3;
                } else {
                    // 其他设置-1
                    stat = -1;
                }
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stat;
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
