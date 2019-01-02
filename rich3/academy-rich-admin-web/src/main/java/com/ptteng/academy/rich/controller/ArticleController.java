package com.ptteng.academy.rich.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Article;
import com.ptteng.academy.rich.service.ArticleService;
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

import java.util.List;
import java.util.Map;

/**
* @Description:    文章模块
* @Author:         zhh
* @CreateDate:     2018/11/21 11:12
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/21 11:12
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class ArticleController {
	private static final Log log = LogFactory.getLog(ArticleController.class);

	@Autowired
	private ArticleService articleService;


	/**
	* @Description:    文章列表，条件查询
	* @Author:         zhh
	* @CreateDate:     2018/11/21 11:22
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 11:22
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article/list", method = RequestMethod.GET)
	public String getArticleList(ModelMap model, String title,String writer,Integer minUpvote,Integer maxUpvote,
									  Integer type,Integer status,Integer minCollection,Integer maxCollection,Integer pageNow,Integer pageSize) throws Exception {
		log.info("<======>get  /a/u/article/list  begin getArticleList() method:");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");

		Integer size = pageMap.get("size");
		Integer page = pageMap.get("page");
		try {

			Map<String,Object> params = DynamicSqlUtil.articleDynamicSql(title,writer,minUpvote,maxUpvote,type,status,minCollection,maxCollection);
			log.info("params"+params);
			//获取用户总数量
			List<Long> totalArticleIds = articleService.getIdsByDynamicCondition(Article.class, params, 0, Integer.MAX_VALUE);
			if(totalArticleIds==null){
				log.info("article is not exist");
				model.addAttribute("code", -4001);
				return "/academy-rich-admin-service/data/json";
			}
			Integer total = totalArticleIds.size();
			log.info("用户总数："+total);
			//获取一页的记录
			List<Long> articleIds =articleService.getIdsByDynamicCondition(Article.class,params,start,size);
			List<Article> articleList = articleService.getObjectsByIds(articleIds);
			log.info("get  article data is " + articleList);
			model.addAttribute("code", 0);
			model.addAttribute("total",total);
			model.addAttribute("articleList", articleList);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get article error");
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/article/json/articleListJson";
	}

/**
* @Description:    查看文章详情
* @Author:         zhh
* @CreateDate:     2018/11/21 12:40
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/21 12:40
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
	@RequestMapping(value = "/a/u/article/{id}", method = RequestMethod.GET)
	public String getArticle(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("get article data : id= " + id);
		try {
			Article article = articleService.getObjectById(id);
			model.addAttribute("code", 0);
			model.addAttribute("article", article);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get article error,id is  " + id);
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/article/json/articleDetailJson";
	}

	/**
	* @Description:    编辑文章信息
	* @Author:         zhh
	* @CreateDate:     2018/11/21 12:46
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 12:46
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article", method = RequestMethod.PUT)
	public String updateArticle(ModelMap model, @RequestBody Article article) throws Exception {
		
		log.info("update article : article= " + article);
		long time = System.currentTimeMillis();
		//设置最新信息修改时间
		article.setUpdateAt(time);
		try {
			article.setUpdateAt(System.currentTimeMillis());
			log.info("begin update method：");
			articleService.update(article);
			model.addAttribute("code", 0);
			model.addAttribute("article", article);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article error,id is  " + article.getId());
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}

	/**
	* @Description:    新增文章
	* @Author:         zhh
	* @CreateDate:     2018/11/21 13:07
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 13:07
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article", method = RequestMethod.POST)
	public String addArticle(ModelMap model,@RequestBody Article article) throws Exception {
		
		log.info("add article : article= " + article);
		
		try {
			//初始创建时间和更新时间相同
			long time = System.currentTimeMillis();
			article.setCreateAt(time);
			article.setUpdateAt(time);

			//默认新增文章状态为下架
			article.setStatus(Article.PULL_OFF_SHELVES);
			log.info(article);
			Long id = articleService.insert(article);
			if(id!=null) {
				log.info("insert data success,id = " + id);
			}
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add article error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/data/json";
	}

	/**
	* @Description:    文章上架和下架
	* @Author:         zhh
	* @CreateDate:     2018/11/21 13:17
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 13:17
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/article/{id}/status", method = RequestMethod.PUT)
	public String updateArticleStatus(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("update article status : id= " + id);
		try {
			Article article = articleService.getObjectById(id);
			log.info("get article data:"+article);
			int status = article.getStatus();
			//是否上下架操作
			if (status == Article.SHELVES) {
				log.info("begin down");
				article.setStatus(Article.PULL_OFF_SHELVES);
			} else {
				log.info("begin up");
				article.setStatus(Article.SHELVES);
				//如果上架的是banner图，做最大banner图数量判断
				if(article.getType()==Article.BANNER_ARTICLE){
					shelfMaxBanner(article);
				}
			}
			article.setUpdateAt(System.currentTimeMillis());
			articleService.update(article);

			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update article status error,id is  " + id);
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}

	//上架的最多banner图
	private void shelfMaxBanner(Article article){
		log.info("it is a banner");
		Map<String,Object> articleDynamicSql = DynamicSqlUtil.articleDynamicSql(null,null,null,null,article.getType(),article.getStatus(),null,null);
		try {
			//获取所有banner图列表
			List<Long> articleIds = articleService.getIdsByDynamicCondition(Article.class,articleDynamicSql,0,Integer.MAX_VALUE);
			//banner图 >= 8
			if(articleIds.size() >= Article.MAX_BANNER_NUMBER){
				log.info("banner size >= 8");
				//取出banner最早一个，进行下架操作
				List<Article> articleList = articleService.getObjectsByIds(articleIds);
				Article earlyArticle = articleList.get(articleList.size()-1);
				earlyArticle.setStatus(Article.PULL_OFF_SHELVES);
				earlyArticle.setUpdateAt(System.currentTimeMillis());
				articleService.update(earlyArticle);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ServiceDaoException e) {
			log.info("articleService getIdsByDynamicCondition is error");
			e.printStackTrace();
		}
	}

}

