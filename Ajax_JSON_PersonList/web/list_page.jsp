<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/11/7
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
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
    <title>分页查看联系人</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/getParameter.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">显示所有联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <thead>
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
        </thead>
        <tbody>

        </tbody>
        <tfoot>
        <tr>
            <td id="total" colspan="8" align="center">

            </td>
        </tr>
        <tr>
            <td colspan="8" align="center">
                <ul class="pagination success">

                </ul>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<script>
    let currentPage = parseInt(getParameter("currentPage"));
    let pageSize = parseInt(getParameter("pageSize"));

    // 发送异步请求，给服务器端请求分页
    $.post("linkPerson","action=findPersonByPage&currentPage="+currentPage+"&pageSize="+pageSize,function (result) {
        if(result.flag){
            let personList = result.date.list;
            $.each(personList,function (index,person) {
                $("tbody").append($("\t\t<tr>\n" +
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
            $("tfoot").append($("        <tr>\n" +
                "            <td colspan=\"8\" align=\"center\"><a class=\"btn btn-primary\"\n" +
                "                                              href=\"add.jsp\">添加联系人</a></td>\n" +
                "        </tr>"));
            // 获取当前页数和每页条数
            let totalSize = result.date.totalSize;
            let totalPage = result.date.totalPage;
            // 展示总条数和总页数
            $("#total").html("总数据条数为"+totalSize+"条<br>\n" +
                "                每页显示"+pageSize+"条数据");
            if(currentPage >　1){
                $("ul").append($(" <li>\n" +
                    "                            <a href=\"list_page.jsp?currentPage="+(currentPage-1)+"&pageSize="+pageSize+"\" aria-label=\"Previous\">\n" +
                    "                            <span aria-hidden=\"true\">&laquo;</span>\n" +
                    "                            </a>\n" +
                    "                        </li>"));
            };
            for(var i=1; i<=totalPage; i++){
                // 判断是否是当前页
                if(currentPage == i){
                    $("ul").append($(" <li class=\"active\"><a href=\"#\">"+i+"</a></li>"));
                } else {
                    $("ul").append($(" <li><a href=\"list_page.jsp?currentPage="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>"));
                }
            }
            if(currentPage < totalPage){
                $("ul").append($(" <li>\n" +
                    "                            <a href=\"list_page.jsp?currentPage="+(currentPage+1)+"&pageSize="+pageSize+"\" aria-label=\"Previous\">\n" +
                    "                            <span aria-hidden=\"true\">&raquo;</span>\n" +
                    "                            </a>\n" +
                    "                        </li>"));
            }
        }
    },"json");

    // 确认是否删除
    function deleteLinkMan(name,id) {
        var flag = confirm("你确认要删除"+name+"吗？")
        if(flag){
            $.post("linkPerson","action=deletePerson&id="+id,function (result) {
                if(result.flag){
                    // 删除成功
                    location.href="list_page.jsp?currentPage=1&pageSize=5"
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

























