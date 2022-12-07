<%@ page import="com.dkt.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user = new User();
        user.setUsername("张颜宇");
        user.setPassword("123456");
        user.setAddress("西安");
        request.setAttribute("user",user);
    %>
    获取存储在域对象中domain类型的数据，username的值为：${user.username}<br>
    获取存储在域对象中domain类型的数据，password的值为：${user.password}<br>
    获取存储在域对象中domian类型的数据，address的值为：${user.address}
</body>
</html>
