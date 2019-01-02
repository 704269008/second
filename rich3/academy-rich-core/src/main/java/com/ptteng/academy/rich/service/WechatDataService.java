package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.WechatData;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface WechatDataService extends BaseDaoService {

	



   		   
		
		public Long insert(WechatData wechatData)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<WechatData> insertList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(WechatData wechatData)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public WechatData getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<WechatData> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getWechatDataIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countWechatDataIds() throws ServiceException, ServiceDaoException;
	

}

