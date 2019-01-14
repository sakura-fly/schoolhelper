package com.schoolhepler.model.response;

import java.util.List;

public class ResponseListModel<T> extends ResponseModel {
    private long count;
    private List<T> data;


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
