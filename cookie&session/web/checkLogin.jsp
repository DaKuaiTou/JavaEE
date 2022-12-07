<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/9/22
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码登录</title>
</head>
<body>
<span style="color: red">${errorMsg}</span>
<form action="login" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    验证码：<input type="text" name="checkCode"><br/>
    <img src="checkCode" id="code"/>
    <a href="javascript:void(0);" onclick="changeCheckCode()">点击刷新验证码</a>
    <input type="submit" value="提交">
</form>

<script>
    function changeCheckCode() {
        let img = document.getElementById("code");
        img.setAttribute("src","checkCode?date=" + new Date())
    }
</script>
</body>
</html>
