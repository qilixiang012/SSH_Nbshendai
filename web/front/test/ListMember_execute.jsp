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
<!-- 分页例子程序 -->
<s:iterator value="pageBean.list">
    　　　　　　<s:property value="username"/>
    　　　　　　<a href="getArticle.action?id=<s:property value="id"/>">modify</a>
    　　　　　　<a href="deleteArticle.action?id=<s:property value="id"/>" onclick="return askDel()"/>delete</a><br/>
    　　　　</s:iterator>
　　　　共<s:property value="pageBean.allRow"/> 条记录
　　　　共<s:property value="pageBean.totalPage"/> 页
　　　　当前第<s:property value="pageBean.currentPage"/>页<br/>
　　　　
　　　　<s:if test="%{pageBean.currentPage == 1}">
    　　　　　　第一页 上一页
    　　　　</s:if>
　　　　<s:else>
    　　　　　　<a href="ListMember_execute?page=1">第一页</a>
    　　　　　　<a href="ListMember_execute?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
    　　　　</s:else>
　　　　<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
    　　　　　　<a href="ListMember_execute?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
    　　　　　　<a href="ListMember_execute?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
    　　　　</s:if>
　　　　<s:else>
    　　　　　　下一页 最后一页
    　　　　</s:else>
<!-- 分页例子程序 -->

</body>
</html>