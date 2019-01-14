package com.schoolhepler.model;

import java.lang.reflect.Field;


/**
 * 对象反射属性
 */
public class SensorData {
    // 属性名
    private String sensorId;
    //属性内容
    private Object sensorValue;

    private Field field;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Object getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Object sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "SensorData [sensorId=" + sensorId + ", sensorValue=" + sensorValue + "]";
    }


}
