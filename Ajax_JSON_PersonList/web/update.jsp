<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改联系人</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getParameter.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="linkPerson" method="post" onsubmit="return false" id="personForm">

        <%--通过隐藏域携带action参数值，以及用户的id--%>
        <input type="hidden" name="action" value="updatePerson">
        <input type="hidden" name="id" id="id">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name"
                   name="name" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别:</label>
            <input id="boy" type="radio" name="sex" value="男" checked/>男
            <input id="girl" type="radio" name="sex" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
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
            <input type="text" id="qq" class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="button" value="提交" onclick="updatePerson()"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
<script>
    let id = getParameter("id");
    $.post("linkPerson","action=findPerson&id="+id,function (result) {
        console.log(id)
        if(result.flag){
            let person = result.date;
            // 对象数据回显
            $("#name").val(person.name);
            if(person.sex=="男"){
                $("#boy").prop("checked",true);
            } else {
                $("#girl").prop("checked",true);
            };
            $("#age").val(person.age);
            $("#address").val(person.address);
            $("#qq").val(person.qq);
            $("#email").val(person.email);
            $("#id").val(person.id);
        }
    },"json");
    function updatePerson() {
        // 发送异步请求
        $.post("linkPerson",$("#personForm").serialize(),function (result) {
            if(result.flag){
                location.href="list_page.jsp?currentPage=1&pageSize=5";
            } else {
                alert("修改失败")
            }
        },"json")
    }
</script>
</body>
</html>
