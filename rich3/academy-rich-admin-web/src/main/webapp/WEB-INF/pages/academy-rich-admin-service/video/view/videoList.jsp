<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../includes/includes.jsp"%>

<input type="hidden" value="video" id="current_nav">
<div id="videoApp" ng-app="videoApp">
	<div ng-controller="videoController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Video管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addVideo(video)">新增</span>
		    </span>
	
			<paging url="/web/a/video">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>视频id</td>
			        				                    <td>标题</td>
			        				                    <td>视频类型</td>
			        				                    <td>视频图片</td>
			        				                    <td>视频链接</td>
			        				                    <td>年级</td>
			        				                    <td>科目</td>
			        				                    <td>视频简介：限制140个字</td>
			        				                    <td>正文内容</td>
			        				                    <td>收藏数</td>
			        				                    <td>点赞数</td>
			        				                    <td>视频状态，上架1，下架2</td>
			        				                    <td>创建人</td>
			        				                    <td>修改人</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="video in data">				
									                    <td ng-bind="video.id" ></td>
			        				                    <td ng-bind="video.title" ></td>
			        				                    <td ng-bind="video.type" ></td>
			        				                    <td ng-bind="video.img" ></td>
			        				                    <td ng-bind="video.url" ></td>
			        				                    <td ng-bind="video.grade" ></td>
			        				                    <td ng-bind="video.subject" ></td>
			        				                    <td ng-bind="video.summary" ></td>
			        				                    <td ng-bind="video.content" ></td>
			        				                    <td ng-bind="video.collection" ></td>
			        				                    <td ng-bind="video.upvote" ></td>
			        				                    <td ng-bind="video.status" ></td>
			        				                    <td ng-bind="video.createBy" ></td>
			        				                    <td ng-bind="video.updateBy" ></td>
			        				                    <td ng-bind="video.createAt" ></td>
			        				                    <td ng-bind="video.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateVideo(video.id)" /> 
							<input type="button" value="删除" ng-click="deleteVideo(video.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/academy-rich-admin-service/video/videoList.js"></script>
