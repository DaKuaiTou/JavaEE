<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red">${errorMsg}</span>
<form action="rememberLogin" method="post">
    用户名：<input type="text" name="username" value="${cookie.username.value}"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="checkCode"><br>
    <img src="checkCode" id="code">
    <a href="javascript:void (0);" onclick="checkCode()">点击刷新验证码</a>
    <input type="checkbox" name="remember">记住用户名
    <input type="submit" value="提交">
</form>


<script>
    function checkCode() {
        let img = document.getElementById("code");
        img.setAttribute("src","checkCode?date="+new Date())
    }
</script>
</body>
</html>
