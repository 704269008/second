<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="userVideoCollect" id="current_nav">
	<div id="userVideoCollectDetailApp" ng-app="userVideoCollectDetailApp">
		<div ng-controller="userVideoCollectDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userVideoCollectForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userVideoCollectId" ng-model="userVideoCollect.id" ng-bind="userVideoCollect.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">用户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userVideoCollect.userId" ng-bind="userVideoCollect.userId" placeholder="请输入用户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="articleId" class="col-sm-2 control-label">文章id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="articleId" ng-model="userVideoCollect.articleId" ng-bind="userVideoCollect.articleId" placeholder="请输入文章id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="collectionTag" class="col-sm-2 control-label">收藏标识</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="collectionTag" ng-model="userVideoCollect.collectionTag" ng-bind="userVideoCollect.collectionTag" placeholder="请输入收藏标识" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="collectAt" class="col-sm-2 control-label">收藏时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="collectAt" ng-model="userVideoCollect.collectAt" ng-bind="userVideoCollect.collectAt" placeholder="请输入收藏时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserVideoCollect(userVideoCollect)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userVideoCollect">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-admin-service/userVideoCollect/userVideoCollectDetail.js"></script>
