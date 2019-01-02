/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.VideoService;

import java.util.List;
import java.util.Map;

public class VideoSCAClient implements VideoService {

    private VideoService videoService;

	public VideoService getVideoService() {
		return videoService;
	}
	
	
	public void setVideoService(VideoService videoService) {
		this.videoService =videoService;
	}
	
	
			   
		@Override
		public Long insert(Video video)throws ServiceException, ServiceDaoException{
		
		return videoService.insert(video);
		          
		
		}	
		  
    	   
		@Override
		public List<Video> insertList(List<Video> videoList)throws ServiceException, ServiceDaoException{
		
		return videoService.insertList(videoList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return videoService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Video video)throws ServiceException, ServiceDaoException{
		
		return videoService.update(video);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Video> videoList)throws ServiceException, ServiceDaoException{
		
		return videoService.updateList(videoList);
		          
		
		}	
		  
    	   
		@Override
		public Video getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return videoService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Video> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return videoService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getVideoIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return videoService.getVideoIds(start, limit);
	}

	@Override
	public Integer countVideoIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return videoService.countVideoIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return videoService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return videoService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   videoService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.videoService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

