package com.schoolhepler.service;

import com.schoolhepler.model.response.ResponseListModel;
import com.schoolhepler.model.response.ResponseModel;
import com.schoolhepler.model.response.ResponseOneModel;

public interface BaseService<T> {
    ResponseModel add(T t);

    ResponseOneModel<T> find(T t);

    ResponseListModel<T> list(T t);

    void resSuccess(ResponseModel r);

    void reserr(ResponseModel r);

}
