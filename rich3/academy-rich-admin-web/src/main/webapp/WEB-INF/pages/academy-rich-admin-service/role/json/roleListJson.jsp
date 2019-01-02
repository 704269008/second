<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="page" value="${page}"></json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${roleList}" var="role">
			<json:object>
					
               
                    <json:property name="id" value="${role.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${role.name}"></json:property>





				<json:property name="createBy" value="${createBy[role.createBy]}"/>
				<json:property name="updateBy" value="${updateBy[role.updateBy]}"/>
           
           
	   
        			
               
                    <json:property name="createAt" value="${role.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${role.updateAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


