<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${module.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${module.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="url" value="${module.url}"></json:property>
           
           
	   
                    			
               
                    <json:property name="parentId" value="${module.parentId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sort" value="${module.sort}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${module.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${module.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${module.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${module.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


