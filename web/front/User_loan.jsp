<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/3/13
  Time: 6:51 PM
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
        <li id="signout"><a href="User_signout">退出登录</a></li>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

您的信息已经收到，我们将尽快与您取得联系！
<p>页面将在<span id="time" readonly="true">10</span>秒后返回<a href="">返回</a></p>
</body>
<script language="javascript">
    var t = 10;
    var time = document.getElementById("time");
    function fun() {
        t--;
        time.innerText = t;
        if (t <= 0) {
            location.href = "/user/loan.jsp";
            clearInterval(inter);
        }
    }
    var inter = setInterval("fun()", 1000);
</script>
</html>