package com.yangunilay.service.impl;

import com.yangunilay.dao.MemberDao;
import com.yangunilay.dto.PageBean;
import com.yangunilay.model.User;
import com.yangunilay.service.MemberService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/8/13
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "memberServiceImpl")
public class MemberServiceImpl implements MemberService {

    //通过applicationContext.xml配置文件注入MemberDao的值
    @Resource(name = "memberDaoImpl")
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


/** *//**
* 分页查询
* @param page 当前第几页
* @param pageSize 每页大小
* @return 封闭了分页信息(包括记录集list)的Bean
*/
    @Transactional
    public PageBean queryForPage(int pageSize, int page ,String object) {

        final String hql = "from "+object;//查询语句
        int allRow = memberDao.getAllRowCount(hql);//总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
        final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
        final int currentPage = PageBean.countCurrentPage(page);
        final int length = pageSize;//每页记录数
        /*List<Member> list = memberDao.queryForPage(hql, offset, length);//"一页"的记录*/
        //List<object> list = memberDao.queryForPage(hql, offset, length);

        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(memberDao.queryForPage(hql, offset, length));
        pageBean.init();
        return pageBean;
    }
}