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
		<c:forEach items="${userList}" var="user">
			<json:object>
					
               
                    <json:property name="id" value="${user.id}"></json:property>
           
           
	   
        			
               

           
           
	   
        			
               
                    <json:property name="name" value="${user.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="grade" value="${user.grade}"></json:property>
           
           
	   
        			
               
                    <json:property name="beans" value="${user.beans}"></json:property>
           
           
	   
        			
               
                    <json:property name="phone" value="${user.phone}"></json:property>
           
           
	   
        			
               
                    <json:property name="email" value="${user.email}"></json:property>
           
           
	   
        			
               
                    <json:property name="area" value="${user.area}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${user.status}"></json:property>
           
           
	   
        			

           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


