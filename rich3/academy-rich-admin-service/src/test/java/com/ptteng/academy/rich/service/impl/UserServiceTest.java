package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.User;
import com.ptteng.academy.rich.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class UserServiceTest {

	private static final Log log = LogFactory.getLog(UserServiceTest.class);
	
	private UserService userService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        userService = (UserService) context.getBean("userService");
			//local server
			/**
			userService = (UserService)  Naming.lookup("//localhost:20693/UserRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userService = (UserService) context.getBean("userService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
		for(long i=23;i<=105;i++) {
			User user = new User();

			user.setOpenid("oXGXd0mg8i4lTXUPh6LxR6W42VMw");

			user.setName("愤怒的小鸟");

			user.setGrade(1);

			user.setAvatar("https://pictureok.oss-cn-shenzhen.aliyuncs.com/user/d1f072e9c79a41f9b88a6942494c27d8.jpg");

			user.setPhone("18210397204");

			user.setEmail("384324197@qq.com");

			user.setArea("湖南省岳阳市");

			user.setStatus(1);

			user.setCreateBy(1L);

			user.setUpdateBy(1L);


			Long id = this.userService.insert(user);
		}
//
//      user = this.userService.getObjectById(id);
//
//	  User user2=this.userService.getObjectById(id);
//	    Assert.assertNotNull(user2);
//
//		// 2. 更改
//				 		 				 				   user.setOpenid("oXGXd0mg8i4lTXUPh6LxR6W42VMw");
//		    		 				 				   user.setName("愤怒的小鸟2");
//		    		 				 				   user.setGrade(6);
//		    		 				 				   user.setAvatar("https://pictureok.oss-cn-shenzhen.aliyuncs.com/user/d1f072e9c79a41f9b88a6942494c27d8.jpg");
//		    		 				 				   user.setPhone("13111215879");
//		    		 				 				   user.setEmail("fengpeiyu@ptteng.com");
//		    		 				 				   user.setArea("北京市海淀区");
//		    		 				 				   user.setStatus(2);
//		    		 				 				   user.setCreateBy(2L);
//		    		 				 				   user.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.userService.update(user);
//		Assert.assertEquals(true, success);
//		 User user3=this.userService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.userService.delete(id);
//		Assert.assertEquals(true, success);
//		User user4=this.userService.getObjectById(id);
//		Assert.assertNull(user4);
//
//		//4.batchInsert
//		 List<User> list=new ArrayList<User>();
//	  	  User user5  = new User();
//
//			   					                user5.setOpenid("oXGXd0mg8i4lTXUPh6LxR6W42VMw");
//
//			   					                user5.setName("愤怒的小鸟");
//
//			   					                user5.setGrade(1);
//
//			   					                user5.setAvatar("https://pictureok.oss-cn-shenzhen.aliyuncs.com/user/d1f072e9c79a41f9b88a6942494c27d8.jpg");
//
//			   					                user5.setPhone("18210397204");
//
//			   					                user5.setEmail("384324197@qq.com");
//
//			   					                user5.setArea("湖南省岳阳市");
//
//			   					                user5.setStatus(1);
//
//			   					                user5.setCreateBy(1L);
//
//			   					                user5.setUpdateBy(1L);
//
//
//
//			   	    list.add(user5);
//	  	  User user6  = new User();
//
//			   					                user6.setOpenid("oXGXd0mg8i4lTXUPh6LxR6W42VMw");
//
//			   					                user6.setName("愤怒的小鸟2");
//
//			   					                user6.setGrade(6);
//
//			   					                user6.setAvatar("https://pictureok.oss-cn-shenzhen.aliyuncs.com/user/d1f072e9c79a41f9b88a6942494c27d8.jpg");
//
//			   					                user6.setPhone("13111215879");
//
//			   					                user6.setEmail("fengpeiyu@ptteng.com");
//
//			   					                user6.setArea("北京市海淀区");
//
//			   					                user6.setStatus(2);
//
//			   					                user6.setCreateBy(2L);
//
//			   					                user6.setUpdateBy(2L);
//
//
//
//			   	   list.add(user6);
//	   List<User> insertResults= this.userService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(User o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<User> getResults= this.userService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(User o :insertResults){
//			this.userService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

