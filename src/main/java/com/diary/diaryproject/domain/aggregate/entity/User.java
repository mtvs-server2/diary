package com.diary.diaryproject.domain.aggregate.entity;

import javax.persistence.*;


@Entity
@Table(name = "User")
public class User {
    @Id
    private String id;
    @Column
    private String pwd;
    @Column
    private String nickName;

    public User(String id, String pwd, String nickName) {
        this.id = id;
        this.pwd = pwd;
        this.nickName = nickName;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getNickName() {
        return nickName;
    }
}
