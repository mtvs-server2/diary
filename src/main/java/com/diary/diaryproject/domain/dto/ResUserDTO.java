package com.diary.diaryproject.domain.dto;

public class ResUserDTO {

    private String id;

    private String pwd;

    private String nickName;

    public ResUserDTO() {}

    public ResUserDTO(String id, String pwd, String nickName) {
        this.id = id;
        this.pwd = pwd;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
