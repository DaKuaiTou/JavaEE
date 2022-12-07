<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/11/5
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <%--导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<a href="list.jsp">查询所有联系人</a>
<a href="list_page.jsp?currentPage=1&pageSize=5">分页查询联系人</a>
</body>
</html>
