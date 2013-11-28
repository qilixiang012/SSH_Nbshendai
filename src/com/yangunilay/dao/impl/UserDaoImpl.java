package com.yangunilay.dao.impl;

import com.yangunilay.dao.UserDao;
import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;
import com.yangunilay.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */

@Component(value = "userDaoImpl")
public class UserDaoImpl implements UserDao{
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>)hibernateTemplate.find("from User");
    }

    @Override
    public void save(User user){
        hibernateTemplate.save(user);
    }

    @Override
    public User getUser(String username) {
        List<User> userList;
        if(username != null){
            userList = hibernateTemplate.find("from User u where u.username= '"+username+"'");
            User user = userList.get(0);
            return user;
        }
        return null;
    }

    @Override
    public void saveDetail(UserDetail userDetail) {
        hibernateTemplate.save(userDetail);
    }

    @Override
    public boolean checkUserExistsWithName(String username) {
        List<User> users = (List<User>)hibernateTemplate.find("from User u where u.username= '"+username+"'");
        if(users!=null && users.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public List<UserDetail> getUsersDetail() {
        return hibernateTemplate.find("from UserDetail");
    }

    @Override
    public Loan getLoan(int id) {
        return (Loan)hibernateTemplate.load(Loan.class,id);
    }

    @Override
    public void addMoney(String username, int money) {
        User user = getUser(username);
        user.setMoney(user.getMoney()+money);
        hibernateTemplate.update(user);
    }

    @Override
    public void updateLoan(int loanid) {
        hibernateTemplate.update(this.getLoan(loanid));
    }

    @Override
    public void updateUser(String username) {
        hibernateTemplate.update(getUser(username));
    }
}
