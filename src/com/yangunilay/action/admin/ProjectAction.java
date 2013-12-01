package com.yangunilay.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yangunilay.action.UserAction;
import com.yangunilay.dto.PageBean;
import com.yangunilay.model.Loan;
import com.yangunilay.model.User;
import com.yangunilay.model.UserDetail;
import com.yangunilay.service.MemberService;
import com.yangunilay.service.ProjectService;
import com.yangunilay.service.UserService;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/13/13
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "ProjectAction")
@Scope("prototype")
public class ProjectAction extends ActionSupport{
    @Resource(name = "projectServiceImpl")
    private ProjectService projectService;
    @Resource(name = "memberServiceImpl")
    private MemberService memberService;
    private String userDetailString;
    private String loanString;
    private UserDetail userDetail;
    private Loan loan;
    private HashMap<String, Object> dataMap;
    private int id;
    private String success;
    private int userdetailid;
    private PageBean pageBean;
    private int page;
    @Resource(name = "userServiceImpl")
    private UserService userService;
    private String returnUrl;
    private Map session;

    public ProjectAction(){
        dataMap = new HashMap<String, Object>();
        session= ActionContext.getContext().getSession();
        //System.out.println("------------------'\n'"+"-------------"+"prototype"+"\n"+"------------------");
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }


    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    /*@Resource(name = "memberServiceImpl")不起作用了，action归struts2-spring-plugin插件管，不归spring管，spring容器产生负责给action用的对象
    * 做法：1。把@Resource(name = "projectServiceImpl")写在private 属性上
    *      2。在action上什么都不写，默认按照名字自动注入，把名字都约定好，而ServiceImpl上写上@Component action对应service属性的名字就行
    *      3.按照类型注入，将struts2-spring-plugin改成按类型注入，则 ServiceImpl上写上@Component也不用写了
    * */
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String getUserDetailString() {
        return userDetailString;
    }

    public void setUserDetailString(String userDetailString) {
        //System.out.println("------------------'\n'"+"-------------"+"yes"+"\n"+"------------------");
        JSONObject jsonObject = JSONObject.fromObject(userDetailString);
        UserDetail bean = (UserDetail) JSONObject.toBean(jsonObject, UserDetail.class);
        this.userDetail = bean;
        //System.out.println("------------------'\n'"+"-------------"+userDetail+"\n"+"------------------");
    }

    public String getLoanString() {
        return loanString;
    }

    public String loan(){
        System.out.println("----------"+session+"----------");
        if(session.containsKey("login") && session.get("login").equals(Boolean.TRUE)){
            String username = (String)session.get("username");
            User user = userService.getUser(username);
            System.out.println("------------"+user+"----------");
            System.out.println("------------"+userDetail+"----------");
            userDetail.setUser(user);
            userService.addDetail(userDetail);
            return SUCCESS;
        }else {
            this.returnUrl = "/user/loan.jsp";
            return "login";
        }
    }

    public void setLoanString(String loanString) {
        JSONObject jsonObject = JSONObject.fromObject(loanString);
        //System.out.println("------------------'\n'"+"-------------"+jsonObject.get("userdetailid").equals("")+"----"+"\n"+"------------------");
        //if(jsonObject.get("userdetailid").equals("")!=true){
            userdetailid = jsonObject.getInt("userdetailid"); //这里出问题了
        //}
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String [] startTimesStr = startTime.split(" ");
        String [] endTimesStr = endTime.split(" ");
        int [] startTimesInt = new int[3];
        int [] endTimesInt = new int[3];
        for(int i = 0;i<startTimesStr.length;i++){
            startTimesInt[i] = Integer.parseInt(startTimesStr[i]);

        }
        for(int i = 0;i<endTimesStr.length;i++){
            endTimesInt[i] = Integer.parseInt(endTimesStr[i]);
        }
        jsonObject.put("startTime",new Date(startTimesInt[2]-1900,startTimesInt[0]-1,startTimesInt[1]));
        jsonObject.put("endTime",new Date(endTimesInt[2]-1900,endTimesInt[0]-1,endTimesInt[1]));
        Loan bean = (Loan) JSONObject.toBean(jsonObject, Loan.class);
        this.loan = bean;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public HashMap<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String listUsersDetail(){
        List<UserDetail> userDetailList = new ArrayList<UserDetail>();
        dataMap.put("success",false);
        /*for(UserDetail userDetail:projectService.listUsersDetail()){
            this.userDetailList.add(userDetail);
        }*/
        //System.out.println("------------------'\n'"+"-------------"+"projectService"+projectService.getClass()+"----"+"\n"+"------------------");
        for(UserDetail userDetail:projectService.listUsersDetail()){
            userDetailList.add(userDetail);
        }
        dataMap.put("userDetailList",userDetailList);
        dataMap.put("success",true);
        return SUCCESS;
    }

    public String deleteUserDetail(){
        if(projectService.deleteUserDetail(id) == true){
            dataMap.put("success",true);

        }else{
            dataMap.put("success",false);
        }
        return SUCCESS;
    }

    public String modifyUserDetail(){
        if(projectService.modifyUserDetail(userDetail)){
            dataMap.put("success",true);

        }else{
            dataMap.put("success",false);
        }
        return SUCCESS;
    }

    public String addLoan(){
        loan.setUserDetail(projectService.getUserDetail(userdetailid));
        if(projectService.addLoan(loan)){
            dataMap.put("success",true);
        }else {
            dataMap.put("success",false);
        }
        return SUCCESS;
    }

    public String listLoan(){
        List<Loan> loanList = new ArrayList<Loan>();
        dataMap.put("success",false);
        /*for(UserDetail userDetail:projectService.listUsersDetail()){
            this.userDetailList.add(userDetail);
        }*/
        //System.out.println("------------------'\n'"+"-------------"+"projectService"+projectService==null+"----"+"\n"+"------------------");
        for(Loan loan:projectService.listLoan()){
            Date nowDate = new Date();
            Date endDate = loan.getEndTime();
            //System.out.println("------------------'\n'"+"-------------"+"nowDate:"+nowDate+"----"+"\n"+"------------------");
            //System.out.println("------------------'\n'"+"-------------"+"startDate:"+endDate+"----"+"\n"+"------------------");
            long time = endDate.getTime() - nowDate.getTime();
            //System.out.println("------------------'\n'"+"-------------"+"time"+time+"----"+"\n"+"------------------");
            int days =(int)(time / (1000 * 60 * 60 * 24)+1);
            //System.out.println("------------------'\n'"+"-------------"+"days"+days+"----"+"\n"+"------------------");
            loan.setRemainDay(days);
            loanList.add(loan);
        }

        dataMap.put("loanList",loanList);
        dataMap.put("success",true);
        return SUCCESS;
    }

    public String deleteLoan(){
        if(projectService.deleteLoan(id) == true){
            dataMap.put("success",true);

        }else{
            dataMap.put("success",false);
        }
        return SUCCESS;
    }

    public String modifyLoan(){
        //loan.setUserDetail(projectService.getUserDetail(userdetailid));
        //System.out.println("------------------'\n'"+"-------------"+loanString+"----"+"\n"+"------------------");
        if(projectService.modifyLoan(loan)){
            dataMap.put("success",true);
        }else{
            dataMap.put("success",false);
        }
        return SUCCESS;
    }
    public String listLoans(){
        this.pageBean = memberService.queryForPage(5,page,"Loan");
        return SUCCESS;
    }

    public String loanDetail(){
        this.loan = projectService.getLoan(id);
        return SUCCESS;
    }
}
