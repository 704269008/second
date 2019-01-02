<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="userVideoUpvote" id="current_nav">
<div id="userVideoUpvoteApp" ng-app="userVideoUpvoteApp">
	<div ng-controller="userVideoUpvoteController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserVideoUpvote管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserVideoUpvote(userVideoUpvote)">新增</span>
		    </span>
	
			<paging url="/web/a/userVideoUpvote">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户ID</td>
			        				                    <td>文章id</td>
			        				                    <td>点赞标识</td>
			        				                    <td>点赞时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userVideoUpvote in data">				
									                    <td ng-bind="userVideoUpvote.id" ></td>
			        				                    <td ng-bind="userVideoUpvote.userId" ></td>
			        				                    <td ng-bind="userVideoUpvote.articleId" ></td>
			        				                    <td ng-bind="userVideoUpvote.upvoteTag" ></td>
			        				                    <td ng-bind="userVideoUpvote.upvoteAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserVideoUpvote(userVideoUpvote.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserVideoUpvote(userVideoUpvote.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-home-service/userVideoUpvote/userVideoUpvoteList.js"></script>
