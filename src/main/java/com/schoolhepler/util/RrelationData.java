package com.schoolhepler.util;


import com.schoolhepler.model.SensorData;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RrelationData {

    public static List<SensorData> sensorDataList(Object sensorDataDto) {
        List<SensorData> sensorDatas = new ArrayList<>();
        Class<?> clazz = sensorDataDto.getClass();
        try {
            exceClass(sensorDataDto, sensorDatas, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensorDatas;
    }

    private static void exceClass(Object sensorDataDto, List<SensorData> sensorDatas, Class<?> clazz) throws Exception {
        if (clazz != Object.class) {
            returnclassF(sensorDataDto, sensorDatas, clazz);
            Class<?> clazzs = clazz.getSuperclass();
            exceClass(sensorDataDto, sensorDatas, clazzs);
        }
    }

    private static void returnclassF(Object sensorDataDto, List<SensorData> sensorDatas, Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (checkFiled(field, field.get(sensorDataDto))) {
                SensorData sensorData = new SensorData();
                sensorData.setSensorId(field.getName());
                sensorData.setSensorValue(field.get(sensorDataDto));
                sensorData.setField(field);
                sensorDatas.add(sensorData);
            }
        }
    }

    /**
     * 检查是否为空
     *
     * @param f     字段
     * @param value 值
     * @return
     */
    private static boolean checkFiled(Field f, Object value) {
        if (value == null) {
            return false;
        }
        // 获取类型
        String itype = f.getGenericType().toString();
        // 字符串不为空
        if (f.getGenericType().toString().equals("class java.lang.String")) {
            return !value.toString().isEmpty();


        }
        // 数字不为0
        else if ((itype.equals("class java.lang.Integer") || itype.equals("class java.lang.Double")
                || itype.equals("class java.lang.Float") || itype.equals("int") || itype.equals("double")
                || itype.equals("long") || itype.equals("float"))) {
            return Double.valueOf(String.valueOf(value)) != 0;

        } else {
            return true;
        }
    }
}
