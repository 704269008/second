<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>

    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>
    <json:property name="name" value="${subject.principal}"></json:property>
   <json:object name="role">
       <json:property name="id" value="${role.id}"/>
       <json:property name="name" value="${role.name}"/>
   </json:object>
    <json:object name="account">
        <json:property name="id" value="${account.id}"/>
        <json:property name="name" value="${account.name}"/>
    </json:object>
    <json:array name="data">
        <c:forEach items="${moduleList}" var="module">
            <json:object>

                <json:property name="id" value="${module.id}"></json:property>




                <json:property name="name" value="${module.name}"></json:property>


                <json:property name="parentId" value="${module.parentId}"></json:property>
                <json:property name="sort" value="${module.sort}"></json:property>


            </json:object>
        </c:forEach>
    </json:array>
</json:object>