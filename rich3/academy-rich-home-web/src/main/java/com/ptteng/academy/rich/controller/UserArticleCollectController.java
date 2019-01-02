package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Article;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.academy.rich.service.ArticleService;
import com.ptteng.academy.rich.service.UserArticleCollectService;
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
* @Description:    用户文章收藏
* @Author:         zhh
* @CreateDate:     2018/11/26 17:17
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 17:17
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UserArticleCollectController {
	private static final Log log = LogFactory.getLog(UserArticleCollectController.class);

	@Autowired
	private UserArticleCollectService userArticleCollectService;

	@Autowired
	private ArticleService articleService;

	/**
	* @Description:     收藏文章，添加数据
	* @Author:         zhh
	* @CreateDate:     2018/11/26 17:19
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 17:19
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/

	@RequestMapping(value = "/a/u/userArticleCollect", method = RequestMethod.POST)
	public String addUserArticleCollect(ModelMap model, Long userId,  @RequestBody Article article) throws Exception {
		
		log.info("add userArticleCollect");
		UserArticleCollect userArticleCollect=new UserArticleCollect();
		try { 
			userArticleCollect.setId(null);
			userArticleCollect.setUserId(userId);
			userArticleCollect.setArticleId(article.getId());

			log.info(userArticleCollect);
			userArticleCollectService.insert(userArticleCollect);
			log.info("add data success");
			article.setCollection(article.getCollection()+1);
			articleService.update(article);
			log.info("update success");
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userArticleCollect error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:    删除数据，取消收藏
	* @Author:         zhh
	* @CreateDate:     2018/11/26 17:19
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 17:19
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/userArticleCollect/{id}", method = RequestMethod.DELETE)
	public String deleteUserArticleCollect(ModelMap model, @PathVariable Long id,@RequestBody Article article)
			throws Exception {

		log.info("delete userArticleCollect : id= " + id);
		try {
			userArticleCollectService.delete(id);

			log.info("delete userArticleCollect success");
			article.setCollection(article.getCollection()-1);
			articleService.update(article);
			log.info("update success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userArticleCollect error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:    用户文章收藏列表
	* @Author:         zhh
	* @CreateDate:     2018/11/28 16:09
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/28 16:09
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/article/list", method = RequestMethod.GET)
	public String getUserArticleList(ModelMap model,Long userId,Integer pageNow,Integer pageSize) throws Exception {

		log.info("<=====getUserArticleList begin=====>");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");
		Integer page = pageMap.get("page");

		Integer size = pageMap.get("size");

		try {

			Map<String,Object> map = DynamicSqlUtil.userArticleDynamicSql(userId);

			List<Long> articleIds = userArticleCollectService.getIdsByDynamicCondition(UserArticleCollect.class,map,0,Integer.MAX_VALUE);
			List<Article> articleLists = articleService.getObjectsByIds(articleIds);


			List<Long> ids = userArticleCollectService.getIdsByDynamicCondition(Article.class,map,start,size);
			List<Article> articleList = articleService.getObjectsByIds(ids);
			log.info("get part article"+articleList);

			model.addAttribute("code", 0);
			model.addAttribute("total",articleLists.size());
			model.addAttribute("size",size);
			model.addAttribute("page",page);
			model.addAttribute("articleList", articleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get userArticle error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/article/json/articleListJson";
	}

}

