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

<div class="wall">

    <!--start: Project-item -->
    <div>
        <div>
            <h4>
                <small><span>投标中</span></small>
                某林产品开发有限公司自由用途贷款 第七期
                <small>编号 353</small>
            </h4>
            <div>
                <a title="已实名认证"></a>
                <a title="已完成尽职调查"></a>
                <a title="已完成风险评估"></a>
                <a href="/Home/Security" title="100% 保本保息"></a>
            </div>
        </div>
        <div></div>
        <div>
            <div>
                <span>本期融资金额</span>
                <span>50.00 万</span>
            </div>

            <div>
                <span>年化利率</span>
                <span>11%</span>
            </div>

            <div>
                <span>融资期限</span>
                <span>6 个月</span>
            </div>
        </div>
    </div>
    <!--end: Project-item -->
    <div>
        <hr>
        <!--Start: Project-Action -->
        <div>

            <div>
                <dl>
                    <dt>剩余时间</dt>
                    <dd>5 天 5 小时 21 分</dd>
                </dl>
            </div>

            <div>
                <dl>
                    <dt>投标进度</dt>
                    <dd>
                        <div>
                            <div>26.18%</div>
                            <div></div>
                        </div>
                    </dd>
                </dl>
            </div>

            <div>

                <dl>
                    <dt>可投资金额</dt>
                    <dd>369100.00</dd>
                </dl>
            </div>

            <div>
                <div>
                    <a href="/User/Login?ReturnUrl=http%3A%2F%2Fwww.jimubox.com%2FProject%2FIndex%2F353">登录</a>
                    后才能进行投资
                </div>
            </div>


        </div>
        <!--end: Project-Action -->
    </div>

    <hr>


    <p>
        <i></i>
        即刻投资，收益自
        <span>2013-11-09</span>
        起算，每万元投资预期可获利息
        <span>525.56</span>
        元
    </p>
</div>

</body>
</html>