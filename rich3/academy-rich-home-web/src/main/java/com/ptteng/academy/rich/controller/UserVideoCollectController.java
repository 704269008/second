package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.UserVideoCollectService;
import com.ptteng.academy.rich.service.VideoService;
import com.ptteng.academy.rich.util.DynamicSqlUtil;
import com.ptteng.academy.rich.util.PageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
* @Description:    视频收藏
* @Author:         zhh
* @CreateDate:     2018/11/26 18:32
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 18:32
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UserVideoCollectController {
	private static final Log log = LogFactory.getLog(UserVideoCollectController.class);

	@Autowired
	private UserVideoCollectService userVideoCollectService;

	@Autowired
	private VideoService videoService;


	/**
	* @Description:     用户视频收藏，添加数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 18:51
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 18:51
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userVideoCollect", method = RequestMethod.POST)
	public String addUserVideoCollect(ModelMap model, Long userId,  @RequestBody Video video) throws Exception {
		
		log.info("update userVideoCollect");
		UserVideoCollect userVideoCollect=new UserVideoCollect();
		try { 
			userVideoCollect.setId(null);
			userVideoCollect.setUserId(userId);
			userVideoCollect.setArticleId(video.getId());
			video.setCollection(video.getCollection()+1);

			userVideoCollectService.insert(userVideoCollect);
			log.info("add data success");
			videoService.update(video);
			log.info("update success");

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userVideoCollect error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:     用户视频取消收藏，删除数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 18:51
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 18:51
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userVideoCollect/{id}", method = RequestMethod.DELETE)
	public String deleteUserVideoCollect( ModelMap model, @PathVariable Long id,@RequestBody Video video)
			throws Exception {

		log.info("delete userVideoCollect : id= " + id);
		try {
			userVideoCollectService.delete(id);

			log.info("delete userVideoCollect success");
			video.setCollection(video.getCollection()-1);
			videoService.update(video);
			log.info("update success");

			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userVideoCollect error,id is  " + id);
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:    用户视频收藏列表
	* @Author:         zhh
	* @CreateDate:     2018/11/28 16:15
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/28 16:15
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/video/list", method = RequestMethod.GET)
	public String getUserVideoList(ModelMap model,Integer pageNow, Integer pageSize, Long userId) throws Exception {
		log.info("<=====getUserArticleList begin=====>");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");
		Integer page = pageMap.get("page");

		Integer size = pageMap.get("size");

		try {
			Map<String,Object> map = DynamicSqlUtil.userVideoDynamicSql(userId);
			List<Long> videoIds = userVideoCollectService.getIdsByDynamicCondition(UserVideoCollect.class,map,0,Integer.MAX_VALUE);
			List<Video> videoLists = videoService.getObjectsByIds(videoIds);

			List<Long> ids = userVideoCollectService.getIdsByDynamicCondition(Video.class,map,start,size);
			List<Video> videoList = videoService.getObjectsByIds(ids);

			model.addAttribute("code", 0);
			model.addAttribute("total",videoLists.size());
			model.addAttribute("size",size);
			model.addAttribute("page",page);
			model.addAttribute("videoList", videoList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get userVideo error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/video/json/videoListJson";
	}

	
}

