package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.academy.rich.service.UserVideoUpvoteService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserVideoUpvoteServiceImpl extends BaseDaoServiceImpl implements UserVideoUpvoteService {

 

	private static final Log log = LogFactory.getLog(UserVideoUpvoteServiceImpl.class);



		   
		@Override
		public Long insert(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userVideoUpvote);

		if (userVideoUpvote == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();


		Long result = null;
		try {
			result = (Long) dao.save(userVideoUpvote);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userVideoUpvote);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserVideoUpvote> insertList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userVideoUpvoteList == null ? "null" : userVideoUpvoteList.size()));
      
		List<UserVideoUpvote> resultList = null;

		if (CollectionUtils.isEmpty(userVideoUpvoteList)) {
			return new ArrayList<UserVideoUpvote>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserVideoUpvote userVideoUpvote : userVideoUpvoteList) {

		}

		try {
			resultList = (List<UserVideoUpvote>) dao.batchSave(userVideoUpvoteList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userVideoUpvoteList);
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
			result = dao.delete(UserVideoUpvote.class, id);
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
		public boolean update(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userVideoUpvote == null ? "null" : userVideoUpvote.getId()));

		boolean result = false;

		if (userVideoUpvote == null) {
			return true;
		}



		try {
			result = dao.update(userVideoUpvote);
		} catch (DaoException e) {
			log.error(" update wrong : " + userVideoUpvote);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userVideoUpvote);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userVideoUpvoteList == null ? "null" : userVideoUpvoteList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userVideoUpvoteList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserVideoUpvote userVideoUpvote : userVideoUpvoteList) {

		}

		try {
			result = dao.batchUpdate(userVideoUpvoteList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userVideoUpvoteList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userVideoUpvoteList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserVideoUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserVideoUpvote userVideoUpvote = null;

		if (id == null) {
			return userVideoUpvote;
		}

		try {
			userVideoUpvote = (UserVideoUpvote) dao.get(UserVideoUpvote.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userVideoUpvote;		
		}	
		  
    	   
		@Override
		public List<UserVideoUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserVideoUpvote> userVideoUpvote = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserVideoUpvote>();
		}

		try {
			userVideoUpvote = (List<UserVideoUpvote>) dao.getList(UserVideoUpvote.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userVideoUpvote == null ? "null" : userVideoUpvote.size()));
    
		return userVideoUpvote;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserVideoUpvoteIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserVideoUpvoteIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserVideoUpvoteIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserVideoUpvoteIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserVideoUpvoteIds " ) ;
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

