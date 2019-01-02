<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="user" id="current_nav">
	<div id="userDetailApp" ng-app="userDetailApp">
		<div ng-controller="userDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userId" ng-model="user.id" ng-bind="user.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="openid" class="col-sm-2 control-label">微信用户唯一标识</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="openid" ng-model="user.openid" ng-bind="user.openid" placeholder="请输入微信用户唯一标识" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">用户昵称，限制范围1-14</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="user.name" ng-bind="user.name" placeholder="请输入用户昵称，限制范围1-14" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="grade" class="col-sm-2 control-label">初一到高三用数字1-6表示</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="grade" ng-model="user.grade" ng-bind="user.grade" placeholder="请输入初一到高三用数字1-6表示" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="avatar" class="col-sm-2 control-label">头像</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="avatar" ng-model="user.avatar" ng-bind="user.avatar" placeholder="请输入头像" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="user.phone" ng-bind="user.phone" placeholder="请输入手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="email" class="col-sm-2 control-label">邮箱</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="email" ng-model="user.email" ng-bind="user.email" placeholder="请输入邮箱" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="area" class="col-sm-2 control-label">所在区域</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="area" ng-model="user.area" ng-bind="user.area" placeholder="请输入所在区域" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">账号状态，正常为1，冻结为2</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="user.status" ng-bind="user.status" placeholder="请输入账号状态，正常为1，冻结为2" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="user.createBy" ng-bind="user.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="user.updateBy" ng-bind="user.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUser(user)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/user">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-home-service/user/userDetail.js"></script>
