<%@ page import="com.dkt.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 往域对象中存储一些数据
        User user = new User();
        request.setAttribute("user",user);
        request.setAttribute("str","");
        request.setAttribute("msg","strValue");
        // 往域对象中插入一个集合
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        request.setAttribute("list",list);
    %>

    EL表达式中的empty运算符的使用，user对象是否为空:${!empty user}
    EL表达式中的empty运算符的使用，str字符串是否为空:${empty str}
    EL表达式中的empty运算符的使用，list集合的长度是否为0：${not empty list}
</body>
</html>
