<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<sf:form action="${pageContext.request.contextPath }/add" method="post" modelAttribute="customer">
<table>
    <TR>
        <td>客户姓名：</td>
        <td>
            <INPUT name="name" value="${customer.name }">*<sf:errors path="name"></sf:errors>
        </td>
    </TR>
    <TR>
        <td>联系方式：</td>
        <td>
            <INPUT name="phone" value="${customer.phone }">*<sf:errors path="phone"></sf:errors>
        </td>
    </TR>

    <tr>
        <td rowspan=2>
            <INPUT class=button id=sButton2 type=submit value=" 添加 " name=sButton2>
        </td>
    </tr>

    </sf:form>
</table>
</body>
</html>
