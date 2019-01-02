<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="wechatData" id="current_nav">
	<div id="wechatDataDetailApp" ng-app="wechatDataDetailApp">
		<div ng-controller="wechatDataDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="wechatDataForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="wechatDataId" ng-model="wechatData.id" ng-bind="wechatData.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="openId" class="col-sm-2 control-label">老师名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="openId" ng-model="wechatData.openId" ng-bind="wechatData.openId" placeholder="请输入老师名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="accessToken" class="col-sm-2 control-label">微信授权token</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="accessToken" ng-model="wechatData.accessToken" ng-bind="wechatData.accessToken" placeholder="请输入微信授权token" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="emailCode" class="col-sm-2 control-label">邮件激活码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="emailCode" ng-model="wechatData.emailCode" ng-bind="wechatData.emailCode" placeholder="请输入邮件激活码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phoneCode" class="col-sm-2 control-label">手机激活码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phoneCode" ng-model="wechatData.phoneCode" ng-bind="wechatData.phoneCode" placeholder="请输入手机激活码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="emailCodeTimes" class="col-sm-2 control-label">邮件当天激活次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="emailCodeTimes" ng-model="wechatData.emailCodeTimes" ng-bind="wechatData.emailCodeTimes" placeholder="请输入邮件当天激活次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phoneCodeTimes" class="col-sm-2 control-label">手机当天激活次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phoneCodeTimes" ng-model="wechatData.phoneCodeTimes" ng-bind="wechatData.phoneCodeTimes" placeholder="请输入手机当天激活次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="wechatData.createBy" ng-bind="wechatData.createBy" placeholder="请输入创建者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="wechatData.updateBy" ng-bind="wechatData.updateBy" placeholder="请输入更新者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateWechatData(wechatData)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/wechatData">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-home-service/wechatData/wechatDataDetail.js"></script>
