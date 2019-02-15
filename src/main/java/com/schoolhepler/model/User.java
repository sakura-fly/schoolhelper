package com.schoolhepler.model;

import jdk.nashorn.internal.objects.annotations.Property;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
public class User {
    public User() {
    }

    public User(int id, String username, String acc, String wx, String qq, String phone, String name, Date time) {
        this.id = id;
        this.username = username;
        this.acc = acc;
        this.wx = wx;
        this.qq = qq;
        this.phone = phone;
        this.name = name;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    @Column(nullable = false,length = 16)
    private String pwd;
    @Column(unique = true, nullable = false,length = 12)
    private String acc;
    private String wx;
    private String qq;
    private String phone;
    private String name;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "model{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", acc='" + acc + '\'' +
                ", wx='" + wx + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public void init(){
        time = time == null ? new Date() : time;
    }
}
