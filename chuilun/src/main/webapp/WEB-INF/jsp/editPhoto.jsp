<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<%@ taglib uri="/tags" prefix="zhh"%>
<style>
    .to{width: 100px;height: 100px;border-radius: 100px}
</style>
<html>
<head>
    <title>editPhoto</title>
</head>
<body>
        <form method="post" action="/photos/${photo.id}">
            编号:     <input name="id" value="${photo.id}" type="text" > <br><br>
            图片:     <img id="pic" class="to" src="${photo.img}"> <br><br>
            图片名:   <input name="photoName" value="${photo.photoName}" type="text"> <br><br>
            图片类型: <input name="photoType" value="${photo.photoType}" type="text"> <br><br>
            上架时间:<zhh:date value="${photo.shelfTime}"/><br><br>
            <%--上架时间: <jsp:setProperty name="date" property="time" value="${photo.shelfTime}"/>--%>
           <%--<fmt:formatDate value="${date}" type="date" pattern="yyyy-MM-dd HH:mm:ss" /><br><br>--%>
            下架时间: <input name="downTime" value="${photo.downTime}" type="text"> <br><br>
            访客留言: <input name="guestbook" value="${photo.guestbook}" type="text"> <br><br>
            <input name="img" value="${photo.img}" type="hidden"> <br><br>
            <input name="shelfTime" value="${photo.shelfTime}" type="hidden"> <br><br>
            <input type="submit" value="保存">
        </form>
</body>
</html>
