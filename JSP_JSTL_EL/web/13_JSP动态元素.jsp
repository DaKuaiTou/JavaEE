<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/3
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态元素</title>
</head>
<body>
<%!
    int x=3;
    int y=4;
%>
<jsp:include page="common.jsp"></jsp:include>
<h3>x+y=<%=x+y%></h3>
</body>
</html>
