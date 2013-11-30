<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/20/13
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <ul>
        <li id="Home"><a href="/index.html">首页</a></li>
        <li id="Project"><a href="Project_listLoans">我要投资</a></li>
        <li id="Loan"><a href="Project_loan">我要融资</a></li>
        <li id="Account"><a href="User_Detail">我的账户</a></li>
        <li id="signout"><a href="User_signout">退出登录</a></li>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

<s:iterator value="pageBean.list">
    <div>
        <div>
            <h4>
                <s:if test="%{finish}">
                    <small><span>还款中</span></small>
                </s:if>
                <s:else>
                    <small><span>投标中</span></small>
                </s:else>

                <a href="/Project/Index/352"><s:property value="name"></s:property>期</a>
                <small>编号 <s:property value="id"></s:property></small>
                <a href="Project_loanDetail?id=<s:property value="id" />">查看详情</a>
            </h4>
        </div>
        <div>
            <div>
                <span>融资金额</span><s:property value="userDetail.amount"></s:property>
            </div>
            <div>
                <span>年化利率</span>
                <span><s:property value="rate"></s:property></span>
            </div>
            <div>
                <span>融资期限</span>
                <s:if test="%{userDetail.period==302}">
                    <span>15 天以内</span>
                </s:if>
                <s:elseif test="%{userDetail.period==303}">
                    <span>15 - 30 天</span>
                </s:elseif>
                <s:elseif test="%{userDetail.period==304}">
                    <span>1 - 3 个月</span>
                </s:elseif>
                <s:elseif test="%{userDetail.period==305}">
                    <span>3 - 6 个月</span>
                </s:elseif>
                <s:elseif test="%{userDetail.period==306}">
                    <span>6 个月 - 1 年</span>
                </s:elseif>
                <s:elseif test="%{userDetail.period==307}">
                    <span>1 年以上</span>
                </s:elseif>
                <s:else>
                    <span>其他期限</span>
                </s:else>
                </span>
            </div>
            <div>
                <div>
                    <div>投标进度 0.56%</div>
                    <div></div>
                </div>
            </div>
        </div>
    </div>
</s:iterator>

<div>
    共<s:property value="pageBean.allRow"/> 条记录
    共<s:property value="pageBean.totalPage"/> 页
    当前第<s:property value="pageBean.currentPage"/>页<br/>
    　　　　
    <s:if test="%{pageBean.currentPage == 1}">
        　　　　　　第一页 上一页
    </s:if>
    <s:else>
        <a href="Project_listLoans?page=1">第一页</a>
        <a href="Project_listLoans?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
    </s:else>
    <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
        <a href="Project_listLoans?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
        <a href="Project_listLoans?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
    </s:if>
    <s:else>
        下一页 最后一页
    </s:else>
</div>

<s:debug></s:debug>

</body>
</html>