package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserSignService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserSignServiceImpl extends BaseDaoServiceImpl implements UserSignService {

 

	private static final Log log = LogFactory.getLog(UserSignServiceImpl.class);



		   
		@Override
		public Long insert(UserSign userSign)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userSign);

		if (userSign == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		userSign.setCreateAt(currentTimeMillis);
		userSign.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(userSign);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userSign);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserSign> insertList(List<UserSign> userSignList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userSignList == null ? "null" : userSignList.size()));
      
		List<UserSign> resultList = null;

		if (CollectionUtils.isEmpty(userSignList)) {
			return new ArrayList<UserSign>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserSign userSign : userSignList) {
			userSign.setCreateAt(currentTimeMillis);
			userSign.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UserSign>) dao.batchSave(userSignList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userSignList);
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
			result = dao.delete(UserSign.class, id);
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
		public boolean update(UserSign userSign)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userSign == null ? "null" : userSign.getId()));

		boolean result = false;

		if (userSign == null) {
			return true;
		}

		userSign.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(userSign);
		} catch (DaoException e) {
			log.error(" update wrong : " + userSign);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userSign);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserSign> userSignList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userSignList == null ? "null" : userSignList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userSignList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserSign userSign : userSignList) {
			userSign.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userSignList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userSignList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userSignList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserSign getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserSign userSign = null;

		if (id == null) {
			return userSign;
		}

		try {
			userSign = (UserSign) dao.get(UserSign.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userSign;		
		}	
		  
    	   
		@Override
		public List<UserSign> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserSign> userSign = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserSign>();
		}

		try {
			userSign = (List<UserSign>) dao.getList(UserSign.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userSign == null ? "null" : userSign.size()));
    
		return userSign;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getUserSignIdByUserId(Long userId)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by userId  : " + userId );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getUserSignIdByUserId", new Object[] {userId });
   } catch (DaoException e) {
			log.error(" get id wrong by userId  : " + userId );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getUserSignIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserSignIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserSignIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserSignIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserSignIds " ) ;
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

