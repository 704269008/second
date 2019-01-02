<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="userArticleCollect" id="current_nav">
	<div id="userArticleCollectDetailApp" ng-app="userArticleCollectDetailApp">
		<div ng-controller="userArticleCollectDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userArticleCollectForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userArticleCollectId" ng-model="userArticleCollect.id" ng-bind="userArticleCollect.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">用户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userArticleCollect.userId" ng-bind="userArticleCollect.userId" placeholder="请输入用户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="articleId" class="col-sm-2 control-label">文章id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="articleId" ng-model="userArticleCollect.articleId" ng-bind="userArticleCollect.articleId" placeholder="请输入文章id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="collectionTag" class="col-sm-2 control-label">收藏标识</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="collectionTag" ng-model="userArticleCollect.collectionTag" ng-bind="userArticleCollect.collectionTag" placeholder="请输入收藏标识" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="collectAt" class="col-sm-2 control-label">收藏时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="collectAt" ng-model="userArticleCollect.collectAt" ng-bind="userArticleCollect.collectAt" placeholder="请输入收藏时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserArticleCollect(userArticleCollect)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userArticleCollect">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-admin-service/userArticleCollect/userArticleCollectDetail.js"></script>
