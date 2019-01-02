package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.UserVideoUpvoteService;
import com.ptteng.academy.rich.service.VideoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* @Description:    视频点赞
* @Author:         zhh
* @CreateDate:     2018/11/26 18:32
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 18:32
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UserVideoUpvoteController {
	private static final Log log = LogFactory.getLog(UserVideoUpvoteController.class);

	@Autowired
	private UserVideoUpvoteService userVideoUpvoteService;

	@Autowired
	private VideoService videoService;


	/**
	* @Description:    用户视频点赞，添加数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 18:50
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 18:50
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userVideoUpvote", method = RequestMethod.POST)
	public String addUserVideoUpvote(ModelMap model,Long userId, @RequestBody Video video) throws Exception {
		
		log.info("update userVideoUpvote" );
		UserVideoUpvote userVideoUpvote=new UserVideoUpvote();
		try { 
			userVideoUpvote.setId(null);
			userVideoUpvote.setArticleId(video.getId());
			userVideoUpvote.setUserId(userId);
			userVideoUpvoteService.insert(userVideoUpvote);
			log.info("add data success");
			video.setUpvote(video.getUpvote()+1);
			videoService.update(video);
			log.info("update success");

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userVideoUpvote error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:     用户视频取消点赞，删除数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 18:50
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 18:50
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userVideoUpvote/{id}", method = RequestMethod.DELETE)
	public String deleteUserVideoUpvote(ModelMap model, @PathVariable Long id, @RequestBody Video video)
			throws Exception {

		log.info("delete userVideoUpvote : id= " + id);
		try {
			userVideoUpvoteService.delete(id);
			log.info("delete userVideoUpvote success");
			video.setUpvote(video.getUpvote()-1);
			videoService.update(video);
			log.info("update success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userVideoUpvote error,id is  " + id);
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-home-service/data/json";
	}
	

}

