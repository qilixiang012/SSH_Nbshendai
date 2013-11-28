package com.yangunilay.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/9/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "loan")
public class Loan {
    private int id;
    private String name;
    private int rate;
    private int remainMoney;
    private Date startTime;
    private Date endTime;
    private int remainDay;
    /*private String startTimeDemo;*/
    private boolean finish;
    private UserDetail userDetail;
    private List<Invest> investList;
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
   /* @Transient
    public String getStartTimeDemo() {
        return startTimeDemo;
    }

    public void setStartTimeDemo(String startTimeDemo) {
        this.startTimeDemo = startTimeDemo;
    }*/
    @OneToMany(targetEntity=Invest.class,cascade=CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "loanid",updatable=false)
    public List<Invest> getInvestList() {
        return investList;
    }

    public void setInvestList(List<Invest> investList) {
        this.investList = investList;
    }

    @OneToOne
    @JoinColumn(name = "userdetailid")
    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getName() {
        return name;
    }
    @Transient
    public int getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(int remainDay) {
        this.remainDay = remainDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(int remainMoney) {
        this.remainMoney = remainMoney;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return this.getId()+"  "+this.getName()+"  "+this.getRate()+"  "+this.getFinish()+"  "+this.getStartTime()+"  "+this.getRemainMoney()+"  "+this.getUserDetail();
    }
}
