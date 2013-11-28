package com.yangunilay.service;

import com.yangunilay.dto.PageBean;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/8/13
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MemberService {
    //省略其他的代码

/** *//**
* 分页查询
* @param currentPage 当前第几页
* @param pageSize 每页大小
* @return 封闭了分页信息(包括记录集list)的Bean
*/
    public PageBean queryForPage(int pageSize, int currentPage ,String object);
}