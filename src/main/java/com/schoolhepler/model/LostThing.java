package com.schoolhepler.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class LostThing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String msg;
    private String pic;
    private Date time;
    @Column(nullable = false)
    private int uid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", insertable = false, updatable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LostThing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", pic='" + pic + '\'' +
                ", time=" + time +
                ", uid=" + uid +
                '}';
    }
}
