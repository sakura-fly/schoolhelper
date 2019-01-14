package com.schoolhepler.model.response;


public class ResponseOneModel<T> extends ResponseModel {
    private T model;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
