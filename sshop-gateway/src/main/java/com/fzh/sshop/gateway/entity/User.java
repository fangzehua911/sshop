package com.fzh.sshop.gateway.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fang
 * @version 1.0
 * @date 2020-5-16 13:44
 */
@Data
public class User implements Serializable {

    private String name;
    private String age;
    private String passwd;

    public User() {
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
