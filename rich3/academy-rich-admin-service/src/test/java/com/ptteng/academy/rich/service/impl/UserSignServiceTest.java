package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserSignService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class UserSignServiceTest {

	private static final Log log = LogFactory.getLog(UserSignServiceTest.class);
	
	private UserSignService userSignService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        userSignService = (UserSignService) context.getBean("userSignService");
			//local server
			/**
			userSignService = (UserSignService)  Naming.lookup("//localhost:20693/UserSignRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userSignService = (UserSignService) context.getBean("userSignService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 for(long i=23;i<=105;i++) {
		 UserSign userSign = new UserSign();

		 userSign.setUserId(i);

		 userSign.setBeans(100);

		 userSign.setTotalSign(1);

		 userSign.setMaxSign(1);

		 userSign.setContinuousSign(1);

		 userSign.setSignSet("10100110101010101010101111010");

		 userSign.setRecordSign(1);

		 userSign.setCreateBy(1L);

		 userSign.setUpdateBy(1L);


		 Long id = this.userSignService.insert(userSign);
	 }
//
//      userSign = this.userSignService.getObjectById(id);
//
//	  UserSign userSign2=this.userSignService.getObjectById(id);
//	    Assert.assertNotNull(userSign2);
//
//		// 2. 更改
//				 		 				 				   userSign.setUserId(3L);
//		    		 				 				   userSign.setBeans(120);
//		    		 				 				   userSign.setTotalSign(2);
//		    		 				 				   userSign.setMaxSign(2);
//		    		 				 				   userSign.setContinuousSign(2);
//		    		 				 				   userSign.setSignSet("10110101010101010101010111010101");
//		    		 				 				   userSign.setRecordSign(2);
//		    		 				 				   userSign.setCreateBy(2L);
//		    		 				 				   userSign.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.userSignService.update(userSign);
//		Assert.assertEquals(true, success);
//		 UserSign userSign3=this.userSignService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.userSignService.delete(id);
//		Assert.assertEquals(true, success);
//		UserSign userSign4=this.userSignService.getObjectById(id);
//		Assert.assertNull(userSign4);
//
//		//4.batchInsert
//		 List<UserSign> list=new ArrayList<UserSign>();
//	  	  UserSign userSign5  = new UserSign();
//
//			   					                userSign5.setUserId(2L);
//
//			   					                userSign5.setBeans(100);
//
//			   					                userSign5.setTotalSign(1);
//
//			   					                userSign5.setMaxSign(1);
//
//			   					                userSign5.setContinuousSign(1);
//
//			   					                userSign5.setSignSet("10100110101010101010101111010");
//
//			   					                userSign5.setRecordSign(1);
//
//			   					                userSign5.setCreateBy(1L);
//
//			   					                userSign5.setUpdateBy(1L);
//
//
//
//			   	    list.add(userSign5);
//	  	  UserSign userSign6  = new UserSign();
//
//			   					                userSign6.setUserId(3L);
//
//			   					                userSign6.setBeans(120);
//
//			   					                userSign6.setTotalSign(2);
//
//			   					                userSign6.setMaxSign(2);
//
//			   					                userSign6.setContinuousSign(2);
//
//			   					                userSign6.setSignSet("10110101010101010101010111010101");
//
//			   					                userSign6.setRecordSign(2);
//
//			   					                userSign6.setCreateBy(2L);
//
//			   					                userSign6.setUpdateBy(2L);
//
//
//
//			   	   list.add(userSign6);
//	   List<UserSign> insertResults= this.userSignService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(UserSign o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<UserSign> getResults= this.userSignService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(UserSign o :insertResults){
//			this.userSignService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

