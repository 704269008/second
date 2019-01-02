package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserVideoCollectService extends BaseDaoService {

	



   		   
		
		public Long insert(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserVideoCollect> insertList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserVideoCollect getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserVideoCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserVideoCollectIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserVideoCollectIds() throws ServiceException, ServiceDaoException;
	

}

