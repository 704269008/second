package com.ptteng.academy.rich.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Teacher;
import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.TeacherService;
import com.ptteng.academy.rich.service.UserVideoCollectService;
import com.ptteng.academy.rich.service.UserVideoUpvoteService;
import com.ptteng.academy.rich.service.VideoService;
import com.ptteng.academy.rich.util.DynamicSqlUtil;
import com.ptteng.academy.rich.util.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    前台获取视频列表
* @Author:         zhh
* @CreateDate:     2018/11/26 17:35
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 17:35
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class VideoController {
	private static final Log log = LogFactory.getLog(VideoController.class);

	@Autowired
	private VideoService videoService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private UserVideoUpvoteService userVideoUpvoteService;

	@Autowired
	private UserVideoCollectService userVideoCollectService;



	/**
	* @Description:    动态查询，获取视频信息
	* @Author:         zhh
	* @CreateDate:     2018/11/26 17:36
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 17:36
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/video/list", method = RequestMethod.GET)
	public String getVideoList(ModelMap model,Integer pageNow, Integer pageSize, Integer grade, Integer subject)
			throws Exception {

		Map<String,Integer> ps = PageUtil.checkPageAndSize(pageNow,pageSize);
		pageNow = ps.get("page");
		pageSize = ps.get("size");
		int start = ps.get("start");
		Map<Long, Teacher> teacherMap = new HashMap<>();
		List<Long> teacherIds = new ArrayList<>();
		List<Teacher> teacherList;
		try {
			Map<String,Object> map = DynamicSqlUtil.videoDynamicSql(subject,grade);
			List<Long> videoIds = videoService.getIdsByDynamicCondition(Video.class,map,0,Integer.MAX_VALUE);
			List<Video> videos=videoService.getObjectsByIds(videoIds);

			List<Long> ids = videoService.getIdsByDynamicCondition(Video.class,map,start,pageSize);
			List<Video> videoList=videoService.getObjectsByIds(ids);

			for(Video video : videoList){
				teacherIds.add(video.getTeacherId());
			}
			//获取对应的老师信息
			teacherList = teacherService.getObjectsByIds(teacherIds);
			for(Teacher teacher:teacherList){
				teacherMap.put(teacher.getId(),teacher);
			}


			model.addAttribute("size",pageSize);
			model.addAttribute("page",pageNow);

			model.addAttribute("code", 0);
			model.addAttribute("total",videos.size());
			model.addAttribute("teacherMap",teacherMap);

			model.addAttribute("videoList", videoList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get video error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/video/json/videoListJson";
	}




	/**
	* @Description:    获取视频详情
	* @Author:         zhh
	* @CreateDate:     2018/11/26 18:11
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 18:11
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/

	@RequestMapping(value = "/a/u/video/{id}", method = RequestMethod.GET)
	public String getVideoList(ModelMap model, @PathVariable Long id,Long userId) throws Exception {

		log.info("get data : id= " + id);
		try {
			Video video = videoService.getObjectById(id);
			log.info("get video data is " + video);
			//获取用户对视频的点赞状态
			Map<String,Object> map = DynamicSqlUtil.userVideoUpvoteDynamicSql(id,userId);
			log.info("map"+map);
			List<Long> userVideoUpvoteIds = userVideoUpvoteService.getIdsByDynamicCondition(UserVideoUpvote.class,map,0,Integer.MAX_VALUE);
			List<UserVideoUpvote> userVideoUpvotes=userVideoUpvoteService.getObjectsByIds(userVideoUpvoteIds);
			if(DataUtils.isNotNullOrEmpty(userVideoUpvotes)) {
				log.info(userVideoUpvotes.get(0));
				model.addAttribute("upvote", UserVideoUpvote.VIDEO_UPVOTE_STATUS);
			}else{
				//未点赞
				model.addAttribute("upvote", UserVideoUpvote.VIDEO_NOT_UPVOTE_STATUS);
			}

			//获取用户对视频的收藏状态
			Map<String,Object> map1 = DynamicSqlUtil.userVideoCollectDynamicSql(id,userId);
			log.info("map1"+map1);
			List<Long> userVideoCollectIds = userVideoCollectService.getIdsByDynamicCondition(UserVideoCollect.class,map1,0,Integer.MAX_VALUE);
			List<UserVideoCollect> userVideoCollects=userVideoCollectService.getObjectsByIds(userVideoCollectIds);
			if(DataUtils.isNotNullOrEmpty(userVideoCollects)) {
				log.info(userVideoCollects.get(0));
				model.addAttribute("collect", UserVideoCollect.VIDEO_COLLECTION_STATUS);
			}else{
				//未收藏
				model.addAttribute("collect", UserVideoCollect.VIDEO_NOT_COLLECTION_STATUS);
			}

			model.addAttribute("code", 0);

			model.addAttribute("video", video);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get video error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/video/json/videoDetailJson";
	}


	/**
	 * @Description:    获取视频轮廓图
	 * @Author:         zhh
	 * @CreateDate:     2018/11/26 16:40
	 * @UpdateUser:     zhh
	 * @UpdateDate:     2018/11/26 16:40
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video/banner", method = RequestMethod.GET)
	public String getBanner(ModelMap model) throws ServiceException, ServiceDaoException {
		log.info("begin get banner");
		Map<String,Object> map = DynamicSqlUtil.getVideoBanner(Video.BANNER_VIDEO);
		List<Long> videoIds = videoService.getIdsByDynamicCondition(Video.class,map,0,Integer.MAX_VALUE);
		List<Video> videoList = videoService.getObjectsByIds(videoIds);
		model.addAttribute("code", 0);
		model.addAttribute("total",videoList.size());
		model.addAttribute("videoList", videoList);
		return "/academy-rich-home-service/video/json/bannerListJson";
	}

}

