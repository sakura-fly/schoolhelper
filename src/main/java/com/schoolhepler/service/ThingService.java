package com.schoolhepler.service;

import com.schoolhepler.model.response.ResponseListModel;

public interface ThingService<T> extends BaseService<T> {
    ResponseListModel<T> query(T t);

}
