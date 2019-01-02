<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${user.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="openid" value="${user.openid}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${user.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="grade" value="${user.grade}"></json:property>
           
           
	   
                    			
               
                    <json:property name="avatar" value="${user.avatar}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${user.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="email" value="${user.email}"></json:property>
           
           
	   
                    			
               
                    <json:property name="area" value="${user.area}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${user.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${user.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${user.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${user.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${user.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


