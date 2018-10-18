

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <link rel="stylesheet" type="text/css" href="../../../static/css/style.css" />

</head>
<body>

<div class="workingroom">

    <%@include file="./menu.jsp" %>

    <table>
        <tr>
            <td>id</td>
            <td>权限名称</td>
            <td>权限描述</td>
            <td>权限对应的路径</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${ps}" var="p">
            <tr>
                <td>${p.resource_id}</td>
                <td>${p.resource_name}</td>
                <td>${p.desc_}</td>
                <td>${p.resource_url}</td>
                <td><a href="editPermission?id=${p.resource_id}">编辑</a></td>
                <td><a href="deletePermission?id=${p.resource_id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div class="addOrEdit" >
        <form action="addPermission" method="post">
            权限名称: <input type="text" name="resource_name"> <br>
            权限描述: <input type="text" name="desc_"> <br>
            权限对应的url: <input type="text" name="resource_url"> <br><br>
            <input type="submit" value="增加">
        </form>
    </div>
</div>
</body>
</html>
