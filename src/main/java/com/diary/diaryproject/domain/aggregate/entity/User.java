package com.diary.diaryproject.domain.aggregate.entity;

public class User {

    private String id;
    private String pwd;
    private String nickName;

    public User(String id, String pwd, String nickName) {
        this.id = id;
        this.pwd = pwd;
        this.nickName = nickName;
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
