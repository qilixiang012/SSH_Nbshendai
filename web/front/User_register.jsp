<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/2/13
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>积木盒子jimubox.com-安全、精准、高效的网络投融资平台</title>
</head>
<body>

<div>
    <ul>
        <li id="Home"><a href="/index.html">首页</a></li>
        <li id="Project"><a href="Project_listLoans">我要投资</a></li>
        <li id="Loan"><a href="/user/loan.jsp">我要融资</a></li>
        <li id="Account"><a href="">我的账户</a></li>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

<s:property value="userRegisterInfo.username"></s:property>,恭喜注册成功！
<p>页面将在<span id="time" readonly="true">10</span>秒后返回<a href="">返回</a></p>
</body>
<script language="javascript">
    var t = 10;
    var time = document.getElementById("time");
    function fun() {
        t--;
        time.innerText = t;
        if (t <= 0) {
            location.href = "/user/login.jsp";
            clearInterval(inter);
        }
    }
    var inter = setInterval("fun()", 1000);
</script>
</html>