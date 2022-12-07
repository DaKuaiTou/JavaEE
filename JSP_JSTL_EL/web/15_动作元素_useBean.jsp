<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/3
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
   <%--
     jsp的动作元素useBean可以用来实例化类。
     <jsp:useBean>标签用来实现化类。
       id属性表示实例化对象的唯一标识
       class属性表示类的全限定名(全限定名就是包名.类名)

   --%>
   <jsp:useBean id="user" class="com.dkt.domain.User">
       <jsp:setProperty name="user" property="username" value="lisi"/>
   </jsp:useBean>
   <%--
     <jsp:setProperty>标签可以给实例化对象的属性设置值
        name属性表示实例化对象的名称，必须和useBean标签id属性的值一样
        property表示实例化对象的属性名
        value表示属性值
   --%>

    <%--
      <jsp:getProperty> 标签获取实例化对象属性的值
    --%>
   username=<jsp:getProperty name="user" property="username"/>
</body>
</html>
