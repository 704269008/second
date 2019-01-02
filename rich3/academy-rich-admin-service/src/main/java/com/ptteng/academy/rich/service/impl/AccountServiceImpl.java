package com.ptteng.academy.rich.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AccountServiceImpl extends BaseDaoServiceImpl implements AccountService {

 

	private static final Log log = LogFactory.getLog(AccountServiceImpl.class);



		   
		@Override
		public Long insert(Account account)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + account);

		if (account == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		account.setCreateAt(currentTimeMillis);
		account.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(account);
		} catch (DaoException e) {
			log.error(" insert wrong : " + account);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Account> insertList(List<Account> accountList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (accountList == null ? "null" : accountList.size()));
      
		List<Account> resultList = null;

		if (CollectionUtils.isEmpty(accountList)) {
			return new ArrayList<Account>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Account account : accountList) {
			account.setCreateAt(currentTimeMillis);
			account.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Account>) dao.batchSave(accountList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + accountList);
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
			result = dao.delete(Account.class, id);
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
		public boolean update(Account account)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (account == null ? "null" : account.getId()));

		boolean result = false;

		if (account == null) {
			return true;
		}

		account.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(account);
		} catch (DaoException e) {
			log.error(" update wrong : " + account);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + account);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Account> accountList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (accountList == null ? "null" : accountList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(accountList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Account account : accountList) {
			account.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(accountList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + accountList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + accountList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Account getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Account account = null;

		if (id == null) {
			return account;
		}

		try {
			account = (Account) dao.get(Account.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return account;		
		}	
		  
    	   
		@Override
		public List<Account> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Account> account = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Account>();
		}

		try {
			account = (List<Account>) dao.getList(Account.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (account == null ? "null" : account.size()));
    
		return account;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAccountIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAccountIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAccountIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAccountIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAccountIds " ) ;
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

