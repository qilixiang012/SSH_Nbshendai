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

<form action="User_register" method="post">
    用户名： <input type="text" name="userRegisterInfo.username"/> <br>
    登陆密码： <input type="password" name="userRegisterInfo.loginPassword"/><br>
    确认密码： <input type="password" name="userRegisterInfo.loginPasswordConfirm"/><br>
    手机号码： <input type="text" name="userRegisterInfo.mobile"/><br>
    邮箱地址： <input type="text" name="userRegisterInfo.email"/><br>
    验证码： <input type="text" name="valid"/><br>
    <label>
        <input type="checkbox" name="checkBox" checked="checked"/>
        <a href="">用户协议</a>
    </label>
    <input type="submit" value="注册"/>
</form>

</body>
</html>