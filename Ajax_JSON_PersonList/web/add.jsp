<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/11/6
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加联系人</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getParameter.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="linkPerson" method="post" onsubmit="return false" id="personForm">
        <%--创建一个表单项(隐藏域)，携带action的参数值--%>
        <input type="hidden" name="action" value="addPerson" >

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东" selected>广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
                <option value="辽宁">辽宁</option>
                <option value="吉林">吉林</option>
                <option value="山西">山西</option>
                <option value="西安">西安</option>
                <option value="西安">广东</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" id="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="button" onclick="addPerson()" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
<script>
    function addPerson() {
        $.post("linkPerson",$("#personForm").serialize(),function (result) {
            if(result.flag){
                location.href="list_page.jsp?currentPage=1&pageSize=5";
            } else {
                location.href="list_page.jsp?currentPage=1&pageSize=5";
                alert("添加联系人失败");
            }
        },"json");
    }
</script>
</body>
</html>
