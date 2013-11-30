package com.yangunilay.dao;

import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public void save(User u);
    public boolean checkUserExistsWithName(String username);
    public List<User> getUsers();
    public List<UserDetail> getUsersDetail();
    public User getUser(String username);
    public void saveDetail(UserDetail userDetail);
    public Loan getLoan(int id);
    public int addMoney(String username,int money);
    public void updateLoan(int loanid);
    public void updateUser(String username);
}
