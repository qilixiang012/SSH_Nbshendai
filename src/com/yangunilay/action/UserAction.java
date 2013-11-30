package com.yangunilay.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yangunilay.dto.PageBean;
import com.yangunilay.dto.UserLoginInfo;
import com.yangunilay.dto.UserRegisterInfo;
import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;
import com.yangunilay.service.MemberService;
import com.yangunilay.service.UserService;
import com.yangunilay.service.impl.UserServiceImpl;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 10/30/13
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "UserAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
    private UserRegisterInfo userRegisterInfo;
    private UserLoginInfo userLoginInfo;
    private UserDetail userDetail;
    private List<UserDetail> userDetailList;
    private List<User> userList;
    private PageBean pageBean;
    private MemberService memberService;
    private int page;
    private String returnUrl;
    private UserService userService;
    private Map<String,Object> session;
    private int money;
    private int id;
    private int availableMoney;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(int availableMoney) {
        this.availableMoney = availableMoney;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    @Resource(name = "memberServiceImpl")
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        if(returnUrl.equals("null")){
            this.returnUrl = "user/login.jsp";
        }else {
            this.returnUrl = returnUrl;
        }
    }

    public List<UserDetail> getUserDetailList() {
        return userDetailList;
    }

    public void setUserDetailList(List<UserDetail> userDetailList) {
        this.userDetailList = userDetailList;
    }



    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        this.session = stringObjectMap;
    }

    public UserRegisterInfo getUserRegisterInfo() {
        return userRegisterInfo;
    }

    public UserLoginInfo getUserLoginInfo() {
        return userLoginInfo;
    }

    public void setUserLoginInfo(UserLoginInfo userLoginInfo) {
        this.userLoginInfo = userLoginInfo;
    }

    public void setUserRegisterInfo(UserRegisterInfo userRegisterInfo) {
        this.userRegisterInfo = userRegisterInfo;
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource(name = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String register(){
        if(userRegisterInfo.getUsername() == null || userRegisterInfo.getLoginPassword() == null || userRegisterInfo.getEmail() ==null || userRegisterInfo.getMobile() == 0){
            return ERROR;
        }
        User user = new User();
        user.setUsername(userRegisterInfo.getUsername());
        user.setLoginPassword(userRegisterInfo.getLoginPassword());
        user.setEmail(userRegisterInfo.getEmail());
        user.setMobile(userRegisterInfo.getMobile());
        if(userService.add(user)==false){
            return ERROR;
        }
        return SUCCESS;
    }

    public String login(){
        /*if(session.get("login") == Boolean.TRUE){
            return SUCCESS;
        }*/
        if(userLoginInfo.getUsername() == null || !userService.exist(userLoginInfo.getUsername())){
            return ERROR;
        }
        User user = userService.getUser(userLoginInfo.getUsername());
        if(user == null){
            return ERROR;
        }
        if(userLoginInfo.getLoginPassword().equals(user.getLoginPassword())){
            session.put("login",Boolean.TRUE);
            session.put("username",userLoginInfo.getUsername());
            session.put("availableMoney",user.getMoney());
            return "redirectAction";
        }
        return ERROR;
    }

    public String loan(){
        if(session.get("login")==Boolean.FALSE){
            this.returnUrl = "/user/loan.jsp";
            return "redirectAction";
        }
        String username = (String)session.get("username");
        User user = userService.getUser(username);
        userDetail.setUser(user);
        userService.addDetail(userDetail);
        return SUCCESS;
    }

    public String listUsersDetail(){
        userDetailList = userService.listUsersDetail();
        this.pageBean = memberService.queryForPage(3, page, "UserDetail");
        return SUCCESS;
    }

    public String listUsers(){
        this.pageBean = memberService.queryForPage(2, page, "User");
        return SUCCESS;
    }

    public String recharge(){
        System.out.println("--------------"+returnUrl+"-------------");
        if(session.get("login")==Boolean.TRUE ){
            int rechargeSucc = userService.recharge((String)session.get("username"),money);
            if(rechargeSucc>0){
                returnUrl = "Project_loanDetail.action?id="+id;
                session.put("availableMoney",(Integer)session.get("availableMoney")+money);
                System.out.println("--------------"+availableMoney+"-------------");
                return "redirectAction";
            }else {
                return ERROR;
            }
        }
        return ERROR;
    }

    public String invest(){
        System.out.println("--------------"+id+"-----"+money+"------------------");
        if(userService.investValid((String)session.get("username"),money)){
            userService.addInvest((String)session.get("username"),money,id);
            session.put("availableMoney",(Integer)session.get("availableMoney")-money);
            return SUCCESS;
        }
        return ERROR;
    }

    public String signout(){
        this.session.put("login",Boolean.FALSE);
        return "login";
    }
}
