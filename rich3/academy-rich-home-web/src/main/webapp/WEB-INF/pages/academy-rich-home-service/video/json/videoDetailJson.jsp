<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${video.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="title" value="${video.title}"></json:property>
           
           
	   
                    			
               
                    <json:property name="type" value="${video.type}"></json:property>
           
           
	   
                    			
               
                    <json:property name="img" value="${video.img}"></json:property>
           
           
	   
                    			
               
                    <json:property name="url" value="${video.url}"></json:property>
           
           
	   
                    			
               
                    <json:property name="grade" value="${video.grade}"></json:property>


                <json:property name="upvoteTag" value="${upvote}"></json:property>

                <json:property name="collectTag" value="${collect}"></json:property>



                <json:property name="subject" value="${video.subject}"></json:property>
           
           
	   
                    			
               
                    <json:property name="summary" value="${video.summary}"></json:property>
           
           
	   
                    			
               
                    <json:property name="content" value="${video.content}"></json:property>
           
           
	   
                    			
               
                    <json:property name="collection" value="${video.collection}"></json:property>
           
           
	   
                    			
               
                    <json:property name="upvote" value="${video.upvote}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${video.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${video.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${video.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${video.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${video.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


