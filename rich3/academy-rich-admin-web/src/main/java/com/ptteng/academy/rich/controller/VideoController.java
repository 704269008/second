package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Teacher;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.TeacherService;
import com.ptteng.academy.rich.service.VideoService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.ptteng.academy.rich.utils.PageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Video  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class VideoController {
	private static final Log log = LogFactory.getLog(VideoController.class);

	@Autowired
	private VideoService videoService;

	@Autowired
	private TeacherService teacherService;


	/**
	 * @Description:    动态查询视频列表页
	 * @Author:         wyq
	 * @Date:     2018/11/21 15:19
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video/list", method = RequestMethod.GET)
	public String getVideoList(ModelMap model, Integer pageNow, Integer pageSize, String title,
							   Integer type, Integer grade, Integer subject, String teacherName, Integer minUpvote,
							   Integer maxUpvote, Integer minCollection, Integer maxCollection, Integer status)
			throws Exception {

		Map<String,Integer> ps = PageUtil.checkPageAndSize(pageNow,pageSize);
		pageNow = ps.get("page");
		pageSize = ps.get("size");
		int start = ps.get("start");
		try {
			Map<String, Object> params = DynamicSqlUtil.videoDynamicSql(title, minUpvote, maxUpvote, type, status,
					minCollection, maxCollection, subject, grade, teacherName);

			List<Long> videoTotalList = videoService.getIdsByDynamicCondition(Video.class, params, 0, Integer.MAX_VALUE);
			int videoTotal = videoTotalList.size();
			List<Long> videoIdList = videoService.getIdsByDynamicCondition(Video.class, params, start, pageSize);
			List<Video> videoList = videoService.getObjectsByIds(videoIdList);

			List<Map<String, Object>> maps = new ArrayList<>();
			for (Video video :videoList) {

				Teacher teacher = teacherService.getObjectById(video.getTeacherId());
				if(teacher==null){
					log.error("teacher="+teacher.getId()+"response teacher is not exit");
					model.addAttribute("code", -7002);
					return "/academy-rich-admin-service/data/json";
				}
				Map<String, Object> map = new HashMap<>();
				map.put("id", video.getId());
				map.put("title", video.getTitle());
				map.put("type", video.getType());
				map.put("grade", video.getGrade());
				map.put("subject", video.getSubject());
				map.put("teacherId", video.getTeacherId());
				map.put("teacherName", teacher.getName());
				map.put("collection",video.getCollection());
				map.put("upvote", video.getUpvote());
				map.put("updateAt", video.getUpdateAt());
				map.put("status", video.getStatus());
				log.info("map: "+map);
				//把数据合并到新建的集合中。
				maps.add(map);
			}
			model.addAttribute("code", 0);
			model.addAttribute("videoList", maps);
			model.addAttribute("page", pageNow);
			model.addAttribute("size", pageSize);
			model.addAttribute("total", videoTotal);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get video error");
			model.addAttribute("code",-100000);
		}
		return "/academy-rich-admin-service/video/json/videoListJson";
	}


	/**
	 * @Description:    视频详情页
	 * @Author:         wyq
	 * @Date:	 2018/11/21 15:17
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video/{id}", method = RequestMethod.GET)
	public String getVideo(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("/video/" + id);
		try {
			Video video = videoService.getObjectById(id);
			Teacher teacher = teacherService.getObjectById(video.getTeacherId());
			log.info("video:"+video);
			model.addAttribute("teacherId",teacher.getId());
			model.addAttribute("teacherName", teacher.getName());
			model.addAttribute("code",0);
			model.addAttribute("video",video);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			model.addAttribute("code",-100000);
		}

		return "/academy-rich-admin-service/video/json/videoDetailJson";
	}

	/**
	 * @Description:    修改视频详情
	 * @Author:         wyq
	 * @Date:     2018/11/21 18:09
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video", method = RequestMethod.PUT)
	public String updateVideoJson(ModelMap model, @RequestBody Video video) throws Exception {

		log.info("update video : video= " + video);

		video.setUpdateAt(System.currentTimeMillis());
		try {

			videoService.update(video);

			model.addAttribute("code", 0);

			model.addAttribute("video", video);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update video error,id is  " + video.getId());
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-admin-service/data/json";
	}

	/**
	 * @Description:    新增视频接口
	 * @Author:         wyq
	 * @Date:     2018/11/21 18:19
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video", method = RequestMethod.POST)
	public String addVideoJson(ModelMap model, @RequestBody Video video) throws Exception {

		log.info("update video : video= " + video);

		video.setId(null);
		video.setStatus(video.PULL_OFF_SHELVES);
		long datetime = System.currentTimeMillis();
		video.setCreateAt(datetime);
		video.setUpdateAt(datetime);

		try {

			videoService.insert(video);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add video error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/data/json";
	}

	/**
	 * @Description:    视频上下架
	 * @Author:         wyq
	 * @Date:     2018/11/22 9:58
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/video/{id}/status", method = RequestMethod.PUT)
	public String changeVideoStatus( ModelMap model, @PathVariable Long id) throws Exception{

		Video video = videoService.getObjectById(id);

		log.info("video:"+video);
		int type = video.getType();
		int status = video.getStatus();

		if(status == Video.PULL_OFF_SHELVES) {
			if (type == Video.BANNER_VIDEO) {
				Map<String, Object> params = DynamicSqlUtil.videoDynamicSql(null, null, null,
						Video.BANNER_VIDEO, Video.SHELVES,null, null, null,
						null, null);


				List<Long> videoTotalList = videoService.getIdsByDynamicCondition(Video.class, params, 0, Integer.MAX_VALUE);

				if (videoTotalList.size() > Video.MAX_BANNER_NUMBER - 1) {
					log.info("banner大于7");
					try {
						Long lastId = videoTotalList.get(7);
						Video lastVideo = videoService.getObjectById(lastId);
						lastVideo.setStatus(Video.PULL_OFF_SHELVES);
						lastVideo.setUpdateAt(System.currentTimeMillis());
						log.info("执行下架");
						videoService.update(lastVideo);
						log.info("change last video status success");
					}catch (Throwable t){
						t.printStackTrace();
						log.error(t.getMessage());
						model.addAttribute("code",-100000);
					}
				}
			}
			video.setStatus(Video.SHELVES);
		}else {
			video.setStatus(Video.PULL_OFF_SHELVES);
		}
		try {
			Long time = System.currentTimeMillis();
			video.setUpdateAt(time);
			videoService.update(video);
			log.info("change video status success");
			model.addAttribute("code",0);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			model.addAttribute("code",-100000);
		}
		return "/academy-rich-admin-service/data/json";
	}

}

