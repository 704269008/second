package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.academy.rich.service.UserArticleUpvoteService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserArticleUpvoteServiceImpl extends BaseDaoServiceImpl implements UserArticleUpvoteService {

 

	private static final Log log = LogFactory.getLog(UserArticleUpvoteServiceImpl.class);



		   
		@Override
		public Long insert(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userArticleUpvote);

		if (userArticleUpvote == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();


		Long result = null;
		try {
			result = (Long) dao.save(userArticleUpvote);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userArticleUpvote);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserArticleUpvote> insertList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userArticleUpvoteList == null ? "null" : userArticleUpvoteList.size()));
      
		List<UserArticleUpvote> resultList = null;

		if (CollectionUtils.isEmpty(userArticleUpvoteList)) {
			return new ArrayList<UserArticleUpvote>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticleUpvote userArticleUpvote : userArticleUpvoteList) {

		}

		try {
			resultList = (List<UserArticleUpvote>) dao.batchSave(userArticleUpvoteList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userArticleUpvoteList);
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
			result = dao.delete(UserArticleUpvote.class, id);
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
		public boolean update(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userArticleUpvote == null ? "null" : userArticleUpvote.getId()));

		boolean result = false;

		if (userArticleUpvote == null) {
			return true;
		}



		try {
			result = dao.update(userArticleUpvote);
		} catch (DaoException e) {
			log.error(" update wrong : " + userArticleUpvote);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userArticleUpvote);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userArticleUpvoteList == null ? "null" : userArticleUpvoteList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userArticleUpvoteList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserArticleUpvote userArticleUpvote : userArticleUpvoteList) {

		}

		try {
			result = dao.batchUpdate(userArticleUpvoteList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userArticleUpvoteList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userArticleUpvoteList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserArticleUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserArticleUpvote userArticleUpvote = null;

		if (id == null) {
			return userArticleUpvote;
		}

		try {
			userArticleUpvote = (UserArticleUpvote) dao.get(UserArticleUpvote.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userArticleUpvote;		
		}	
		  
    	   
		@Override
		public List<UserArticleUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserArticleUpvote> userArticleUpvote = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserArticleUpvote>();
		}

		try {
			userArticleUpvote = (List<UserArticleUpvote>) dao.getList(UserArticleUpvote.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userArticleUpvote == null ? "null" : userArticleUpvote.size()));
    
		return userArticleUpvote;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserArticleUpvoteIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserArticleUpvoteIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserArticleUpvoteIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserArticleUpvoteIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserArticleUpvoteIds " ) ;
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

