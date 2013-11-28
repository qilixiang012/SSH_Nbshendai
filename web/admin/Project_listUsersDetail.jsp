<%--
  Created by IntelliJ IDEA.
  User: yyz
  Date: 11/13/13
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/extjs/resources/css/ext-all.css"/>
    <script type="text/javascript" src="/extjs/ext-all.js"/>
    <script type="text/javascript" src="/extjs/bootstrap.js"></script>
    <script type="text/javascript" src="/extjs/locale/ext-lang-zh_CN.js"></script>
    <script type="text/javascript">


        Ext.onReady(function () {

            Ext.create('Ext.grid.Panel', {
                title: '用户详情',
                renderTo: Ext.getBody(),
                width: 400,
                height: 170,
                frame: true,
                store: {

                    fields: ['company', 'contact', 'area', 'phone', 'period', 'industry', 'remark', 'amount', 'user.username'],
                    proxy: {
                        type: 'ajax',
                        url: '/admin/Project_listUsersDetail',
                        reader: {
                            type: 'json',
                            root: 'userDetailList'
                        }
                    },
                    autoLoad: true
                },
                columns: [
                    new Ext.grid.RowNumberer(),
                    {header: "公司", width: 80, dataIndex: 'company', sortable: true},
                    {header: "联系人", width: 80, dataIndex: 'contact', sortable: true},
                    {header: "地址", width: 80, dataIndex: 'area', sortable: true},
                    {header: "手机", width: 80, dataIndex: 'phone', sortable: true},
                    {header: "周期", width: 80, dataIndex: 'period', sortable: true},
                    {header: "产业", width: 80, dataIndex: 'industry', sortable: true},
                    {header: "备注", width: 80, dataIndex: 'remark', sortable: true},
                    {header: "数额", width: 80, dataIndex: 'amount', sortable: true},
                    {header: "用户", width: 80, dataIndex: 'user.username', sortable: true}
                ]
            })
        });
    </script>
</head>
<body>
</body>
</html>