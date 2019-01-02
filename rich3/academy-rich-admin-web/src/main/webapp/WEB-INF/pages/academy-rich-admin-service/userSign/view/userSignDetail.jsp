<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="userSign" id="current_nav">
	<div id="userSignDetailApp" ng-app="userSignDetailApp">
		<div ng-controller="userSignDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userSignForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userSignId" ng-model="userSign.id" ng-bind="userSign.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">用户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userSign.userId" ng-bind="userSign.userId" placeholder="请输入用户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="beans" class="col-sm-2 control-label">逆袭豆</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="beans" ng-model="userSign.beans" ng-bind="userSign.beans" placeholder="请输入逆袭豆" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="totalSign" class="col-sm-2 control-label">累计签到次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="totalSign" ng-model="userSign.totalSign" ng-bind="userSign.totalSign" placeholder="请输入累计签到次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="maxSign" class="col-sm-2 control-label">最高签到次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="maxSign" ng-model="userSign.maxSign" ng-bind="userSign.maxSign" placeholder="请输入最高签到次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="continuousSign" class="col-sm-2 control-label">连续签到次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="continuousSign" ng-model="userSign.continuousSign" ng-bind="userSign.continuousSign" placeholder="请输入连续签到次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="signSet" class="col-sm-2 control-label">当月签到状态,未签到为0、已签到为1，31位代表一个月31天</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="signSet" ng-model="userSign.signSet" ng-bind="userSign.signSet" placeholder="请输入当月签到状态,未签到为0、已签到为1，31位代表一个月31天" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="recordSign" class="col-sm-2 control-label">签到标识码，未签到为0，签到为1</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="recordSign" ng-model="userSign.recordSign" ng-bind="userSign.recordSign" placeholder="请输入签到标识码，未签到为0，签到为1" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="userSign.createBy" ng-bind="userSign.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="userSign.updateBy" ng-bind="userSign.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserSign(userSign)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userSign">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-admin-service/userSign/userSignDetail.js"></script>
