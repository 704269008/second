package com.ptteng.academy.rich.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Article;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.academy.rich.service.ArticleService;
import com.ptteng.academy.rich.service.UserArticleCollectService;
import com.ptteng.academy.rich.service.UserArticleUpvoteService;
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

import java.util.List;
import java.util.Map;

/**
* @Description:    前台--文章模块
* @Author:         zhh
* @CreateDate:     2018/11/26 14:44
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 14:44
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class ArticleController {
	private static final Log log = LogFactory.getLog(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserArticleUpvoteService userArticleUpvoteService;

	@Autowired
	private UserArticleCollectService userArticleCollectService;


	/**
	* @Description:    home 获取文章列表
	* @Author:         zhh
	* @CreateDate:     2018/11/26 14:48
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 14:48
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article/list", method = RequestMethod.GET)
	public String getArticleList(ModelMap model,Integer pageNow,Integer pageSize) throws Exception {

		log.info("get articleList begin:");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");
		Integer page = pageMap.get("page");

		Integer size = pageMap.get("size");
		try {
			Map<String,Object> map = DynamicSqlUtil.articleDynamicSql();
			List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class,map,0,Integer.MAX_VALUE);
			List<Article> articleLists = articleService.getObjectsByIds(articleIds);


			List<Long> ids = articleService.getIdsByDynamicCondition(Article.class,map,start,size);
			List<Article> articleList = articleService.getObjectsByIds(ids);

			model.addAttribute("code", 0);
			model.addAttribute("total",articleLists.size());
			model.addAttribute("size",size);
			model.addAttribute("page",page);
			model.addAttribute("articleList", articleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get article error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/article/json/articleListJson";
	}




	/**
	* @Description:    获取文章详情
	* @Author:         zhh
	* @CreateDate:     2018/11/26 15:38
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 15:38
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
	public String getArticle( ModelMap model, @PathVariable Long id,Long userId) throws Exception {

		log.info("get data : id= " + id);
		try {
			//获取文章信息
			Article article = articleService.getObjectById(id);
			log.info("get article data is " + article);

			//获取用户对文章的点赞状态
			Map<String,Object> map = DynamicSqlUtil.userArticleUpvoteDynamicSql(id,userId);
			log.info("map"+map);
			List<Long> userArticleUpvoteIds = userArticleUpvoteService.getIdsByDynamicCondition(UserArticleUpvote.class,map,0,Integer.MAX_VALUE);
			List<UserArticleUpvote> userArticleUpvotes=userArticleUpvoteService.getObjectsByIds(userArticleUpvoteIds);
			if(DataUtils.isNotNullOrEmpty(userArticleUpvotes)) {
				log.info(userArticleUpvotes.get(0));
				model.addAttribute("upvote", UserArticleUpvote.ARTICLE_UPVOTE_STATUS);
			}else{
				//未点赞
				model.addAttribute("upvote", UserArticleUpvote.ARTICLE_NOT_UPVOTE_STATUS);
			}

			//获取用户对文章的收藏状态
			Map<String,Object> map1 = DynamicSqlUtil.userArticleCollectDynamicSql(id,userId);
			log.info("map1"+map1);
			List<Long> userArticleCollectIds = userArticleCollectService.getIdsByDynamicCondition(UserArticleCollect.class,map1,0,Integer.MAX_VALUE);
			List<UserArticleCollect> userArticleCollects=userArticleCollectService.getObjectsByIds(userArticleCollectIds);
			if(DataUtils.isNotNullOrEmpty(userArticleCollects)) {
				log.info(userArticleCollects.get(0));
				model.addAttribute("collect", UserArticleCollect.ARTICLE_COLLECTION_STATUS);
			}else{
				//未收藏
				model.addAttribute("collect", UserArticleCollect.ARTICLE_NOT_COLLECTION_STATUS);
			}

			model.addAttribute("code", 0);

			model.addAttribute("article", article);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get article error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/article/json/articleDetailJson";
	}

	/**
	* @Description:    获取文章轮廓图
	* @Author:         zhh
	* @CreateDate:     2018/11/26 16:40
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/26 16:40
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article/banner", method = RequestMethod.GET)
	public String getBanner(ModelMap model) throws ServiceException, ServiceDaoException {
		log.info("begin get banner");
		Map<String,Object> map = DynamicSqlUtil.getArticleBanner(Article.BANNER_ARTICLE);
		List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class,map,0,Integer.MAX_VALUE);
		List<Article> articleList = articleService.getObjectsByIds(articleIds);
		model.addAttribute("code", 0);
		model.addAttribute("total",articleList.size());
		model.addAttribute("articleList", articleList);
		return "/academy-rich-home-service/article/json/bannerListJson";
	}
}

