package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.VideoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class VideoServiceTest {

	private static final Log log = LogFactory.getLog(VideoServiceTest.class);
	
	private VideoService videoService;
	
	
	    @Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/academy-rich-home-service/applicationContext-server.xml");
	        videoService = (VideoService) context.getBean("videoService");
			//local server
			/**
			videoService = (VideoService)  Naming.lookup("//localhost:20683/VideoRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 videoService = (VideoService) context.getBean("videoService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Video video  = new Video();
	   					 
			   					                video.setTitle("高中");
            
			   					                video.setType(1);

			   					                video.setTeacherId((long) 1);
            
			   					                video.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/b30dbca4a27648a3948c8bfbbaf247f6.jpg");
            
			   					                video.setUrl("https://ks3-cn-beijing.ksyun.com/buttomsup/%E5%9F%BA%E5%9B%A0%E7%AA%81%E5%8F%98.mp4");
            
			   					                video.setGrade(1);
            
			   					                video.setSubject(1);
            
			   					                video.setSummary("天马");
            
			   					                video.setContent("发的卡积分拉开就");
            
			   					                video.setCollection(10);
            
			   					                video.setUpvote(2);
            
			   					                video.setStatus(1);
            
			   					                video.setCreateBy(1L);
            
			   					                video.setUpdateBy(1L);
            
			   					 
			   					 
			   	 
	 
	  Long id= this.videoService.insert(video);

      video = this.videoService.getObjectById(id);

	  Video video2=this.videoService.getObjectById(id);
	    Assert.assertNotNull(video2);

		// 2. 更改
				 		 				 				   video.setTitle("初中");
				 		 				 				   video.setTeacherId((long) 5);
		    		 				 				   video.setType(2);
		    		 				 				   video.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/b30dbca4a27648a3948c8bfbbaf247f6.jpg");
		    		 				 				   video.setUrl("https://ks3-cn-beijing.ksyun.com/buttomsup/%E5%9F%BA%E5%9B%A0%E7%AA%81%E5%8F%98.mp4");
		    		 				 				   video.setGrade(2);
		    		 				 				   video.setSubject(2);
		    		 				 				   video.setSummary("安居客福利的");
		    		 				 				   video.setContent("卡点福利卡开发阶段");
		    		 				 				   video.setCollection(12);
		    		 				 				   video.setUpvote(1);
		    		 				 				   video.setStatus(1);
		    		 				 				   video.setCreateBy(2L);
		    		 				 				   video.setUpdateBy(2L);
		    		 				 		 				 		 				boolean success=this.videoService.update(video);
		Assert.assertEquals(true, success);
//		 Video video3=this.videoService.getObjectById(id);
//				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
//		boolean successDelete=this.videoService.delete(id);
//		Assert.assertEquals(true, success);
//		Video video4=this.videoService.getObjectById(id);
//		Assert.assertNull(video4);
//
//		//4.batchInsert
//		 List<Video> list=new ArrayList<Video>();
//	  	  Video video5  = new Video();
//
//			   					                video5.setTitle("高中");
//
//			   					                video5.setType(1);
//
//			   					                video5.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/b30dbca4a27648a3948c8bfbbaf247f6.jpg");
//
//			   					                video5.setUrl("https://ks3-cn-beijing.ksyun.com/buttomsup/%E5%9F%BA%E5%9B%A0%E7%AA%81%E5%8F%98.mp4");
//
//			   					                video5.setGrade(1);
//
//			   					                video5.setSubject(1);
//
//			   					                video5.setSummary("天马");
//
//			   					                video5.setContent("发的卡积分拉开就");
//
//			   					                video5.setCollection(10);
//
//			   					                video5.setUpvote(2);
//
//			   					                video5.setStatus(1);
//
//			   					                video5.setCreateBy(1L);
//
//			   					                video5.setUpdateBy(1L);
//
//
//
//			   	    list.add(video5);
//	  	  Video video6  = new Video();
//
//			   					                video6.setTitle("初中");
//
//			   					                video6.setType(2);
//
//			   					                video6.setImg("https://pictureok.oss-cn-shenzhen.aliyuncs.com/article/b30dbca4a27648a3948c8bfbbaf247f6.jpg");
//
//			   					                video6.setUrl("https://ks3-cn-beijing.ksyun.com/buttomsup/%E5%9F%BA%E5%9B%A0%E7%AA%81%E5%8F%98.mp4");
//
//			   					                video6.setGrade(2);
//
//			   					                video6.setSubject(2);
//
//			   					                video6.setSummary("安居客福利的");
//
//			   					                video6.setContent("卡点福利卡开发阶段");
//
//			   					                video6.setCollection(12);
//
//			   					                video6.setUpvote(1);
//
//			   					                video6.setStatus(1);
//
//			   					                video6.setCreateBy(2L);
//
//			   					                video6.setUpdateBy(2L);
//
//
//
//			   	   list.add(video6);
//	   List<Video> insertResults= this.videoService.insertList(list);
//	   Assert.assertEquals(2,insertResults.size());
//	   //5.batchGet
//	   List<Long> ids=new ArrayList<Long>();
//		for(Video o: insertResults){
//		   ids.add(o.getId());
//		}
//
//	    List<Video> getResults= this.videoService.getObjectsByIds(ids);
//		Assert.assertEquals(2,getResults.size());
//
//
//		 for(Video o :insertResults){
//			this.videoService.delete(o.getId());
//}

		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

