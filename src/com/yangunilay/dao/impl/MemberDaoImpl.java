package com.yangunilay.dao.impl;

import com.yangunilay.dao.MemberDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/8/13
 * Time: 8:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "memberDaoImpl")
public class MemberDaoImpl implements MemberDao {

    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

  //省略了其他的代码　　
/** *//**
* 分页查询
* @param hql 查询的条件
* @param offset 开始记录
* @param length 一次查询几条记录
* @return
*/
    public List queryForPage(final String hql, final int offset, final int length) {
        List list = hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(hql);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
            }
        });
        return list;
    }

/** *//**
* 查询所有记录数
* @return 总记录数
*/
    public int getAllRowCount(String hql) {
        return hibernateTemplate.find(hql).size();
    }
}
