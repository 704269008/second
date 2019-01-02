package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.Video;
import com.ptteng.academy.rich.service.VideoService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class VideoServiceImpl extends BaseDaoServiceImpl implements VideoService {

 

	private static final Log log = LogFactory.getLog(VideoServiceImpl.class);



		   
		@Override
		public Long insert(Video video)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + video);

		if (video == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		video.setCreateAt(currentTimeMillis);
		video.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(video);
		} catch (DaoException e) {
			log.error(" insert wrong : " + video);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Video> insertList(List<Video> videoList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (videoList == null ? "null" : videoList.size()));
      
		List<Video> resultList = null;

		if (CollectionUtils.isEmpty(videoList)) {
			return new ArrayList<Video>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Video video : videoList) {
			video.setCreateAt(currentTimeMillis);
			video.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Video>) dao.batchSave(videoList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + videoList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Video.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Video video)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (video == null ? "null" : video.getId()));

		boolean result = false;

		if (video == null) {
			return true;
		}

		video.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(video);
		} catch (DaoException e) {
			log.error(" update wrong : " + video);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + video);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Video> videoList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (videoList == null ? "null" : videoList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(videoList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Video video : videoList) {
			video.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(videoList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + videoList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + videoList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Video getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Video video = null;

		if (id == null) {
			return video;
		}

		try {
			video = (Video) dao.get(Video.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return video;		
		}	
		  
    	   
		@Override
		public List<Video> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Video> video = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Video>();
		}

		try {
			video = (List<Video>) dao.getList(Video.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (video == null ? "null" : video.size()));
    
		return video;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getVideoIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getVideoIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countVideoIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getVideoIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getVideoIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

