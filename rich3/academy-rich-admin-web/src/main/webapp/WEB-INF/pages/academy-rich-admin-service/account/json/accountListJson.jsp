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
		<c:forEach items="${accountList}" var="account">
			<json:object>
					
               
                    <json:property name="id" value="${account.id}"></json:property>



				<json:property name="roleName" value="${roleMap[account.roleId].name}"/>
				<json:property name="name" value="${account.name}"></json:property>
				<json:property name="createBy" value="${createBy[account.createBy]}"/>
				<json:property name="updateBy" value="${updateBy[account.updateBy]}"/>
				<json:property name="createAt" value="${account.createAt}"></json:property>
				<json:property name="updateAt" value="${account.updateAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


