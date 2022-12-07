<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 先往集合中存储一些数据
        List<String> list =new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        request.setAttribute("list",list);
    %>
    获取存储在域对象中list类型的第四个元素：${list[3]}<br>
    获取存储在域对象中list类型的第三个元素：${list.get(2)}
</body>
</html>
