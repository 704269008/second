package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Teacher;
import com.ptteng.academy.rich.service.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class TeacherServiceTest {

	private static final Log log = LogFactory.getLog(TeacherServiceTest.class);
	
	private TeacherService teacherService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-admin-service/applicationContext-server.xml");
	        teacherService = (TeacherService) context.getBean("teacherService");
			//local server
			/**
			teacherService = (TeacherService)  Naming.lookup("//localhost:20693/TeacherRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 teacherService = (TeacherService) context.getBean("teacherService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Teacher teacher  = new Teacher();
	   					 
			   					                teacher.setName("牛顿");
            
			   					                teacher.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/video/dd5597f5d36845cfb22655f67f654c40.jpg");
            
			   					                teacher.setCreateBy(1L);
            
			   					                teacher.setUpdateBy(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.teacherService.insert(teacher);

//      teacher = this.teacherService.getObjectById(id);
//
//	  Teacher teacher2=this.teacherService.getObjectById(id);
//	    Assert.assertNotNull(teacher2);
//
//		// 2. 更改
//				 		 				 				   teacher.setName("爱迪生");
//		    		 				 				   teacher.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/video/dd5597f5d36845cfb22655f67f654c40.jpg");
//		    		 				 				   teacher.setCreateBy(2L);
//		    		 				 				   teacher.setUpdateBy(2L);
//		    		 				 		 				 		 				boolean success=this.teacherService.update(teacher);
//		Assert.assertEquals(true, success);
//		 Teacher teacher3=this.teacherService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.teacherService.delete(id);
//		Assert.assertEquals(true, success);
//		Teacher teacher4=this.teacherService.getObjectById(id);
//		Assert.assertNull(teacher4);
//
//		//4.batchInsert
//		 List<Teacher> list=new ArrayList<Teacher>();
//	  	  Teacher teacher5  = new Teacher();
//
//			   					                teacher5.setName("牛顿");
//
//			   					                teacher5.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/video/dd5597f5d36845cfb22655f67f654c40.jpg");
//
//			   					                teacher5.setCreateBy(1L);
//
//			   					                teacher5.setUpdateBy(1L);
//
//
//
//			   	    list.add(teacher5);
//	  	  Teacher teacher6  = new Teacher();
//
//			   					                teacher6.setName("爱迪生");
//
//			   					                teacher6.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/video/dd5597f5d36845cfb22655f67f654c40.jpg");
//
//			   					                teacher6.setCreateBy(2L);
//
//			   					                teacher6.setUpdateBy(2L);
//
//
//
//			   	   list.add(teacher6);
//	   List<Teacher> insertResults= this.teacherService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(Teacher o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<Teacher> getResults= this.teacherService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(Teacher o :insertResults){
//			this.teacherService.delete(o.getId());
//}
//
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

