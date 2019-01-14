package com.schoolhepler.dao.impl;

import com.schoolhepler.dao.BaseDao;

import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public List<T> list(T t) {
        return null;
    }

    @Override
    public T find(T t) {
        return null;
    }

    @Override
    public int add(T t) {
        return 0;
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
