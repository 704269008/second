<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${articleList}" var="article">
            <json:object>
                <json:property name="id" value="${article.id}"></json:property>

                <json:property name="title" value="${article.title}"></json:property>

                <json:property name="type" value="${article.type}"></json:property>

                <json:property name="cover" value="${article.cover}"></json:property>

                <json:property name="summary" value="${article.summary}"></json:property>

                <json:property name="content" value="${article.content}"></json:property>

            </json:object>
        </c:forEach>
    </json:array>
</json:object>


