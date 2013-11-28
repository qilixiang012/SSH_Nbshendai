<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/7/13
  Time: 12:30 PM
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
        <li id="Loan"><a href="/user/loan.jsp?username=<s:property value="" />">我要融资</a></li>
        <li id="Account"><a href="">我的账户</a></li>
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
                <small><span>投标中</span></small>
                <a href="/Project/Index/352">某农副食品加工企业自由经营用途 第八期</a>
                <small>编号 <s:property value="id"></s:property></small>
                <a href="/Project/Index/353">查看详情</a>
            </h4>
            <a href="/Project/Index/352">查看详情</a>
        </div>
        <div>
            <div>
                <span>融资金额</span>
                <span><s:property value="amount"></s:property> 万</span>
            </div>
            <div>
                <span>年化利率</span>
                <span>12%</span>
            </div>
            <div>
                <span>融资期限</span>
                <span><s:property value="period"></s:property> </span>
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
    　　　　　　<a href="User_listUsersDetail?page=1">第一页</a>
    　　　　　　<a href="User_listUsersDetail?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
    　　　　</s:else>
    　　　　<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
    　　　　　　<a href="User_listUsersDetail?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
    　　　　　　<a href="User_listUsersDetail?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
    　　　　</s:if>
    　　　　<s:else>
    　　　　　　下一页 最后一页
    　　　　</s:else>
</div>


</body>
</html>