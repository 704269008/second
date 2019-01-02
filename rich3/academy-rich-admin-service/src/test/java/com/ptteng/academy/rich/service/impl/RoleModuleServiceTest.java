package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.RoleModule;
import com.ptteng.academy.rich.service.RoleModuleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class RoleModuleServiceTest {

	private static final Log log = LogFactory.getLog(RoleModuleServiceTest.class);
	
	private RoleModuleService roleModuleService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        roleModuleService = (RoleModuleService) context.getBean("roleModuleService");
			//local server
			/**
			roleModuleService = (RoleModuleService)  Naming.lookup("//localhost:20693/RoleModuleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 roleModuleService = (RoleModuleService) context.getBean("roleModuleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  RoleModule roleModule  = new RoleModule();
	   					 
			   					                roleModule.setRoleId(1L);
            
			   					                roleModule.setModuleId(1L);
            
			   	 
	 
	  Long id= this.roleModuleService.insert(roleModule);

//      roleModule = this.roleModuleService.getObjectById(id);
//
//	  RoleModule roleModule2=this.roleModuleService.getObjectById(id);
//	    Assert.assertNotNull(roleModule2);
//
//		// 2. 更改
//				 		 				 				   roleModule.setRoleId(2L);
//		    		 				 				   roleModule.setModuleId(2L);
//		    		 				boolean success=this.roleModuleService.update(roleModule);
//		Assert.assertEquals(true, success);
//		 RoleModule roleModule3=this.roleModuleService.getObjectById(id);
//				 		 				             		 				             		 				//3.删除
//		boolean successDelete=this.roleModuleService.delete(id);
//		Assert.assertEquals(true, success);
//		RoleModule roleModule4=this.roleModuleService.getObjectById(id);
//		Assert.assertNull(roleModule4);
//
//		//4.batchInsert
//		 List<RoleModule> list=new ArrayList<RoleModule>();
//	  	  RoleModule roleModule5  = new RoleModule();
//
//			   					                roleModule5.setRoleId(1L);
//
//			   					                roleModule5.setModuleId(1L);
//
//			   	    list.add(roleModule5);
//	  	  RoleModule roleModule6  = new RoleModule();
//
//			   					                roleModule6.setRoleId(2L);
//
//			   					                roleModule6.setModuleId(2L);
//
//			   	   list.add(roleModule6);
//	   List<RoleModule> insertResults= this.roleModuleService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(RoleModule o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<RoleModule> getResults= this.roleModuleService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(RoleModule o :insertResults){
//			this.roleModuleService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

