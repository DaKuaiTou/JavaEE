<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/10/18
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>分页查询联系人</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">分页显示联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.personList}" var="person" varStatus="vst">
            <tr>
                <td>${vst.count}</td>
                <td>${person.name}</td>
                <td>${person.sex}</td>
                <td>${person.age}</td>
                <td>${person.address}</td>
                <td>${person.qq}</td>
                <td>${person.email}</td>
                <td><a class="btn btn-default btn-sm" href="linkPerson?action=findPerson&id=${person.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:;"
                       onclick="deleteLinkMan('${person.name}','${person.id}')">删除</a></td>

            </tr>
        </c:forEach>
        <td colspan="8" align="center">
            <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        </td>
        <tr>
            <td colspan="8" align="center">
                总联系人条数为${pageBean.totalSize}条<br>
                每页显示条数为${pageBean.pageSize}页
            </td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <ul class="pagination success">
                    <c:if test="${pageBean.currentPage != 1}">
                        <li>
                            <a href="linkPerson?action=findPersonByPage&currentPage=${pageBean.currentPage-1}&pageSize=${pageBean.pageSize}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                        <c:if test="${pageBean.currentPage == i}">
                            <li class="active"><a href="#">${i}</a></li>
                        </c:if>
                        <c:if test="${pageBean.currentPage != i}">
                            <li>
                                <a href="linkPerson?action=findPersonByPage&currentPage=${i}&pageSize=${pageBean.pageSize}">${i}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                        <li>
                            <a href="linkPerson?action=findPersonByPage&currentPage=${pageBean.currentPage+1}&pageSize=${pageBean.pageSize}"
                               aria-label="Previous">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </td>
        </tr>
    </table>
</div>

<script>
    //声明一个删除联系人的方法
    function deleteLinkMan(name, id) {
        //弹出一个确认框，询问是否真的要删除
        var flag = confirm("你确定要删除" + name + "吗?");
        //如果点击确定，返回值flag就为true，否则就为false
        if (flag) {
            //要删除联系人
            //发送请求给LinkManServlet进行删除联系人,并且携带action=delete&id=要删除的联系人id
            location.href = "linkPerson?action=deletePerson&id=" + id + "&type=page"
        }
    }
</script>
</body>
</html>



















