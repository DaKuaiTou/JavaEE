<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/10
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("老六");
        request.setAttribute("list",list);
    %>

    <table border="1" cellpadding="0" width="500">
        <tr>
            <th>下标</th>
            <th>序号</th>
            <th>姓名</th>
            <th>是否是第一个元素</th>
            <th>是否是最后一个元素</th>
        </tr>
        <c:forEach items="${list}" varStatus="name" var="n">
            <tr>
                <td>${name.index}</td>
                <td>${name.count}</td>
                <td>${name.current}</td>
                <td>${name.first}</td>
                <td>${name.last}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
