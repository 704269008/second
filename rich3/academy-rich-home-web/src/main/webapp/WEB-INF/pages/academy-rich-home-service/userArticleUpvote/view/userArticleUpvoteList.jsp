<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="userArticleUpvote" id="current_nav">
<div id="userArticleUpvoteApp" ng-app="userArticleUpvoteApp">
	<div ng-controller="userArticleUpvoteController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserArticleUpvote管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserArticleUpvote(userArticleUpvote)">新增</span>
		    </span>
	
			<paging url="/web/a/userArticleUpvote">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户ID</td>
			        				                    <td>文章id</td>
			        				                    <td>点赞标识</td>
			        				                    <td>点赞时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userArticleUpvote in data">				
									                    <td ng-bind="userArticleUpvote.id" ></td>
			        				                    <td ng-bind="userArticleUpvote.userId" ></td>
			        				                    <td ng-bind="userArticleUpvote.articleId" ></td>
			        				                    <td ng-bind="userArticleUpvote.upvoteTag" ></td>
			        				                    <td ng-bind="userArticleUpvote.upvoteAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserArticleUpvote(userArticleUpvote.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserArticleUpvote(userArticleUpvote.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-home-service/userArticleUpvote/userArticleUpvoteList.js"></script>
