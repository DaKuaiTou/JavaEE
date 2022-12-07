<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/3
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求转发</title>
</head>
<body>
<jsp:forward page="common.jsp">
    <jsp:param name="username" value="张三"/>
    <jsp:param name="password" value="zhangsan123"/>
</jsp:forward>
张颜宇
</body>
</html>
