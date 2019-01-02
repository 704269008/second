package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.academy.rich.service.UserArticleCollectService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserArticleCollectServiceImpl extends BaseDaoServiceImpl implements UserArticleCollectService {

 

	private static final Log log = LogFactory.getLog(UserArticleCollectServiceImpl.class);



		   
		@Override
		public Long insert(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userArticleCollect);

		if (userArticleCollect == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();


		Long result = null;
		try {
			result = (Long) dao.save(userArticleCollect);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userArticleCollect);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserArticleCollect> insertList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userArticleCollectList == null ? "null" : userArticleCollectList.size()));
      
		List<UserArticleCollect> resultList = null;

		if (CollectionUtils.isEmpty(userArticleCollectList)) {
			return new ArrayList<UserArticleCollect>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticleCollect userArticleCollect : userArticleCollectList) {

		}

		try {
			resultList = (List<UserArticleCollect>) dao.batchSave(userArticleCollectList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userArticleCollectList);
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
			result = dao.delete(UserArticleCollect.class, id);
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
		public boolean update(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userArticleCollect == null ? "null" : userArticleCollect.getId()));

		boolean result = false;

		if (userArticleCollect == null) {
			return true;
		}



		try {
			result = dao.update(userArticleCollect);
		} catch (DaoException e) {
			log.error(" update wrong : " + userArticleCollect);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userArticleCollect);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userArticleCollectList == null ? "null" : userArticleCollectList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userArticleCollectList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticleCollect userArticleCollect : userArticleCollectList) {

		}

		try {
			result = dao.batchUpdate(userArticleCollectList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userArticleCollectList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userArticleCollectList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserArticleCollect getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserArticleCollect userArticleCollect = null;

		if (id == null) {
			return userArticleCollect;
		}

		try {
			userArticleCollect = (UserArticleCollect) dao.get(UserArticleCollect.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userArticleCollect;		
		}	
		  
    	   
		@Override
		public List<UserArticleCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserArticleCollect> userArticleCollect = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserArticleCollect>();
		}

		try {
			userArticleCollect = (List<UserArticleCollect>) dao.getList(UserArticleCollect.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userArticleCollect == null ? "null" : userArticleCollect.size()));
    
		return userArticleCollect;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserArticleCollectIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserArticleCollectIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserArticleCollectIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserArticleCollectIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserArticleCollectIds " ) ;
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

