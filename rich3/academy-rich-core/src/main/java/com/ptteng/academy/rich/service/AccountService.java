package com.ptteng.academy.rich.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.common.dao.BaseDaoService;
import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface AccountService extends BaseDaoService {

	



   		   
		
		public Long insert(Account account)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Account> insertList(List<Account> accountList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Account account)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Account> accountList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Account getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Account> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAccountIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAccountIds() throws ServiceException, ServiceDaoException;
	

}

