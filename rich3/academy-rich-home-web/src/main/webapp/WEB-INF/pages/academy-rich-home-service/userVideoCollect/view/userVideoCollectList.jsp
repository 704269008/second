<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="userVideoCollect" id="current_nav">
<div id="userVideoCollectApp" ng-app="userVideoCollectApp">
	<div ng-controller="userVideoCollectController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserVideoCollect管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserVideoCollect(userVideoCollect)">新增</span>
		    </span>
	
			<paging url="/web/a/userVideoCollect">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户ID</td>
			        				                    <td>文章id</td>
			        				                    <td>收藏标识</td>
			        				                    <td>收藏时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userVideoCollect in data">				
									                    <td ng-bind="userVideoCollect.id" ></td>
			        				                    <td ng-bind="userVideoCollect.userId" ></td>
			        				                    <td ng-bind="userVideoCollect.articleId" ></td>
			        				                    <td ng-bind="userVideoCollect.collectionTag" ></td>
			        				                    <td ng-bind="userVideoCollect.collectAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserVideoCollect(userVideoCollect.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserVideoCollect(userVideoCollect.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-home-service/userVideoCollect/userVideoCollectList.js"></script>
