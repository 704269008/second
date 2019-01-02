package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.academy.rich.service.UserArticleUpvoteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class UserArticleUpvoteServiceTest {

	private static final Log log = LogFactory.getLog(UserArticleUpvoteServiceTest.class);
	
	private UserArticleUpvoteService userArticleUpvoteService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        userArticleUpvoteService = (UserArticleUpvoteService) context.getBean("userArticleUpvoteService");
			//local server
			/**
			userArticleUpvoteService = (UserArticleUpvoteService)  Naming.lookup("//localhost:20683/UserArticleUpvoteRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userArticleUpvoteService = (UserArticleUpvoteService) context.getBean("userArticleUpvoteService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  UserArticleUpvote userArticleUpvote  = new UserArticleUpvote();
	   					 
			   					                userArticleUpvote.setUserId(2L);
            
			   					                userArticleUpvote.setArticleId(1L);
            
			   					                userArticleUpvote.setUpvoteTag(1);
            
			   					                userArticleUpvote.setUpvoteAt(1L);
            
			   	 
	 
	  Long id= this.userArticleUpvoteService.insert(userArticleUpvote);

      userArticleUpvote = this.userArticleUpvoteService.getObjectById(id);

	  UserArticleUpvote userArticleUpvote2=this.userArticleUpvoteService.getObjectById(id);
	    Assert.assertNotNull(userArticleUpvote2);
	  
		// 2. 更改 
				 		 				 				   userArticleUpvote.setUserId(3L);
		    		 				 				   userArticleUpvote.setArticleId(2L);
		    		 				 				   userArticleUpvote.setUpvoteTag(2);
		    		 				 				   userArticleUpvote.setUpvoteAt(2L);
		    		 				boolean success=this.userArticleUpvoteService.update(userArticleUpvote);		
		Assert.assertEquals(true, success);
		 UserArticleUpvote userArticleUpvote3=this.userArticleUpvoteService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				//3.删除
		boolean successDelete=this.userArticleUpvoteService.delete(id);	
		Assert.assertEquals(true, success);
		UserArticleUpvote userArticleUpvote4=this.userArticleUpvoteService.getObjectById(id);
		Assert.assertNull(userArticleUpvote4);
		
		//4.batchInsert
		 List<UserArticleUpvote> list=new ArrayList<UserArticleUpvote>();
	  	  UserArticleUpvote userArticleUpvote5  = new UserArticleUpvote();
	   					 
			   					                userArticleUpvote5.setUserId(2L);
            
			   					                userArticleUpvote5.setArticleId(1L);
            
			   					                userArticleUpvote5.setUpvoteTag(1);
            
			   					                userArticleUpvote5.setUpvoteAt(1L);
            
			   	    list.add(userArticleUpvote5);	   
	  	  UserArticleUpvote userArticleUpvote6  = new UserArticleUpvote();
	   					 
			   					                userArticleUpvote6.setUserId(3L);
            
			   					                userArticleUpvote6.setArticleId(2L);
            
			   					                userArticleUpvote6.setUpvoteTag(2);
            
			   					                userArticleUpvote6.setUpvoteAt(2L);
            
			   	   list.add(userArticleUpvote6);
	   List<UserArticleUpvote> insertResults= this.userArticleUpvoteService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(UserArticleUpvote o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<UserArticleUpvote> getResults= this.userArticleUpvoteService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(UserArticleUpvote o :insertResults){
			this.userArticleUpvoteService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

