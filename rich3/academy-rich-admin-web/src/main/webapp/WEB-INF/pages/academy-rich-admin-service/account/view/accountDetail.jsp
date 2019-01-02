<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="account" id="current_nav">
	<div id="accountDetailApp" ng-app="accountDetailApp">
		<div ng-controller="accountDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="accountForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="accountId" ng-model="account.id" ng-bind="account.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="roleId" class="col-sm-2 control-label">角色id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="roleId" ng-model="account.roleId" ng-bind="account.roleId" placeholder="请输入角色id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">登录名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="account.name" ng-bind="account.name" placeholder="请输入登录名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="password" class="col-sm-2 control-label">密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="password" ng-model="account.password" ng-bind="account.password" placeholder="请输入密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="salt" class="col-sm-2 control-label">盐值</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="salt" ng-model="account.salt" ng-bind="account.salt" placeholder="请输入盐值" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="account.createBy" ng-bind="account.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="account.updateBy" ng-bind="account.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateAccount(account)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/account">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-admin-service/account/accountDetail.js"></script>
