package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserArticleUpvoteService extends BaseDaoService {

	



   		   
		
		public Long insert(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticleUpvote> insertList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserArticleUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticleUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserArticleUpvoteIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserArticleUpvoteIds() throws ServiceException, ServiceDaoException;
	

}

