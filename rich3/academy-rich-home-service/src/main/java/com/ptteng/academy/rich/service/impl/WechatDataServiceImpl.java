package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.WechatData;
import com.ptteng.academy.rich.service.WechatDataService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class WechatDataServiceImpl extends BaseDaoServiceImpl implements WechatDataService {

 

	private static final Log log = LogFactory.getLog(WechatDataServiceImpl.class);



		   
		@Override
		public Long insert(WechatData wechatData)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + wechatData);

		if (wechatData == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		wechatData.setCreateAt(currentTimeMillis);
		wechatData.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(wechatData);
		} catch (DaoException e) {
			log.error(" insert wrong : " + wechatData);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<WechatData> insertList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (wechatDataList == null ? "null" : wechatDataList.size()));
      
		List<WechatData> resultList = null;

		if (CollectionUtils.isEmpty(wechatDataList)) {
			return new ArrayList<WechatData>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (WechatData wechatData : wechatDataList) {
			wechatData.setCreateAt(currentTimeMillis);
			wechatData.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<WechatData>) dao.batchSave(wechatDataList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + wechatDataList);
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
			result = dao.delete(WechatData.class, id);
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
		public boolean update(WechatData wechatData)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (wechatData == null ? "null" : wechatData.getId()));

		boolean result = false;

		if (wechatData == null) {
			return true;
		}

		wechatData.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(wechatData);
		} catch (DaoException e) {
			log.error(" update wrong : " + wechatData);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + wechatData);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (wechatDataList == null ? "null" : wechatDataList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(wechatDataList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (WechatData wechatData : wechatDataList) {
			wechatData.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(wechatDataList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + wechatDataList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + wechatDataList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public WechatData getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		WechatData wechatData = null;

		if (id == null) {
			return wechatData;
		}

		try {
			wechatData = (WechatData) dao.get(WechatData.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return wechatData;		
		}	
		  
    	   
		@Override
		public List<WechatData> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<WechatData> wechatData = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<WechatData>();
		}

		try {
			wechatData = (List<WechatData>) dao.getList(WechatData.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (wechatData == null ? "null" : wechatData.size()));
    
		return wechatData;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getWechatDataIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getWechatDataIdsAll",new Object[] {},start, limit, false);
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
	public Integer countWechatDataIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getWechatDataIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getWechatDataIds " ) ;
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

