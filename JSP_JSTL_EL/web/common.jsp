<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/3
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int x;
    int y;
%>
x+y=<%=x+y%>
<%
    String username = request.getParameter("username");
    request.getParameter("password");
%>
<%=
    username
%>

张颜宇
</body>
</html>
