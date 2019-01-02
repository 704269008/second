package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.academy.rich.service.UserArticleCollectService;
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
public class UserArticleCollectServiceTest {

	private static final Log log = LogFactory.getLog(UserArticleCollectServiceTest.class);
	
	private UserArticleCollectService userArticleCollectService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        userArticleCollectService = (UserArticleCollectService) context.getBean("userArticleCollectService");
			//local server
			/**
			userArticleCollectService = (UserArticleCollectService)  Naming.lookup("//localhost:20683/UserArticleCollectRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userArticleCollectService = (UserArticleCollectService) context.getBean("userArticleCollectService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  UserArticleCollect userArticleCollect  = new UserArticleCollect();
	   					 
			   					                userArticleCollect.setUserId(2L);
            
			   					                userArticleCollect.setArticleId(1L);
            
			   					                userArticleCollect.setCollectionTag(1);
            
			   					                userArticleCollect.setCollectAt(1L);
            
			   	 
	 
	  Long id= this.userArticleCollectService.insert(userArticleCollect);

      userArticleCollect = this.userArticleCollectService.getObjectById(id);

	  UserArticleCollect userArticleCollect2=this.userArticleCollectService.getObjectById(id);
	    Assert.assertNotNull(userArticleCollect2);
	  
		// 2. 更改 
				 		 				 				   userArticleCollect.setUserId(3L);
		    		 				 				   userArticleCollect.setArticleId(2L);
		    		 				 				   userArticleCollect.setCollectionTag(2);
		    		 				 				   userArticleCollect.setCollectAt(2L);
		    		 				boolean success=this.userArticleCollectService.update(userArticleCollect);		
		Assert.assertEquals(true, success);
		 UserArticleCollect userArticleCollect3=this.userArticleCollectService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				//3.删除
		boolean successDelete=this.userArticleCollectService.delete(id);	
		Assert.assertEquals(true, success);
		UserArticleCollect userArticleCollect4=this.userArticleCollectService.getObjectById(id);
		Assert.assertNull(userArticleCollect4);
		
		//4.batchInsert
		 List<UserArticleCollect> list=new ArrayList<UserArticleCollect>();
	  	  UserArticleCollect userArticleCollect5  = new UserArticleCollect();
	   					 
			   					                userArticleCollect5.setUserId(2L);
            
			   					                userArticleCollect5.setArticleId(1L);
            
			   					                userArticleCollect5.setCollectionTag(1);
            
			   					                userArticleCollect5.setCollectAt(1L);
            
			   	    list.add(userArticleCollect5);	   
	  	  UserArticleCollect userArticleCollect6  = new UserArticleCollect();
	   					 
			   					                userArticleCollect6.setUserId(3L);
            
			   					                userArticleCollect6.setArticleId(2L);
            
			   					                userArticleCollect6.setCollectionTag(2);
            
			   					                userArticleCollect6.setCollectAt(2L);
            
			   	   list.add(userArticleCollect6);
	   List<UserArticleCollect> insertResults= this.userArticleCollectService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(UserArticleCollect o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<UserArticleCollect> getResults= this.userArticleCollectService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(UserArticleCollect o :insertResults){
			this.userArticleCollectService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

