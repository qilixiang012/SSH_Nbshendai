package com.yangunilay.dao.impl;

import com.yangunilay.dao.ProjectDao;
import com.yangunilay.model.Loan;
import com.yangunilay.model.UserDetail;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.yangunilay.model.UserDetail;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/13/13
 * Time: 8:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "projectDaoImpl")
public class ProjectDaoImpl implements ProjectDao{
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserDetail> getUsersDetail() {
        return hibernateTemplate.find("from UserDetail");
    }

    @Override
    public boolean deleteUserDetailFromId(int id) {
        //System.out.println(hibernateTemplate.get(UserDetail.class,id).toString());
        if(hibernateTemplate.contains(hibernateTemplate.load(UserDetail.class,id))){
            try{
                hibernateTemplate.delete(hibernateTemplate.load(UserDetail.class,id));
            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
        }else {

            return false;
        }
    }

    @Override
    public boolean modifyUserDetail(UserDetail userDetail) {
        if(hibernateTemplate.contains(hibernateTemplate.load(UserDetail.class,userDetail.getId()))){
            hibernateTemplate.update(userDetail);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addLoan(Loan loan) {
        hibernateTemplate.save(loan);
        return true;
    }

    @Override
    public UserDetail getUserDetail(int id) {
        List<UserDetail> userDetailList;
        userDetailList = hibernateTemplate.find("from UserDetail u where u.id = "+id);
        UserDetail userDetail = userDetailList.get(0);
        return userDetail;
    }

    @Override
    public List<Loan> listLoan() {
        return hibernateTemplate.find("from Loan");
    }

    @Override
    public boolean deleteLoan(int id) {
        if(hibernateTemplate.contains(hibernateTemplate.load(Loan.class,id))){
            try{
                hibernateTemplate.delete(hibernateTemplate.load(Loan.class,id));
            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean modifyLoan(Loan loan) {
        Loan loan1 = (Loan)hibernateTemplate.load(Loan.class,loan.getId());
        //System.out.println("------------------'\n'"+"-------------"+loan1.toString()+"----"+"\n"+"------------------");
        if(hibernateTemplate.contains(loan1)){
            loan1.setFinish(loan.getFinish());
            loan1.setName(loan.getName());
            loan1.setRate(loan.getRate());
            loan1.setRemainMoney(loan.getRemainMoney());
            loan1.setStartTime(loan.getStartTime());
            hibernateTemplate.update(loan1);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Loan getLoan(int id) {
        List<Loan> loanList;
        loanList = hibernateTemplate.find("from Loan l where l.id = "+id);
        Loan loan = loanList.get(0);
        return loan;
    }
}
