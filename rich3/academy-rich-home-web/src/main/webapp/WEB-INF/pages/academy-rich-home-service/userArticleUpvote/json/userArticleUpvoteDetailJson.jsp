<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${userArticleUpvote.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${userArticleUpvote.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="articleId" value="${userArticleUpvote.articleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="upvoteTag" value="${userArticleUpvote.upvoteTag}"></json:property>
           
           
	   
                    			
               
                    <json:property name="upvoteAt" value="${userArticleUpvote.upvoteAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


