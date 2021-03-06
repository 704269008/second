<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="userArticleUpvote" id="current_nav">
	<div id="userArticleUpvoteDetailApp" ng-app="userArticleUpvoteDetailApp">
		<div ng-controller="userArticleUpvoteDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userArticleUpvoteForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userArticleUpvoteId" ng-model="userArticleUpvote.id" ng-bind="userArticleUpvote.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">用户ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userArticleUpvote.userId" ng-bind="userArticleUpvote.userId" placeholder="请输入用户ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="articleId" class="col-sm-2 control-label">文章id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="articleId" ng-model="userArticleUpvote.articleId" ng-bind="userArticleUpvote.articleId" placeholder="请输入文章id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="upvoteTag" class="col-sm-2 control-label">点赞标识</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="upvoteTag" ng-model="userArticleUpvote.upvoteTag" ng-bind="userArticleUpvote.upvoteTag" placeholder="请输入点赞标识" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="upvoteAt" class="col-sm-2 control-label">点赞时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="upvoteAt" ng-model="userArticleUpvote.upvoteAt" ng-bind="userArticleUpvote.upvoteAt" placeholder="请输入点赞时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserArticleUpvote(userArticleUpvote)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userArticleUpvote">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-home-service/userArticleUpvote/userArticleUpvoteDetail.js"></script>
