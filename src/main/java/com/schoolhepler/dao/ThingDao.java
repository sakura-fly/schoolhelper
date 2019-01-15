package com.schoolhepler.dao;

import java.util.List;

public interface ThingDao<T> extends BaseDao<T> {
    List<T> query(T t);

    long querycount(T t);

}
