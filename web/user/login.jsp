<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/2/13
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        .code {
            background-image: url(code.jpg);
            font-family: Arial;
            font-style: italic;
            color: Red;
            border: 0;
            padding: 2px 3px;
            letter-spacing: 3px;
            font-weight: bolder;
        }

        .unchanged {
            border: 0;
        }
    </style>
    <script language="javascript" type="text/javascript">

        var code; //在全局 定义验证码
        function createCode() {
            code = "";
            var codeLength = 6;//验证码的长度
            var checkCode = document.getElementById("checkCode");

            var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//所有候选组成验证码的字符，当然也可以用中文的

            for (var i = 0; i < codeLength; i++) {


                var charIndex = Math.floor(Math.random() * 36);
                code += selectChar[charIndex];


            }
//       alert(code);
            if (checkCode) {
                checkCode.className = "code";
                checkCode.value = code;
            }

        }

        function validate() {
            var inputCode = document.getElementById("input1").value;
            if (inputCode.length <= 0) {
                alert("请输入验证码！");
            }
            else if (inputCode != code) {
                alert("验证码输入错误！");
                createCode();//刷新验证码
            }
            else {
                document.getElementById("myFrom").submit();
            }
        }
    </script>
</head>
<body onload="createCode()">

<div>
    <ul>
        <li id="Home"><a href="/index.html">首页</a></li>
        <li id="Project"><a href="Project_listLoans">我要投资</a></li>
        <li id="Loan"><a href="/user/User_loan">我要融资</a></li>
        <li id="Account"><a href="">我的账户</a></li>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

登陆 没有帐号？<a href="/user/register.jsp">免费注册</a>

<form action="User_login?returnUrl=<%=request.getParameter("returnUrl")%>" method="post" id="myFrom" name="myFrom">
    用戶名：<br>
    <input type="text" name="userLoginInfo.username"/><br>
    密码： <a href=""><span>忘记密码</span></a><br>
    <input type="password" name="userLoginInfo.loginPassword"/><br>
    验证码：<br>
    <input type="text" id="input1"/>
    <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 80px"/><br/>
    <input onclick="validate();" type="button" value="提交"/>
</form>
<s:debug></s:debug>
</body>
</html>