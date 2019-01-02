package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.academy.rich.service.UserVideoCollectService;
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
public class UserVideoCollectServiceTest {

	private static final Log log = LogFactory.getLog(UserVideoCollectServiceTest.class);
	
	private UserVideoCollectService userVideoCollectService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        userVideoCollectService = (UserVideoCollectService) context.getBean("userVideoCollectService");
			//local server
			/**
			userVideoCollectService = (UserVideoCollectService)  Naming.lookup("//localhost:20683/UserVideoCollectRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userVideoCollectService = (UserVideoCollectService) context.getBean("userVideoCollectService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  UserVideoCollect userVideoCollect  = new UserVideoCollect();
	   					 
			   					                userVideoCollect.setUserId(2L);
            
			   					                userVideoCollect.setArticleId(1L);
            
			   					                userVideoCollect.setCollectionTag(1);
            
			   					                userVideoCollect.setCollectAt(1L);
            
			   	 
	 
	  Long id= this.userVideoCollectService.insert(userVideoCollect);

      userVideoCollect = this.userVideoCollectService.getObjectById(id);

	  UserVideoCollect userVideoCollect2=this.userVideoCollectService.getObjectById(id);
	    Assert.assertNotNull(userVideoCollect2);
	  
		// 2. 更改 
				 		 				 				   userVideoCollect.setUserId(3L);
		    		 				 				   userVideoCollect.setArticleId(2L);
		    		 				 				   userVideoCollect.setCollectionTag(2);
		    		 				 				   userVideoCollect.setCollectAt(2L);
		    		 				boolean success=this.userVideoCollectService.update(userVideoCollect);		
		Assert.assertEquals(true, success);
		 UserVideoCollect userVideoCollect3=this.userVideoCollectService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				//3.删除
		boolean successDelete=this.userVideoCollectService.delete(id);	
		Assert.assertEquals(true, success);
		UserVideoCollect userVideoCollect4=this.userVideoCollectService.getObjectById(id);
		Assert.assertNull(userVideoCollect4);
		
		//4.batchInsert
		 List<UserVideoCollect> list=new ArrayList<UserVideoCollect>();
	  	  UserVideoCollect userVideoCollect5  = new UserVideoCollect();
	   					 
			   					                userVideoCollect5.setUserId(2L);
            
			   					                userVideoCollect5.setArticleId(1L);
            
			   					                userVideoCollect5.setCollectionTag(1);
            
			   					                userVideoCollect5.setCollectAt(1L);
            
			   	    list.add(userVideoCollect5);	   
	  	  UserVideoCollect userVideoCollect6  = new UserVideoCollect();
	   					 
			   					                userVideoCollect6.setUserId(3L);
            
			   					                userVideoCollect6.setArticleId(2L);
            
			   					                userVideoCollect6.setCollectionTag(2);
            
			   					                userVideoCollect6.setCollectAt(2L);
            
			   	   list.add(userVideoCollect6);
	   List<UserVideoCollect> insertResults= this.userVideoCollectService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(UserVideoCollect o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<UserVideoCollect> getResults= this.userVideoCollectService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(UserVideoCollect o :insertResults){
			this.userVideoCollectService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

