package com.edu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_admin")
public class Admin {
    @Id
    private String id;
    private String loginname;
    private String password;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Admin(String id, String loginname, String password, String state) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.state = state;
    }

    public Admin(String loginname, String password, String state) {
        this.loginname = loginname;
        this.password = password;
        this.state = state;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
