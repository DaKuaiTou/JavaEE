<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/9
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        String value = "";
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equalsIgnoreCase("JSESSIONID")){
                    value = cookie.getValue();
                }
            }
        }
    %>
    使用原始方式获取cookie当中的JSESSIONID的cookie值：<%=value%><br>
    使用el表达式获取存放在Cookie中的数据JSESSIONID的cookie的值：${cookie.JESSIONID.value}
</body>
</html>
