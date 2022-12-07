<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("passowrd","123456");
        map.put("phone","1354653");
        request.setAttribute("map",map);
    %>
    获取存储在域对象中的Map类型的数据nane的值为：${map.get("name")}<br>
    获取存储在域对象中的Map类型的数据nane的值为：${map.name}<br>
    获取存储在域对象中的Map类型的数据password的值为：${map.get("password")}<br>
    获取存储在域对象中的Map类型的数据phone的值为：${map.get("map")}
</body>
</html>
