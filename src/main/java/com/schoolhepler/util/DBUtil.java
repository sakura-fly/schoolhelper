package com.schoolhepler.util;

import com.schoolhepler.model.SensorData;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.lang.reflect.Field;
import java.util.List;

public class DBUtil {

    public static NativeQuery getQuerySql(Session session, String table, Object o) {
        List<SensorData> rre = RrelationData.sensorDataList(o);
        String sqlStr = "select * from " + table + getQuerySql(rre);
        return getQuerySql(sqlStr, session, rre);
    }

    public static String getQuerySql(List<SensorData> rre) {
        StringBuilder sb = new StringBuilder(" where ");
        if (rre.size() == 0) {
            return "";
        }
        for (SensorData s : rre) {
            sb.append(s.getSensorId()).append(" = ? ");
        }
        return sb.toString();
    }

    public static NativeQuery getQuerySql(String q, Session session, List<SensorData> rre) {
        NativeQuery sql = session.createSQLQuery(q);
        for (int i = 0; i < rre.size(); i++) {
            sql.setParameter(i + 1, rre.get(i).getSensorValue());
        }
        return sql;
    }



}
