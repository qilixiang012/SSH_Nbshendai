package com.yangunilay.service;

import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public boolean add(User user);
    public void addDetail(UserDetail userDetail);
    public boolean exist(String username);
    public List<User> listUsers();
    public List<UserDetail> listUsersDetail();
    public User getUser(String username);
    public Loan getLoan(int id);
    public int recharge(String username,int money);
    public boolean rechargeValid(int money);
    public boolean investValid(String username,int investMoney);
    public void addInvest(String username,int money,int loanid);
}
