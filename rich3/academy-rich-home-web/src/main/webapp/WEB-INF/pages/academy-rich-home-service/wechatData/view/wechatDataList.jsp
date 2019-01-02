<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="wechatData" id="current_nav">
<div id="wechatDataApp" ng-app="wechatDataApp">
	<div ng-controller="wechatDataController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>WechatData管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addWechatData(wechatData)">新增</span>
		    </span>
	
			<paging url="/web/a/wechatData">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>老师ID主键自增</td>
			        				                    <td>老师名</td>
			        				                    <td>微信授权token</td>
			        				                    <td>邮件激活码</td>
			        				                    <td>手机激活码</td>
			        				                    <td>邮件当天激活次数</td>
			        				                    <td>手机当天激活次数</td>
			        				                    <td>创建者</td>
			        				                    <td>更新者</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="wechatData in data">				
									                    <td ng-bind="wechatData.id" ></td>
			        				                    <td ng-bind="wechatData.openId" ></td>
			        				                    <td ng-bind="wechatData.accessToken" ></td>
			        				                    <td ng-bind="wechatData.emailCode" ></td>
			        				                    <td ng-bind="wechatData.phoneCode" ></td>
			        				                    <td ng-bind="wechatData.emailCodeTimes" ></td>
			        				                    <td ng-bind="wechatData.phoneCodeTimes" ></td>
			        				                    <td ng-bind="wechatData.createBy" ></td>
			        				                    <td ng-bind="wechatData.updateBy" ></td>
			        				                    <td ng-bind="wechatData.createAt" ></td>
			        				                    <td ng-bind="wechatData.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateWechatData(wechatData.id)" /> 
							<input type="button" value="删除" ng-click="deleteWechatData(wechatData.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-home-service/wechatData/wechatDataList.js"></script>
