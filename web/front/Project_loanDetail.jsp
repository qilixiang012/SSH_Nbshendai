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
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

<div>
    <div>
        <h4>
            <s:if test="%{loan.finish}">
                <small><span>还款中</span></small>
            </s:if>
            <s:else>
                <small><span>投标中</span></small>
            </s:else>

            <a href="/Project/Index/352"><s:property value="loan.name"></s:property>期</a>
            <small>编号 <s:property value="loan.id"></s:property></small>
        </h4>
    </div>
    <div>
        <div>
            <span>融资金额</span><s:property value="loan.userDetail.amount"></s:property>
        </div>
        <div>
            <span>年化利率</span>
            <span><s:property value="loan.rate"></s:property></span>
        </div>
        <div>
            <span>融资期限</span>
            <s:if test="%{loan.userDetail.period==302}">
                <span>15 天以内</span>
            </s:if>
            <s:elseif test="%{loan.userDetail.period==303}">
                <span>15 - 30 天</span>
            </s:elseif>
            <s:elseif test="%{loan.userDetail.period==304}">
                <span>1 - 3 个月</span>
            </s:elseif>
            <s:elseif test="%{loan.userDetail.period==305}">
                <span>3 - 6 个月</span>
            </s:elseif>
            <s:elseif test="%{loan.userDetail.period==306}">
                <span>6 个月 - 1 年</span>
            </s:elseif>
            <s:elseif test="%{loan.userDetail.period==307}">
                <span>1 年以上</span>
            </s:elseif>
            <s:else>
                <span>其他期限</span>
            </s:else>
            </span>
        </div>
        <div>
            <span>剩余时间<s:property value="loan.remainDay"/></span>
            <span>投资金额<s:property value="loan.remainMoney"/></span>
            <%
                if (session.getAttribute("login") == Boolean.TRUE) {
            %>
            <form action="User_invest" method="post">
                <div>
                    <div>
                        <input type="text" name="money" value="100">
                        <span>元</span>
                    </div>
                </div>
                <input type="hidden" name="id" value="<s:property value="id"/>">
                <button type="submit">投标</button>
            </form>
            <div>投标金额应为 100.00 的整数倍</div>
            <div>可用余额：<%=session.getAttribute("availableMoney")%><a
                    href="/user/recharge.jsp?id=<s:property value="id"/>">[充值]</a></div>
            <%
            } else {
            %>
            <span><a
                    href="/user/login.jsp?returnUrl=Project_loanDetail?id=<s:property value="id"/>">登录</a>后才能进行投资</span>
            <%
                }
            %>
        </div>
    </div>
</div>

<s:debug></s:debug>

</body>
</html>