package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.WechatData;
import com.ptteng.academy.rich.service.WechatDataService;
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
public class WechatDataServiceTest {

	private static final Log log = LogFactory.getLog(WechatDataServiceTest.class);
	
	private WechatDataService wechatDataService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        wechatDataService = (WechatDataService) context.getBean("wechatDataService");
			//local server
			/**
			wechatDataService = (WechatDataService)  Naming.lookup("//localhost:20683/WechatDataRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 wechatDataService = (WechatDataService) context.getBean("wechatDataService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 //// 1.增加
	 //
	 // 	  WechatData wechatData  = new WechatData();
	 //
		//	   					                wechatData.setOpenId("牛顿");
      //
		//	   					                wechatData.setAccessToken("oXGXd0mg8i4lTXUPh6LxR6W42VMw");
      //
		//	   					                wechatData.setEmailCode(85697);
      //
		//	   					                wechatData.setPhoneCode(81564);
      //
		//	   					                wechatData.setEmailCodeTimes(1);
      //
		//	   					                wechatData.setPhoneCodeTimes(1);
      //
		//	   					                wechatData.setCreateBy(1L);
      //
		//	   					                wechatData.setUpdateBy(1L);
      //
		//
		//
		//
	 //
	 // Long id= this.wechatDataService.insert(wechatData);
     //
      //wechatData = this.wechatDataService.getObjectById(id);
     //
	 // WechatData wechatData2=this.wechatDataService.getObjectById(id);
	 //   Assert.assertNotNull(wechatData2);
	 //
		//// 2. 更改
		//		 		 				 				   wechatData.setOpenId("爱迪生");
		//    		 				 				   wechatData.setAccessToken("pXGXd0mg8i4lTXUPh6LxR6W42VMw");
		//    		 				 				   wechatData.setEmailCode(51384);
		//    		 				 				   wechatData.setPhoneCode(84546);
		//    		 				 				   wechatData.setEmailCodeTimes(2);
		//    		 				 				   wechatData.setPhoneCodeTimes(2);
		//    		 				 				   wechatData.setCreateBy(2L);
		//    		 				 				   wechatData.setUpdateBy(2L);
		//    		 				 		 				 		 				boolean success=this.wechatDataService.update(wechatData);
		//Assert.assertEquals(true, success);
		// WechatData wechatData3=this.wechatDataService.getObjectById(id);
		//		 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		//boolean successDelete=this.wechatDataService.delete(id);
		//Assert.assertEquals(true, success);
		//WechatData wechatData4=this.wechatDataService.getObjectById(id);
		//Assert.assertNull(wechatData4);
		
		//4.batchInsert
		 List<WechatData> list=new ArrayList<WechatData>();
	  	  WechatData wechatData5  = new WechatData();
	   					 
			   					                wechatData5.setOpenId("牛顿");
            
			   					                wechatData5.setAccessToken("oXGXd0mg8i4lTXUPh6LxR6W42VMw");
            
			   					                wechatData5.setEmailCode(85697);
            
			   					                wechatData5.setPhoneCode(81564);
            
			   					                wechatData5.setEmailCodeTimes(1);
            
			   					                wechatData5.setPhoneCodeTimes(1);
            
			   					                wechatData5.setCreateBy(1L);
            
			   					                wechatData5.setUpdateBy(1L);
            
			   					 
			   					 
			   	    list.add(wechatData5);	   
	  	  WechatData wechatData6  = new WechatData();
	   					 
			   					                wechatData6.setOpenId("爱迪生");
            
			   					                wechatData6.setAccessToken("pXGXd0mg8i4lTXUPh6LxR6W42VMw");
            
			   					                wechatData6.setEmailCode(51384);
            
			   					                wechatData6.setPhoneCode(84546);
            
			   					                wechatData6.setEmailCodeTimes(2);
            
			   					                wechatData6.setPhoneCodeTimes(2);
            
			   					                wechatData6.setCreateBy(2L);
            
			   					                wechatData6.setUpdateBy(2L);
            
			   					 
			   					 
			   	   list.add(wechatData6);
	   List<WechatData> insertResults= this.wechatDataService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(WechatData o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<WechatData> getResults= this.wechatDataService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(WechatData o :insertResults){
//			this.wechatDataService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

