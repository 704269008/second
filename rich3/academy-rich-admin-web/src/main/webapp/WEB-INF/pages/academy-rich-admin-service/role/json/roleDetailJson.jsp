<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">

                    <json:property name="id" value="${role.id}"></json:property>

                    <json:property name="name" value="${role.name}"></json:property>
           

                    <json:property name="createBy" value="${role.createBy}"></json:property>

                    <json:property name="updateBy" value="${role.updateBy}"></json:property>

	 
			</json:object>

    <json:array name="moduleList">
        <c:forEach items="${moduleList}" var="module">
            <json:property name="id" value="${module.id}"/>
            <json:property name="parentId" value="${module.parentId}"/>
            <json:property name="name" value="${module.name}"/>
        </c:forEach>
    </json:array>
		
</json:object>


