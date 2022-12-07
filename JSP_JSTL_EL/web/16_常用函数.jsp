<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/6
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="name1" value="abcde"></c:set>
<c:set var="name2" value="${fn:split(name1, '')}"/>
<c:set var="name3" value="${fn:join(name2,'_')}"/>
${name3}
</body>
</html>
