<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>editManager</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="/managers/${manager.name}">
            姓名： <input name="name" value="${manager.name}" type="text"> <br><br>
            性别： <input name="sex" value="${manager.sex}" type="text"> <br><br>
            年龄： <input name="age" value="${manager.age}" type="text"> <br><br>
            电话： <input name="phone" value="${manager.phone}" type="text"> <br><br>
            住址： <input name="address" value="${manager.address}" type="text"> <br><br>
            具体介绍： <input name="personalDetails" value="${manager.personalDetails}" type="text"> <br><br>
            等级： <input name="level" value="${manager.level}" type="text"> <br><br>
            肖像：<input name="portrait" value="${manager.portrait}" type="text"> <br><br>
            <input type="submit" value="保存">
        </form>
    </div>
</div>
</body>
</html>
