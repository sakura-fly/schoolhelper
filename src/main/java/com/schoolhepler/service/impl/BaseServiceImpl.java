package com.schoolhepler.service.impl;

import com.schoolhepler.dao.BaseDao;
import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;
import com.schoolhepler.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {


    BaseDao<T> dao;


    @Override
    public ResponseModel add(T t) {
        int r = -1;
        ResponseModel responseModel = new ResponseModel();
        try {
            r = dao.add(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (r == 1) {
            resSuccess(responseModel);
        } else {
            responseModel.setCode(r);
            responseModel.setMsg("err");
        }
        return responseModel;
    }

    @Override
    public ResponseOneModel<T> find(T t) {
        ResponseOneModel<T> r = new ResponseOneModel<>();
        try {
            r.setModel(dao.find(t));
            resSuccess(r);
        } catch (Exception e) {
            e.printStackTrace();
            reserr(r);
        }
        return r;
    }

    @Override
    public ResponseListModel<T> list(T t) {
        ResponseListModel<T> r = new ResponseListModel<>();
        try {
            r.setData(dao.list(t));
            r.setCount(dao.count(t));
            resSuccess(r);
        } catch (Exception e) {
            e.printStackTrace();
            reserr(r);
        }
        return r;
    }

    @Override
    public void resSuccess(ResponseModel r) {
        r.setCode(1);
        r.setMsg("success");
    }

    @Override
    public void reserr(ResponseModel r) {
        r.setCode(-1);
        r.setMsg("err");
    }
}
