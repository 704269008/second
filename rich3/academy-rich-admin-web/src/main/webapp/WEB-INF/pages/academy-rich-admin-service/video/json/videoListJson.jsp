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
		<c:forEach items="${videoList}" var="video">
			<json:object>
					
               
                    <json:property name="id" value="${video.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="title" value="${video.title}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${video.type}"></json:property>




				<json:property name="teacherId" value="${video.teacherId}"></json:property>
               
                    <json:property name="teacherName" value="${video.teacherName}"></json:property>
           
           
	   
        			
               
                    <json:property name="grade" value="${video.grade}"></json:property>
           
           
	   
        			
               
                    <json:property name="subject" value="${video.subject}"></json:property>

           
	   
        			
               
                    <json:property name="collection" value="${video.collection}"></json:property>
           
           
	   
        			
               
                    <json:property name="upvote" value="${video.upvote}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${video.status}"></json:property>
           





                    <json:property name="updateAt" value="${video.updateAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


