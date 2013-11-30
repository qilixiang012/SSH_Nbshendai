<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/3/13
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    if (session.getAttribute("login") != Boolean.TRUE) {
        response.sendRedirect("/user/login.jsp");
        return;
    }

/*    session.setAttribute("username",request.getAttribute("username"));
*     request.getAttribute("username");为什么会是空
* */
%>
<html>
<head>
    <title></title>
</head>
<body>
<s:debug></s:debug>
<div>
    <ul>
        <li id="Home"><a href="/index.html">首页</a></li>
        <li id="Project"><a href="Project_listLoans">我要投资</a></li>
        <li id="Loan"><a href="/user/loan.jsp">我要融资</a></li>
        <li id="Account"><a href="">我的账户</a></li>
        <li id="signout"><a href="User_signout">退出登录</a></li>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

<form action="User_loan" method="post">
    企业名称：<input type="text" name="userDetail.company"/><br>
    联系人： <input type="text" name="userDetail.contact"/><br>
    手机号码： <input type="text" name="userDetail.phone"/><br>
    意向融资金额： <input type="text" name="userDetail.amount"/><br>
    所在区域： <select name="userDetail.area">
    <option>云南</option>
    <option>北京</option>
</select>
    预期融资期限：<select name="userDetail.period">
    <option value=""></option>
    <option value="302">15 天以内</option>
    <option value="303">15 - 30 天</option>
    <option value="304">1 - 3 个月</option>
    <option value="305">3 - 6 个月</option>
    <option value="306">6 个月 - 1 年</option>
    <option value="307">1 年以上</option>
    <option value="308">其他期限</option>
</select>
    所屬行业：<select name="userDetail.industry">
    <option value=""></option>
    <option value="401">农林牧渔业</option>
    <option value="407">采矿业</option>
    <option value="415">制造业</option>
    <option value="447">电力、热力、燃气及水生产和供应业</option>
    <option value="451">建筑业</option>
    <option value="456">批发和零售业</option>
    <option value="459">交通运输、仓储和邮政业</option>
    <option value="468">住宿和餐饮业</option>
    <option value="471">信息传输、软件和信息技术服务业</option>
    <option value="475">金融业</option>
    <option value="480">房地产业</option>
    <option value="481">租赁和商务服务业</option>
    <option value="484">科学研究和技术服务业</option>
    <option value="488">水利、环境和公共设施管理业</option>
    <option value="492">居民服务、修理和其他服务业</option>
    <option value="496">教育</option>
    <option value="497">卫生和社会工作</option>
    <option value="500">文化、体育和娱乐业</option>
    <option value="506">其他</option>
</select>
    备注说明： <textarea name="userDetail.remark" cols="30" rows="10">
</textarea>
    <input type="submit" value="提交"/>
</form>
</body>
</html>