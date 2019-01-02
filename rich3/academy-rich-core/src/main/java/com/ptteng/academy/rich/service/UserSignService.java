package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserSignService extends BaseDaoService {

	



   		   
		
		public Long insert(UserSign userSign)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserSign> insertList(List<UserSign> userSignList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserSign userSign)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserSign> userSignList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserSign getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserSign> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getUserSignIdByUserId(Long userId)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserSignIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserSignIds() throws ServiceException, ServiceDaoException;
	

}

