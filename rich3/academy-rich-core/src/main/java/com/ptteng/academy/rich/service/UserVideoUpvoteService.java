package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserVideoUpvoteService extends BaseDaoService {

	



   		   
		
		public Long insert(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserVideoUpvote> insertList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserVideoUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserVideoUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserVideoUpvoteIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserVideoUpvoteIds() throws ServiceException, ServiceDaoException;
	

}

