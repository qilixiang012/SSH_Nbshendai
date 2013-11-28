package com.yangunilay.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 8:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="user")
public class User {
    private int id;
    private String username;
    private String loginPassword;
    private int mobile;
    private String email;
    private int money;
    private List<Invest> investList;

    @Id
    @GeneratedValue
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @OneToMany(targetEntity=Invest.class,cascade=CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "userid",updatable=false)
    public List<Invest> getInvestList() {
        return investList;
    }

    public void setInvestList(List<Invest> investList) {
        this.investList = investList;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
