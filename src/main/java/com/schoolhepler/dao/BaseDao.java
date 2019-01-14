package com.schoolhepler.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> list(T t);
    T find(T t);
    int add(T t);
    long count(T t);
}
