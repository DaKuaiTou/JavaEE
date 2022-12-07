<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/10
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="9" step="1" var="i">
        <c:forEach begin="1" end="${i}" step="1" var="j">
            ${j} × ${i} = ${i*j}
        </c:forEach><br>
    </c:forEach>
</body>
</html>
