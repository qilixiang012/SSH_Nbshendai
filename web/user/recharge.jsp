<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/25/13
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="User_recharge?id=<%=request.getParameter("id")%>" method="post">
    <input type="text" name="money"/>
    <input type="submit"/>
</form>
</body>
<s:debug></s:debug>
</html>