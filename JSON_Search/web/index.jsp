<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/11/4
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<div align="center">
    <h1>寇哲搜索</h1>
    <div style="color: red" id="msg"></div>
    <input id="inputId" type="text" style="width: 500px;height: 40px" onkeyup="searchWords(this.value)"/>
    <input type="button" value="搜搜一下" style="height: 40px" onkeyup="searchWords(this.value)">
    <div id="divId"  style="width: 500px;height: 300px;border: 1px red solid;position: absolute;left:640px;display: none">
        <table id="tabID" width="100%" height="100%" border="1"></table>
    </div>
</div>

<script>
    function searchWords(keyword) {
        if (keyword != null && keyword != "") {
            $("#divId").show();
            $.post("WordsServlet", "action=search&keyword=" + keyword, function (result) {
                if (result.flag) {
                    let data = result.data;
                    $("#tabID").empty();
                    $.each(data, function (index, element) {
                        let word = element.word;
                        $("#tabID").append($("<tr><td>" + word + "</td></tr>"));
                    });
                } else {
                    $("#msg").html("查询失败")
                }
            }, "json");
        } else {
            $("#divId").hide();
        }
    }
</script>
</body>
</html>
