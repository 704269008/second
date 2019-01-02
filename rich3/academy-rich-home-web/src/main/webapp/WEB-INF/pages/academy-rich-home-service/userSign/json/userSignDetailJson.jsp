<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>

    <json:object name="data">



        <json:property name="id" value="${userSign.id}"></json:property>





        <json:property name="userId" value="${userSign.userId}"></json:property>





        <json:property name="name" value="${user.name}"></json:property>





        <json:property name="avatar" value="${user.avatar}"></json:property>





        <json:property name="beans" value="${userSign.beans}"></json:property>





        <json:property name="totalSign" value="${userSign.totalSign}"></json:property>





        <json:property name="maxSign" value="${userSign.maxSign}"></json:property>





        <json:property name="continuousSign" value="${userSign.continuousSign}"></json:property>





        <json:property name="signSet" value="${userSign.signSet}"></json:property>





        <json:property name="recordSign" value="${userSign.recordSign}"></json:property>





        <json:property name="createBy" value="${userSign.createBy}"></json:property>





        <json:property name="updateBy" value="${userSign.updateBy}"></json:property>





        <json:property name="createAt" value="${userSign.createAt}"></json:property>





        <json:property name="updateAt" value="${userSign.updateAt}"></json:property>





    </json:object>

</json:object>