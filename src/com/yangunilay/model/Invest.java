package com.yangunilay.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/9/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "invest")
@Table(name = "invest")
public class Invest {
    private int id;
    private Date applyTime;
    private int money;
    private int rate;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public int getMoney() {
        return money;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
