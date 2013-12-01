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
<s:debug></s:debug>
<div>
    <ul>
        <li id="Home"><a href="/index.html">首页</a></li>
        <li id="Project"><a href="Project_listLoans">我要投资</a></li>
        <li id="Loan"><a href="/user/loan.jsp">我要融资</a></li>
        <li id="Account"><a href="">我的账户</a></li>
        <s:if test="#session.login">
            <li id="signout"><a href="User_signout">退出登录</a></li>
        </s:if>
    </ul>
    <ul>
        <li></li>
        <li></li>
    </ul>
</div>

<div>您尚未进行手机验证。为了您的账户安全，您只有在完成手机验证后才能进行投融资。积木盒子也将会全程维护您的隐私安全。
    <a href="">立即验证</a>
</div>
<div>
    <h3></h3>
    <dl>
        <dt>汇款账户</dt>
        <dd><a href="">开通</a></dd>
        <dt>实名认证</dt>
        <dd><a href="">认证</a></dd>
        <dt>手机验证</dt>
        <dd><a href="">验证</a></dd>
        <dt>邮箱绑定</dt>
        <dd><a href="">验证</a></dd>
        <dt>登陆密码</dt>
        <dd><a href="">修改</a></dd>
    </dl>
</div>
<div>
    <h3>您尚未进行实名认证<a href="">立即认证</a></h3>

    <p>只有进行实名认证后才能开通第三方支付帐号进行投融资</p>
</div>
<div>
    <h3>投标概况</h3>
    <span><a href="" title="查看详情"></a></span>

    <div>
        <table>
            <thead>
            <tr>
                <th>状态</th>
                <th>笔数</th>
                <th>金额</th>
            </tr>
            </thead>
            <tdoby>
                <tr>
                    <td>回款中</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>投标中</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>已回款</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>总计</td>
                    <td></td>
                    <td></td>
                </tr>
            </tdoby>
        </table>
    </div>
</div>
<div>
    <h3>回款计划</h3>
    <span><a href="" title="查看详情"></a></span>

    <div>
        <table>
            <thead>
            <tr>
                <th>状态</th>
                <th>笔数</th>
                <th>金额</th>
            </tr>
            </thead>
            <tdoby>
                <tr>
                    <td>本月</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>下月</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>本年</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>总计</td>
                    <td></td>
                    <td></td>
                </tr>
            </tdoby>
        </table>
    </div>
</div>
<div>
    <div>
        <h3>最近交易</h3>
        <span><a href="" title="查看详情"></a></span>
    </div>
    <div>
        <div>您最近没有交易</div>
    </div>
</div>

</body>
</html>