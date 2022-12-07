<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/10
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        jstl的使用步骤，
            导入需要的jar包
             在需要使用jstl的jsp页面中，使用taglib指令引入核心标签库
    --%>
    <%
        request.setAttribute("age",18);
    %>
    <c:if test="${age >= 18}" var="flag" scope="page">
        已经成年
    </c:if>
    <c:if test="${age < 18}" var="flag" scope="page">
        未成年
    </c:if>
</body>
</html>
