<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${roleModuleList}" var="roleModule">
			<json:object>
					
               
                    <json:property name="id" value="${roleModule.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="roleId" value="${roleModule.roleId}"></json:property>
           
           
	   
        			
               
                    <json:property name="moduleId" value="${roleModule.moduleId}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


