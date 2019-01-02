package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface UserArticleCollectService extends BaseDaoService {

	



   		   
		
		public Long insert(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticleCollect> insertList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserArticleCollect getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserArticleCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserArticleCollectIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserArticleCollectIds() throws ServiceException, ServiceDaoException;
	

}

