<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/7
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <div>
        <label for="name">登录名:</label>
        <input type="text" id="name" name="name"/>
    </div>
    <div>
        <label for="pwd">密码:</label>
        <input type="text" id="pwd" name="pwd"/>
    </div>
    <div>
        <input type="submit" value="登录"/>
    </div>
</form>
</body>
</html>
