<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/23
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>arrayJson</title>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function(){
        $("#btnSendCode").click(function () {
            var data = [{'name':$("#name").val(),'password':$("#password").val()},{'name':'queen' ,'password':18},{'name':'king' ,'password':26}];
            var jsonString = JSON.stringify(data);
            $.ajax({
                type:"post",
                url:"/arrayData",
                dataType:"json",
                data:{"myArrayData":jsonString},
                success: function(data)
                {
                    $("#password").val(data[0].password);
                    $("#name").val(data[0].name);
                    alert("操作成功");
                }
            });
        })
    })
</script>

姓名：<input id="name"  type="text" name="name">
密码：<<input type="text"  id="password" name="password">
<input type="submit" value="提交" id="btnSendCode">
</body>
</html>
