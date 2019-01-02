package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.academy.rich.service.UserVideoCollectService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserVideoCollectServiceImpl extends BaseDaoServiceImpl implements UserVideoCollectService {

 

	private static final Log log = LogFactory.getLog(UserVideoCollectServiceImpl.class);



		   
		@Override
		public Long insert(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userVideoCollect);

		if (userVideoCollect == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();


		Long result = null;
		try {
			result = (Long) dao.save(userVideoCollect);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userVideoCollect);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserVideoCollect> insertList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userVideoCollectList == null ? "null" : userVideoCollectList.size()));
      
		List<UserVideoCollect> resultList = null;

		if (CollectionUtils.isEmpty(userVideoCollectList)) {
			return new ArrayList<UserVideoCollect>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserVideoCollect userVideoCollect : userVideoCollectList) {

		}

		try {
			resultList = (List<UserVideoCollect>) dao.batchSave(userVideoCollectList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userVideoCollectList);
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
			result = dao.delete(UserVideoCollect.class, id);
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
		public boolean update(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userVideoCollect == null ? "null" : userVideoCollect.getId()));

		boolean result = false;

		if (userVideoCollect == null) {
			return true;
		}



		try {
			result = dao.update(userVideoCollect);
		} catch (DaoException e) {
			log.error(" update wrong : " + userVideoCollect);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userVideoCollect);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userVideoCollectList == null ? "null" : userVideoCollectList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userVideoCollectList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserVideoCollect userVideoCollect : userVideoCollectList) {

		}

		try {
			result = dao.batchUpdate(userVideoCollectList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userVideoCollectList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userVideoCollectList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserVideoCollect getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserVideoCollect userVideoCollect = null;

		if (id == null) {
			return userVideoCollect;
		}

		try {
			userVideoCollect = (UserVideoCollect) dao.get(UserVideoCollect.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userVideoCollect;		
		}	
		  
    	   
		@Override
		public List<UserVideoCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserVideoCollect> userVideoCollect = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserVideoCollect>();
		}

		try {
			userVideoCollect = (List<UserVideoCollect>) dao.getList(UserVideoCollect.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userVideoCollect == null ? "null" : userVideoCollect.size()));
    
		return userVideoCollect;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserVideoCollectIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserVideoCollectIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserVideoCollectIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserVideoCollectIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserVideoCollectIds " ) ;
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

