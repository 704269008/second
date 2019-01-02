<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>
    <json:property name="openedId" value="${openedId}"></json:property>
    <json:property name="userId" value="${userId}"></json:property>
    <json:property name="name" value="${name}"></json:property>
</json:object>


