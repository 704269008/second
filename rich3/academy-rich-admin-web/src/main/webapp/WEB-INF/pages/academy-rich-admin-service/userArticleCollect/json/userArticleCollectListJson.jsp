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
		<c:forEach items="${userArticleCollectList}" var="userArticleCollect">
			<json:object>
					
               
                    <json:property name="id" value="${userArticleCollect.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="userId" value="${userArticleCollect.userId}"></json:property>
           
           
	   
        			
               
                    <json:property name="articleId" value="${userArticleCollect.articleId}"></json:property>
           
           
	   
        			
               
                    <json:property name="collectionTag" value="${userArticleCollect.collectionTag}"></json:property>
           
           
	   
        			
               
                    <json:property name="collectAt" value="${userArticleCollect.collectAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


