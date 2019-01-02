package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Article;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.academy.rich.service.ArticleService;
import com.ptteng.academy.rich.service.UserArticleUpvoteService;
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
* @Description:    前台--文章点赞修改
* @Author:         zhh
* @CreateDate:     2018/11/26 16:57
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 16:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UserArticleUpvoteController {
	private static final Log log = LogFactory.getLog(UserArticleUpvoteController.class);

	@Autowired
	private UserArticleUpvoteService userArticleUpvoteService;

	@Autowired
	private ArticleService articleService;

	/**
	* @Description:    添加数据到用户文章点赞表
	* @Author:         zhh
	* @CreateDate:     2018/11/26 17:14
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 17:14
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userArticleUpvote", method = RequestMethod.POST)
	public String addUserArticleUpvote(ModelMap model,Long userId,@RequestBody Article article ) throws Exception {
		
		log.info("add userArticleUpvote");
		UserArticleUpvote userArticleUpvote = new UserArticleUpvote();
		try { 
			userArticleUpvote.setId(null);
			userArticleUpvote.setArticleId(article.getId());
			userArticleUpvote.setUserId(userId);
			log.info(userArticleUpvote);
			userArticleUpvoteService.insert(userArticleUpvote);
			log.info("add data success");
			article.setUpvote(article.getUpvote()+1);
			articleService.update(article);
			log.info("update success");
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userArticleUpvote error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}



	/**
	* @Description:    取消点赞，删除数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 17:16
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 17:16
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userArticleUpvote/{id}", method = RequestMethod.DELETE)
	public String deleteUserArticleUpvote(ModelMap model, @PathVariable Long id,@RequestBody Article article)
			throws Exception {

		log.info("delete userArticleUpvote : id= " + id);
		try {
			userArticleUpvoteService.delete(id);

			log.info("delete userArticleUpvote success");
			article.setUpvote(article.getUpvote()-1);
			articleService.update(article);
			log.info("update success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userArticleUpvote error,id is  " + id);
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-home-service/data/json";
	}

}

