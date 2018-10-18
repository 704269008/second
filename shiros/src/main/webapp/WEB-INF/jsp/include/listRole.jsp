


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
            <td>角色名称</td>
            <td>角色描述</td>
            <td>权限</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${rs}" var="r">
            <tr>
                <td>${r.role_id}</td>
                <td>${r.role_name}</td>
                <td>${r.desc_}</td>
                <td>
                    <c:forEach items="${role_permissions[r]}" var="p">
                        ${p.resource_name} <br>
                    </c:forEach>
                </td>

                <td><a href="editRole?id=${r.role_id}">编辑</a></td>
                <td><a href="deleteRole?id=${r.role_id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div class="addOrEdit" >
        <form action="addRole" method="post">
            角色名称: <input type="text" name="resource_name"> <br>
            角色描述: <input type="text" name="desc_"> <br><br>
            <input type="submit" value="增加">
        </form>
    </div>
</div>
</body>
</html>
