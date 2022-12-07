<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        application.setAttribute("msg","这是application域对象中的数据");
        request.setAttribute("msg","这是request域对象中的数据");
        session.setAttribute("msg","这是session域对象中的数据");
    %>

    存放在application中的msg值是：${applicationScope.msg}<br>
    存放在request中的msg值是：${sessionScope.msg}<br>
    存放在session中的msg值是：${requestScope.msg}<br>
</body>
</html>
