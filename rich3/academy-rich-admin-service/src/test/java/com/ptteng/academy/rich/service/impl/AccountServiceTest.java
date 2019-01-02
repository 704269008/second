package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class AccountServiceTest {

	private static final Log log = LogFactory.getLog(AccountServiceTest.class);
	
	private AccountService accountService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        accountService = (AccountService) context.getBean("accountService");
			//local server
			/**
			accountService = (AccountService)  Naming.lookup("//localhost:20693/AccountRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 accountService = (AccountService) context.getBean("accountService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Account account  = new Account();
	   					 
			   					                account.setRoleId(1L);
            
			   					                account.setName("张三");
            
			   					                account.setPassword("e10adc3949ba59abbe56e057f20f883e");
            
			   					                account.setSalt("hSLEbnkTyD9XtRZ5jfCwHg==");
            
			   					                account.setCreateBy(1L);
            
			   					                account.setUpdateBy(2L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.accountService.insert(account);

//      account = this.accountService.getObjectById(id);
//
//	  Account account2=this.accountService.getObjectById(id);
//	    Assert.assertNotNull(account2);
//
//		// 2. 更改
//				 		 				 				   account.setRoleId(2L);
//		    		 				 				   account.setName("李四");
//		    		 				 				   account.setPassword("202cb962ac59075b964b07152d234b70");
//		    		 				 				   account.setSalt("av72Kd8gJ5pvvpNqFkHR5g==");
//		    		 				 				   account.setCreateBy(1L);
//		    		 				 				   account.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.accountService.update(account);
//		Assert.assertEquals(true, success);
//		 Account account3=this.accountService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.accountService.delete(id);
//		Assert.assertEquals(true, success);
//		Account account4=this.accountService.getObjectById(id);
//		Assert.assertNull(account4);
//
//		//4.batchInsert
//		 List<Account> list=new ArrayList<Account>();
//	  	  Account account5  = new Account();
//
//			   					                account5.setRoleId(1L);
//
//			   					                account5.setName("张三");
//
//			   					                account5.setPassword("e10adc3949ba59abbe56e057f20f883e");
//
//			   					                account5.setSalt("hSLEbnkTyD9XtRZ5jfCwHg==");
//
//			   					                account5.setCreateBy(1L);
//
//			   					                account5.setUpdateBy(2L);
//
//
//
//			   	    list.add(account5);
//	  	  Account account6  = new Account();
//
//			   					                account6.setRoleId(2L);
//
//			   					                account6.setName("李四");
//
//			   					                account6.setPassword("202cb962ac59075b964b07152d234b70");
//
//			   					                account6.setSalt("av72Kd8gJ5pvvpNqFkHR5g==");
//
//			   					                account6.setCreateBy(1L);
//
//			   					                account6.setUpdateBy(2L);
//
//
//
//			   	   list.add(account6);
//	   List<Account> insertResults= this.accountService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(Account o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<Account> getResults= this.accountService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(Account o :insertResults){
//			this.accountService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

