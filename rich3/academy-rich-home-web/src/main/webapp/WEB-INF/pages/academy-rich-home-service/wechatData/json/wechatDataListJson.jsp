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
		<c:forEach items="${wechatDataList}" var="wechatData">
			<json:object>
					
               
                    <json:property name="id" value="${wechatData.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="openId" value="${wechatData.openId}"></json:property>
           
           
	   
        			
               
                    <json:property name="accessToken" value="${wechatData.accessToken}"></json:property>
           
           
	   
        			
               
                    <json:property name="emailCode" value="${wechatData.emailCode}"></json:property>
           
           
	   
        			
               
                    <json:property name="phoneCode" value="${wechatData.phoneCode}"></json:property>
           
           
	   
        			
               
                    <json:property name="emailCodeTimes" value="${wechatData.emailCodeTimes}"></json:property>
           
           
	   
        			
               
                    <json:property name="phoneCodeTimes" value="${wechatData.phoneCodeTimes}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${wechatData.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${wechatData.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${wechatData.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${wechatData.updateAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


