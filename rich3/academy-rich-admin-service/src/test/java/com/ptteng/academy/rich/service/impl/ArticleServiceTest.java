package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Article;
import com.ptteng.academy.rich.service.ArticleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class ArticleServiceTest {

	private static final Log log = LogFactory.getLog(ArticleServiceTest.class);
	
	private ArticleService articleService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        articleService = (ArticleService) context.getBean("articleService");
			//local server
			/**
			articleService = (ArticleService)  Naming.lookup("//localhost:20693/ArticleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 articleService = (ArticleService) context.getBean("articleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加

		 Article article = new Article();

		 article.setTitle("高中");

		 article.setType(1);

		 article.setCover("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/9647425b5c1d4044bcdd8392aa3b63d1.jpg");

		 article.setWriter("纽带");

		 article.setSummary("牛顿是个天才");

		 article.setContent("吞吞吐吐拖拖拖拖拖");

		 article.setCollection(10);

		 article.setUpvote(2);

		 article.setStatus(1);

		 article.setCreateBy(1L);

		 article.setUpdateBy(1L);


		 Long id = this.articleService.insert(article);


//      article = this.articleService.getObjectById(id);
//
//	  Article article2=this.articleService.getObjectById(id);
//	    Assert.assertNotNull(article2);
//
//		// 2. 更改
//				 		 				 				   article.setTitle("初中");
//		    		 				 				   article.setType(2);
//		    		 				 				   article.setCover("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/25dae74226574eb898a02b5fd5f83428.jpg");
//		    		 				 				   article.setWriter("纽拉");
//		    		 				 				   article.setSummary("德玛西亚");
//		    		 				 				   article.setContent("吞吞吐吐拖拖拖拖拖拖拖拖拖拖");
//		    		 				 				   article.setCollection(12);
//		    		 				 				   article.setUpvote(1);
//		    		 				 				   article.setStatus(1);
//		    		 				 				   article.setCreateBy(2L);
//		    		 				 				   article.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.articleService.update(article);
//		Assert.assertEquals(true, success);
//		 Article article3=this.articleService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.articleService.delete(id);
//		Assert.assertEquals(true, success);
//		Article article4=this.articleService.getObjectById(id);
//		Assert.assertNull(article4);
//
//		//4.batchInsert
//		 List<Article> list=new ArrayList<Article>();
//	  	  Article article5  = new Article();
//
//			   					                article5.setTitle("高中");
//
//			   					                article5.setType(1);
//
//			   					                article5.setCover("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/9647425b5c1d4044bcdd8392aa3b63d1.jpg");
//
//			   					                article5.setWriter("纽带");
//
//			   					                article5.setSummary("牛顿是个天才");
//
//			   					                article5.setContent("吞吞吐吐拖拖拖拖拖");
//
//			   					                article5.setCollection(10);
//
//			   					                article5.setUpvote(2);
//
//			   					                article5.setStatus(1);
//
//			   					                article5.setCreateBy(1L);
//
//			   					                article5.setUpdateBy(1L);
//
//
//
//			   	    list.add(article5);
//	  	  Article article6  = new Article();
//
//			   					                article6.setTitle("初中");
//
//			   					                article6.setType(2);
//
//			   					                article6.setCover("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/25dae74226574eb898a02b5fd5f83428.jpg");
//
//			   					                article6.setWriter("纽拉");
//
//			   					                article6.setSummary("德玛西亚");
//
//			   					                article6.setContent("吞吞吐吐拖拖拖拖拖拖拖拖拖拖");
//
//			   					                article6.setCollection(12);
//
//			   					                article6.setUpvote(1);
//
//			   					                article6.setStatus(1);
//
//			   					                article6.setCreateBy(2L);
//
//			   					                article6.setUpdateBy(2L);
//
//
//
//			   	   list.add(article6);
//	   List<Article> insertResults= this.articleService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(Article o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<Article> getResults= this.articleService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(Article o :insertResults){
//			this.articleService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

