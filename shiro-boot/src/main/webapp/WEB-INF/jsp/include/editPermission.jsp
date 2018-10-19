

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

    <%@include file="menu.jsp" %>

    <div class="addOrEdit" >
        <form action="updatePermission" method="post">
            权限名称: <input type="text" name="resource_name" value="${permission.resource_name}"> <br>
            权限描述: <input type="text" name="desc_" value="${permission.desc_}"> <br>
            权限对应的url: <input type="text" name="resource_url"  value="${permission.resource_url}"> <br><br>
            <input type="hidden" name="resource_id" value="${permission.resource_id}">
            <input type="submit" value="修改">
        </form>
    </div>
</div>
</body>
</html>
