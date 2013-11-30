package com.yangunilay.service.impl;

import com.yangunilay.dao.UserDao;
import com.yangunilay.dao.impl.UserDaoImpl;
import com.yangunilay.model.Invest;
import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;
import com.yangunilay.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 9:01 AM
 * To change this template use File | Settings | File Templates.
 */

@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Resource(name = "userDaoImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public boolean add(User user){
        if(this.exist(user.getUsername())){
            return false;
        }else {
            userDao.save(user);
            return true;
        }
    }
    @Transactional
    @Override
    public void addDetail(UserDetail userDetail) {
        userDao.saveDetail(userDetail);
    }

    @Transactional
    @Override
    public boolean exist(String username){
        return userDao.checkUserExistsWithName(username);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.getUsers();
    }
    @Transactional
    @Override
    public User getUser(String username) {
        if(this.exist(username)){
            return userDao.getUser(username);
        }
        return null;
    }
    @Transactional
    @Override
    public List<UserDetail> listUsersDetail() {
        return userDao.getUsersDetail();
    }

    @Transactional
    @Override
    public Loan getLoan(int id) {
        return userDao.getLoan(id);
    }

    @Transactional
    @Override
    public boolean rechargeValid(int money) { //做网银认证
        return true;
    }

    @Transactional
    @Override
    public int recharge(String username,int money) {
        if(rechargeValid(money)){
            return userDao.addMoney(username,money);
        }
        return -1;
    }

    @Transactional
    @Override
    public boolean investValid(String username,int investMoney){
        User user = userDao.getUser(username);
        if(user.getMoney()>investMoney){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void addInvest(String username, int money,int loanid) {
        Invest invest = new Invest();
        User user = getUser(username);
        Loan loan = getLoan(loanid);
        invest.setMoney(money);
        invest.setRate(loan.getRate());
        if(user.getInvestList()==null){
            List<Invest> investList = new ArrayList<Invest>();
            investList.add(invest);
            user.setInvestList(investList);
        }else {
            user.getInvestList().add(invest);
        }
        if(loan.getInvestList()==null){
            List<Invest> investList = new ArrayList<Invest>();
            investList.add(invest);
            loan.setInvestList(investList);
        }else {
            loan.getInvestList().add(invest);
        }
        user.setMoney(user.getMoney()-money);
        userDao.updateLoan(loanid);
        userDao.updateUser(username);
    }
}
