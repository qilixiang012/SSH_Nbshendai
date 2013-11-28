package com.yangunilay.dao;

import com.yangunilay.model.Loan;
import com.yangunilay.model.UserDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/13/13
 * Time: 8:32 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProjectDao {
    public List<UserDetail> getUsersDetail();
    public boolean deleteUserDetailFromId(int id);
    public boolean modifyUserDetail(UserDetail userDetail);
    public boolean addLoan(Loan loan);
    public UserDetail getUserDetail(int id);
    public List<Loan> listLoan();
    public boolean deleteLoan(int id);
    public boolean modifyLoan(Loan loan);
    public Loan getLoan(int id);
}
