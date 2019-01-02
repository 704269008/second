<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>
    <input type="hidden" value="article" id="current_nav">
	<div id="articleDetailApp" ng-app="articleDetailApp">
		<div ng-controller="articleDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="articleForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="articleId" ng-model="article.id" ng-bind="article.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="article.title" ng-bind="article.title" placeholder="请输入标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">文章类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="article.type" ng-bind="article.type" placeholder="请输入文章类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cover" class="col-sm-2 control-label">封面</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cover" ng-model="article.cover" ng-bind="article.cover" placeholder="请输入封面" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="writer" class="col-sm-2 control-label">作者</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="writer" ng-model="article.writer" ng-bind="article.writer" placeholder="请输入作者" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="summary" class="col-sm-2 control-label">作者简介</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="summary" ng-model="article.summary" ng-bind="article.summary" placeholder="请输入作者简介" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">正文内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="article.content" ng-bind="article.content" placeholder="请输入正文内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="collection" class="col-sm-2 control-label">收藏数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="collection" ng-model="article.collection" ng-bind="article.collection" placeholder="请输入收藏数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="upvote" class="col-sm-2 control-label">点赞数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="upvote" ng-model="article.upvote" ng-bind="article.upvote" placeholder="请输入点赞数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">文章状态，上架1，下架2</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="article.status" ng-bind="article.status" placeholder="请输入文章状态，上架1，下架2" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="article.createBy" ng-bind="article.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">修改人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="article.updateBy" ng-bind="article.updateBy" placeholder="请输入修改人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateArticle(article)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/article">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/academy-rich-home-service/article/articleDetail.js"></script>
