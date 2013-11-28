package com.yangunilay.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/8/13
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
    public interface MemberDao {
    //省略了其他的代码
/** *//**
* 分页查询
* @param hql 查询的条件
* @param offset 开始记录
* @param length 一次查询几条记录
* @return
*/
    public List queryForPage(final String hql, final int offset, final int length);

/** *//**
* 查询所有记录数
* @param hql 查询的条件
* @return 总记录数
*/
    public int getAllRowCount(String hql);
}