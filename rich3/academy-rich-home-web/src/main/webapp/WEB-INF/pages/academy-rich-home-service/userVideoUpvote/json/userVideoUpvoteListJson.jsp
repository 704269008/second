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
		<c:forEach items="${userVideoUpvoteList}" var="userVideoUpvote">
			<json:object>
					
               
                    <json:property name="id" value="${userVideoUpvote.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="userId" value="${userVideoUpvote.userId}"></json:property>
           
           
	   
        			
               
                    <json:property name="articleId" value="${userVideoUpvote.articleId}"></json:property>
           
           
	   
        			
               
                    <json:property name="upvoteTag" value="${userVideoUpvote.upvoteTag}"></json:property>
           
           
	   
        			
               
                    <json:property name="upvoteAt" value="${userVideoUpvote.upvoteAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


