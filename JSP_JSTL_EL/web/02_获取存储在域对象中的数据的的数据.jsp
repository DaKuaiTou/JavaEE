<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 先往数组中存一些数据
        String [] names = {"张三","李四","王五","赵六","孙七"};
        request.setAttribute("names",names);
    %>

    获取存储在域对象中的第三个值：${names[2]}
</body>
</html>
