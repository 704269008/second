<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${userVideoCollect.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${userVideoCollect.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="articleId" value="${userVideoCollect.articleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="collectionTag" value="${userVideoCollect.collectionTag}"></json:property>
           
           
	   
                    			
               
                    <json:property name="collectAt" value="${userVideoCollect.collectAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


