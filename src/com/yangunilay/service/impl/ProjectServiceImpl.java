package com.yangunilay.service.impl;

import com.yangunilay.dao.ProjectDao;
import com.yangunilay.model.Loan;
import com.yangunilay.model.UserDetail;
import com.yangunilay.service.ProjectService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/13/13
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "projectServiceImpl")
@Scope("prototype")
public class ProjectServiceImpl implements ProjectService{
    ProjectDao projectDao;

    public ProjectDao getProjectDao() {
        return projectDao;
    }
    @Resource(name = "projectDaoImpl")
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }
    @Transactional
    @Override
    public List<UserDetail> listUsersDetail() {
        return projectDao.getUsersDetail();
    }

    @Override
    @Transactional
    public boolean deleteUserDetail(int id) {
        return projectDao.deleteUserDetailFromId(id);
    }

    @Transactional
    @Override
    public boolean modifyUserDetail(UserDetail userDetail) {
        return projectDao.modifyUserDetail(userDetail);
    }

    @Transactional
    @Override
    public boolean addLoan(Loan loan){
        return projectDao.addLoan(loan);
    }
    @Override
    public UserDetail getUserDetail(int id) {
        return projectDao.getUserDetail(id);
    }
    @Transactional
    @Override
    public List<Loan> listLoan() {
        return projectDao.listLoan();
    }
    @Transactional
    @Override
    public boolean deleteLoan(int id) {
        return  projectDao.deleteLoan(id);
    }
    @Transactional
    @Override
    public boolean modifyLoan(Loan loan) {
        return projectDao.modifyLoan(loan);
    }
    @Transactional
    @Override
    public Loan getLoan(int id) {
        return projectDao.getLoan(id);
    }
}
