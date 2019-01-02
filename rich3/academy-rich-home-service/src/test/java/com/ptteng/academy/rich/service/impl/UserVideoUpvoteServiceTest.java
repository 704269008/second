package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.academy.rich.service.UserVideoUpvoteService;
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
public class UserVideoUpvoteServiceTest {

	private static final Log log = LogFactory.getLog(UserVideoUpvoteServiceTest.class);
	
	private UserVideoUpvoteService userVideoUpvoteService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        userVideoUpvoteService = (UserVideoUpvoteService) context.getBean("userVideoUpvoteService");
			//local server
			/**
			userVideoUpvoteService = (UserVideoUpvoteService)  Naming.lookup("//localhost:20683/UserVideoUpvoteRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userVideoUpvoteService = (UserVideoUpvoteService) context.getBean("userVideoUpvoteService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  UserVideoUpvote userVideoUpvote  = new UserVideoUpvote();
	   					 
			   					                userVideoUpvote.setUserId(2L);
            
			   					                userVideoUpvote.setArticleId(1L);
            
			   					                userVideoUpvote.setUpvoteTag(1);
            
			   					                userVideoUpvote.setUpvoteAt(1L);
            
			   	 
	 
	  Long id= this.userVideoUpvoteService.insert(userVideoUpvote);

      userVideoUpvote = this.userVideoUpvoteService.getObjectById(id);

	  UserVideoUpvote userVideoUpvote2=this.userVideoUpvoteService.getObjectById(id);
	    Assert.assertNotNull(userVideoUpvote2);
	  
		// 2. 更改 
				 		 				 				   userVideoUpvote.setUserId(3L);
		    		 				 				   userVideoUpvote.setArticleId(2L);
		    		 				 				   userVideoUpvote.setUpvoteTag(2);
		    		 				 				   userVideoUpvote.setUpvoteAt(2L);
		    		 				boolean success=this.userVideoUpvoteService.update(userVideoUpvote);		
		Assert.assertEquals(true, success);
		 UserVideoUpvote userVideoUpvote3=this.userVideoUpvoteService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				//3.删除
		boolean successDelete=this.userVideoUpvoteService.delete(id);	
		Assert.assertEquals(true, success);
		UserVideoUpvote userVideoUpvote4=this.userVideoUpvoteService.getObjectById(id);
		Assert.assertNull(userVideoUpvote4);
		
		//4.batchInsert
		 List<UserVideoUpvote> list=new ArrayList<UserVideoUpvote>();
	  	  UserVideoUpvote userVideoUpvote5  = new UserVideoUpvote();
	   					 
			   					                userVideoUpvote5.setUserId(2L);
            
			   					                userVideoUpvote5.setArticleId(1L);
            
			   					                userVideoUpvote5.setUpvoteTag(1);
            
			   					                userVideoUpvote5.setUpvoteAt(1L);
            
			   	    list.add(userVideoUpvote5);	   
	  	  UserVideoUpvote userVideoUpvote6  = new UserVideoUpvote();
	   					 
			   					                userVideoUpvote6.setUserId(3L);
            
			   					                userVideoUpvote6.setArticleId(2L);
            
			   					                userVideoUpvote6.setUpvoteTag(2);
            
			   					                userVideoUpvote6.setUpvoteAt(2L);
            
			   	   list.add(userVideoUpvote6);
	   List<UserVideoUpvote> insertResults= this.userVideoUpvoteService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(UserVideoUpvote o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<UserVideoUpvote> getResults= this.userVideoUpvoteService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(UserVideoUpvote o :insertResults){
			this.userVideoUpvoteService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

