<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<%@taglib uri="/tags" prefix="zhh"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".delete").click(function () {
            var href=$(this).attr("href");
            $("#formDelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<style>
    .to{width: 100px;height: 100px;border-radius: 100px}
</style>
<form id="formDelete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<html>
<body>
<div>
    <table align='center'  border='1'  cellspacing='0'>
        <tr>
            <td>编号</td>
            <td>图片</td>
            <td>图片名</td>
            <td>图片类型</td>
            <td>上架时间</td>
            <td>下架时间</td>
            <td>访客留言</td>
        </tr>
        <c:forEach items="${page.list}" var="p" varStatus="st">
            <tr>
                <td>${p.id}</td>
                <td><img id="pic" class="to" src="${p.img}"></td>
                <td>${p.photoName}</td>
                <td>${p.photoType}</td>
                <td>
                <jsp:setProperty name="date" property="time" value="${p.shelfTime}"/>
                <fmt:formatDate value="${date}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
                <td>${p.downTime}</td>
                    <%--<td>--%>
                    <%--<jsp:setProperty name="date" property="time" value="${p.downTime}"/>--%>
                    <%--<fmt:formatDate value="${date}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />--%>
                    <%--</td>--%>
                <td>${p.guestbook}</td>
                <td><a href="/photos/${p.id}">编辑</a></td>
                <td><a class="delete" href="photos/${p.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <span>第${page.currPage}页</span>&nbsp;&nbsp;
        <span>总记录数:${page.totalCount}</span>&nbsp;&nbsp;
        <span>
				<c:if test="${page.currPage!=1}">
                    <a href="/photos?currPage=1">首页</a>&nbsp;&nbsp;
                    <a href="/photos?currPage=${page.currPage-1}">上一页</a>&nbsp;&nbsp;
                </c:if>
				<c:if test="${page.currPage!=page.totalPage}">
                    <a href="/photos?currPage=${page.currPage+1}">下一页</a>&nbsp;&nbsp;
                    <a href="/photos?currPage=${page.totalPage}">尾页</a>&nbsp;&nbsp;
                </c:if>
			</span>
    </div>
</div>

<div style="text-align:center;margin-top:40px">
    <form method="post" action="/photos">
        <input type="hidden" name="_method"  value="PUT">
        图片： <input name="img"  type="text"> <br><br>
        图片名： <input name="photoName"  type="text"> <br><br>
        图片类型： <input name="photoType"  type="text"> <br><br>
        访客留言： <input name="guestbook"  type="text"> <br><br>
        <input name="shelfTime"  type="hidden" value="<%=new Date().getTime()%>" > <br><br>
        <input name="downTime"  type="hidden" value="1"> <br><br>
        <input type="submit" value="保存">
    </form>
</div>
</body>
</html>
