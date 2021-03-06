package com.schoolhepler.util;

import com.schoolhepler.model.SensorData;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class DBUtil {

    public static NativeQuery getQuerySql(Session session, String table, Object o, String... zd) {
        List<SensorData> rre = RrelationData.sensorDataList(o);
        StringBuilder zds = new StringBuilder();
        // 查询字段，不穿查全部，赋值*
        zds = getStringBuilder(zds, zd);
        String sqlStr = "select " + zds.toString() + " from " + table + getQuerySql(rre);
        return getQuerySql(sqlStr, session, rre);
    }

    public static Query getQueryHql(Session session, String table, Object o, String... zd) {
        List<SensorData> rre = RrelationData.sensorDataList(o);
        StringBuilder zds = new StringBuilder();
        // 查询字段，不穿查全部，赋值*
        zds = getStringBuilder(zds, zd);
        String sqlStr = "select " + zds.toString() + " from " + table + getQuerySql(rre);
        return getQueryHql(sqlStr, session, rre);
    }

    public static NativeQuery getQuerySqlOrLike(Session session, String table, Object o, String... zd) {
        List<SensorData> rre = RrelationData.sensorDataList(o);
        StringBuilder zds = new StringBuilder();
        // 查询字段，不穿查全部，赋值*
        zds = getStringBuilder(zds, zd);
        String sqlStr = "select " + zds.toString() + " from " + table + getQuerySqlByOr(rre);
        return getQuerySqlByLike(sqlStr, session, rre);
    }

    private static StringBuilder getStringBuilder(StringBuilder zds, String[] zd) {
        if (zd.length == 0) {
            zds = new StringBuilder("*");
        } else {
            for (int i = 0; i < zd.length; i++) {
                zds.append(zd[i]);
                if (i < zd.length - 1) {
                    zds.append(", ");
                }
            }
        }
        return zds;
    }


    public static String getQuerySql(List<SensorData> rre) {
        StringBuilder sb = new StringBuilder(" where ");
        if (rre.size() == 0) {
            return "";
        }
        for (int i = 0; i < rre.size(); i++) {
            sb.append(rre.get(i).getSensorId()).append(" = ? ");
            if (i < rre.size() - 1)
                sb.append(" and ");
        }
        return sb.toString();
    }

    public static String getQuerySqlByOr(List<SensorData> rre) {
        StringBuilder sb = new StringBuilder(" where ");
        if (rre.size() == 0) {
            return "";
        }
        for (int i = 0; i < rre.size(); i++) {
            sb.append(rre.get(i).getSensorId()).append(" like ? ");
            if (i < rre.size() - 1)
                sb.append(" or ");
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

    public static Query getQueryHql(String q, Session session, List<SensorData> rre) {
        Query sql = session.createQuery(q);
        for (int i = 0; i < rre.size(); i++) {
            sql.setParameter(i + 1, rre.get(i).getSensorValue());
        }
        return sql;
    }

    public static NativeQuery getQuerySqlByLike(String q, Session session, List<SensorData> rre) {
        NativeQuery sql = session.createSQLQuery(q);
        for (int i = 0; i < rre.size(); i++) {
            sql.setParameter(i + 1, "%" + rre.get(i).getSensorValue() + "%");
        }
        return sql;
    }


}
