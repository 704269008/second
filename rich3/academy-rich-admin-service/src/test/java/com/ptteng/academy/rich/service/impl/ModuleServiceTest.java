package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.service.ModuleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class ModuleServiceTest {

	private static final Log log = LogFactory.getLog(ModuleServiceTest.class);
	
	private ModuleService moduleService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        moduleService = (ModuleService) context.getBean("moduleService");
			//local server
			/**
			moduleService = (ModuleService)  Naming.lookup("//localhost:20693/ModuleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 moduleService = (ModuleService) context.getBean("moduleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Module module  = new Module();
	   					 
			   					                module.setName("后台管理");
            
			   					                module.setUrl("/c/user");
            
			   					                module.setParentId(1);
            
			   					                module.setSort(1);
            
			   					                module.setCreateBy(1L);
            
			   					                module.setUpdateBy(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.moduleService.insert(module);

//      module = this.moduleService.getObjectById(id);
//
//	  Module module2=this.moduleService.getObjectById(id);
//	    Assert.assertNotNull(module2);
//
//		// 2. 更改
//				 		 				 				   module.setName("角色管理");
//		    		 				 				   module.setUrl("/c/role");
//		    		 				 				   module.setParentId(2);
//		    		 				 				   module.setSort(2);
//		    		 				 				   module.setCreateBy(2L);
//		    		 				 				   module.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.moduleService.update(module);
//		Assert.assertEquals(true, success);
//		 Module module3=this.moduleService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.moduleService.delete(id);
//		Assert.assertEquals(true, success);
//		Module module4=this.moduleService.getObjectById(id);
//		Assert.assertNull(module4);
//
//		//4.batchInsert
//		 List<Module> list=new ArrayList<Module>();
//	  	  Module module5  = new Module();
//
//			   					                module5.setName("后台管理");
//
//			   					                module5.setUrl("/c/user");
//
//			   					                module5.setParentId(1);
//
//			   					                module5.setSort(1);
//
//			   					                module5.setCreateBy(1L);
//
//			   					                module5.setUpdateBy(1L);
//
//
//
//			   	    list.add(module5);
//	  	  Module module6  = new Module();
//
//			   					                module6.setName("角色管理");
//
//			   					                module6.setUrl("/c/role");
//
//			   					                module6.setParentId(2);
//
//			   					                module6.setSort(2);
//
//			   					                module6.setCreateBy(2L);
//
//			   					                module6.setUpdateBy(2L);
//
//
//
//			   	   list.add(module6);
//	   List<Module> insertResults= this.moduleService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(Module o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<Module> getResults= this.moduleService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(Module o :insertResults){
//			this.moduleService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

