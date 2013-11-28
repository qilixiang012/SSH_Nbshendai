package com.yangunilay.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yangunilay.dto.PageBean;
import com.yangunilay.model.User;
import com.yangunilay.service.MemberService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/8/13
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "ListMemberAction")
@Scope("prototype")
public class ListMemberAction extends ActionSupport {
    //通过applicationContext.xml配置文件注入memberService的值
    @Resource(name = "memberServiceImpl")
    private MemberService memberService;

    private int page;
    //第几页

    private PageBean pageBean;
    //包含分布信息的bean

    public void setMemberService(MemberService memberService) {
       this.memberService = memberService;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {//若URL中无此参数,会默认为第1页
        this.page = page;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    @Override
    public String execute() throws Exception {
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
        User user =new User();
        this.pageBean = memberService.queryForPage(2, page ,"User");
        return SUCCESS;
    }
}