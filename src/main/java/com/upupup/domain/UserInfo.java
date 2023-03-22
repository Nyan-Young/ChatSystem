package com.upupup.domain;


import java.util.Date;

public class UserInfo {
    private Integer id;
    private String userName;
    private String password;
    private Boolean gender;
    private String birthdate;

    public UserInfo(Integer id, String userName, String password, Boolean gender, String birthdate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public UserInfo(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        String gen="未知";
        String bir="未知";
        if(gender!=null){
            if(gender==true){
                gen="男";
            }else{
                gen="女";
            }
        }
        if(birthdate!=null){
            bir=birthdate;
        }
        return id + "+" +
                userName + "+" +
                password + "+" +
                gen + "+" +
                bir;
    }

    public String standardString(){
        return id+" "+userName;
    }
}
