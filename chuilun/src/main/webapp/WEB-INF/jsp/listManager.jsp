<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formDelete").attr("action",href).submit();
            return false;
        });
    });
</script>

<form id="formDelete" action="" method="POST" >
    <input type="hidden" name="_method" value="DELETE">
</form>
<html>
<body>
<div>
    <table align='center'  border='1'  cellspacing='0'>
        <tr>
            <td>头像</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>电话</td>
            <td>地址</td>
            <td>详细介绍</td>
        </tr>
        <c:forEach items="${manager}" var="m" varStatus="st">
            <tr>
                <td>${m.portrait}</td>
                <td>${m.name}</td>
                <td>${m.sex}</td>
                <td>${m.age}</td>
                <td>${m.phone}</td>
                <td>${m.address}</td>
                <td>${m.personalDetails}</td>
                <td><a href="/managers/${m.name}">编辑</a></td>
                <td><a class="delete" href="/managers/${m.name}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
        <div style="text-align:center;margin-top:40px">
            <form method="post" action="/managers">
                <input type="hidden" name="_method"  value="PUT">
                姓名： <input name="name"  type="text"> <br><br>
                性别： <input name="sex"  type="text"> <br><br>
                年龄： <input name="age"  type="text"> <br><br>
                电话： <input name="phone"  type="text"> <br><br>
                住址： <input name="address"  type="text"> <br><br>
                具体介绍： <input name="personalDetails"  type="text"> <br><br>
                等级： <input name="level" type="text"> <br><br>
                肖像：<input name="portrait"  type="text"> <br><br>
                <input type="submit" value="保存">
            </form>
        </div>
</div>
</body>
</html>
