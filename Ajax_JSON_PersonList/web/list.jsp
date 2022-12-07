<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/11/5
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <%--导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td,th{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">显示所有联系人</h3>
        <table id="tabId" border="1" class="table table-bordered table-hover">
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
        </table>
    </div>
    <script>
        $.post("linkPerson","action=findAllPerson",function (result) {
            // 获取服务器响应过来的数据，判断flag结果是否为true
            console.log(result.flag);
            if(result.flag){
                let personList = result.date;
                console.log(personList);
                $.each(personList,function (index,person) {
                    $("#tabId").append($("\t\t<tr>\n" +
                        "\t\t\t<td>"+(index+1)+"</td>\n" +
                        "\t\t\t<td>"+person.name+"</td>\n" +
                        "\t\t\t<td>"+person.sex+"</td>\n" +
                        "\t\t\t<td>"+person.age+"</td>\n" +
                        "\t\t\t<td>"+person.address+"</td>\n" +
                        "\t\t\t<td>"+person.qq+"</td>\n" +
                        "\t\t\t<td>"+person.email+"</td>\n" +
                        "\n" +
                        "\t\t\t<td>\n" +
                        "\t\t\t\t<a class=\"btn btn-default btn-sm\" href=\"update.jsp?id="+person.id+"\">修改</a>&nbsp;\n" +
                        "\n" +
                        "\t\t\t\t<a class=\"btn btn-default btn-sm\" href=\"javascript:;\" onclick=\"deleteLinkMan('"+person.name+"','"+person.id+"')\">删除</a>\n" +
                        "\t\t\t</td>\n" +
                        "\t\t</tr>"));
                });
                $("#tabId").append($("        <tr>\n" +
                    "            <td colspan=\"8\" align=\"center\"><a class=\"btn btn-primary\"\n" +
                    "                                              href=\"add.jsp\">添加联系人</a></td>\n" +
                    "        </tr>"));
            }
        },"json");

        // 确认是否删除
        function deleteLinkMan(name,id) {
            var flag = confirm("你确认要删除"+name+"吗？")
            if(flag){
                $.post("linkPerson","action=deletePerson&id="+id,function (result) {
                    if(result.flag){
                        // 删除成功
                        location.href="list.jsp"
                    } else {
                        // 删除失败
                        alert("删除失败");
                    }
                },"json");
            }
        }
    </script>
</body>
</html>
