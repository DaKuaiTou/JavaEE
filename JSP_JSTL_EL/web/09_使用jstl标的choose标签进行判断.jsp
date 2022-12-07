<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/10
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" placeholder="请输入成绩" name="sc">
<input type="button" value="查询" onclick="search()">
<%
    request.setAttribute("score",100);
%>
<c:choose>
    <c:when test="${score >= 90 && score <= 100}">
        优秀
    </c:when>
    <c:when test="${score >= 60 && score <90}">
        良好
    </c:when>
    <c:when test="${score >= 1 && score < 60}">
        差
    </c:when>
    <c:otherwise>
        <h1>请输入正确的成绩</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
