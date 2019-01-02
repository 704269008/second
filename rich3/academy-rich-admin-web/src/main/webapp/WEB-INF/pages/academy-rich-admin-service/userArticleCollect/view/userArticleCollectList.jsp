<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="userArticleCollect" id="current_nav">
<div id="userArticleCollectApp" ng-app="userArticleCollectApp">
	<div ng-controller="userArticleCollectController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserArticleCollect管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserArticleCollect(userArticleCollect)">新增</span>
		    </span>
	
			<paging url="/web/a/userArticleCollect">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户ID</td>
			        				                    <td>文章id</td>
			        				                    <td>收藏标识</td>
			        				                    <td>收藏时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userArticleCollect in data">				
									                    <td ng-bind="userArticleCollect.id" ></td>
			        				                    <td ng-bind="userArticleCollect.userId" ></td>
			        				                    <td ng-bind="userArticleCollect.articleId" ></td>
			        				                    <td ng-bind="userArticleCollect.collectionTag" ></td>
			        				                    <td ng-bind="userArticleCollect.collectAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserArticleCollect(userArticleCollect.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserArticleCollect(userArticleCollect.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-admin-service/userArticleCollect/userArticleCollectList.js"></script>
