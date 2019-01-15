package com.schoolhepler.service.impl;

import com.schoolhepler.dao.ThingDao;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.service.ThingService;

public class ThingServiceImpl<T> extends BaseServiceImpl<T> implements ThingService<T> {

    // ThingDao<T> dao;

    @Override
    public ResponseListModel<T> query(T t) {
        ResponseListModel<T> r = new ResponseListModel<>();
        try {
            r.setData(((ThingDao<T>) dao).query(t));
            r.setCount(((ThingDao<T>) dao).querycount(t));
            resSuccess(r);
        } catch (Exception e) {
            e.printStackTrace();
            reserr(r);
        }
        return r;
    }
}
