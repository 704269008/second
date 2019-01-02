<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="account" id="current_nav">
<div id="accountApp" ng-app="accountApp">
	<div ng-controller="accountController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Account管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAccount(account)">新增</span>
		    </span>
	
			<paging url="/web/a/account">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>账户ID主键自增</td>
			        				                    <td>角色id</td>
			        				                    <td>登录名</td>
			        				                    <td>密码</td>
			        				                    <td>盐值</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="account in data">				
									                    <td ng-bind="account.id" ></td>
			        				                    <td ng-bind="account.roleId" ></td>
			        				                    <td ng-bind="account.name" ></td>
			        				                    <td ng-bind="account.password" ></td>
			        				                    <td ng-bind="account.salt" ></td>
			        				                    <td ng-bind="account.createBy" ></td>
			        				                    <td ng-bind="account.updateBy" ></td>
			        				                    <td ng-bind="account.createAt" ></td>
			        				                    <td ng-bind="account.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAccount(account.id)" /> 
							<input type="button" value="删除" ng-click="deleteAccount(account.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-admin-service/account/accountList.js"></script>
