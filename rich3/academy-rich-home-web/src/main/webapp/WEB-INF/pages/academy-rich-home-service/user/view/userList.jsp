<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="user" id="current_nav">
<div id="userApp" ng-app="userApp">
	<div ng-controller="userController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>User管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUser(user)">新增</span>
		    </span>
	
			<paging url="/web/a/user">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>用户ID主键自增</td>
			        				                    <td>微信用户唯一标识</td>
			        				                    <td>用户昵称，限制范围1-14</td>
			        				                    <td>初一到高三用数字1-6表示</td>
			        				                    <td>头像</td>
			        				                    <td>手机号</td>
			        				                    <td>邮箱</td>
			        				                    <td>所在区域</td>
			        				                    <td>账号状态，正常为1，冻结为2</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="user in data">				
									                    <td ng-bind="user.id" ></td>
			        				                    <td ng-bind="user.openid" ></td>
			        				                    <td ng-bind="user.name" ></td>
			        				                    <td ng-bind="user.grade" ></td>
			        				                    <td ng-bind="user.avatar" ></td>
			        				                    <td ng-bind="user.phone" ></td>
			        				                    <td ng-bind="user.email" ></td>
			        				                    <td ng-bind="user.area" ></td>
			        				                    <td ng-bind="user.status" ></td>
			        				                    <td ng-bind="user.createBy" ></td>
			        				                    <td ng-bind="user.updateBy" ></td>
			        				                    <td ng-bind="user.createAt" ></td>
			        				                    <td ng-bind="user.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUser(user.id)" /> 
							<input type="button" value="删除" ng-click="deleteUser(user.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-home-service/user/userList.js"></script>
