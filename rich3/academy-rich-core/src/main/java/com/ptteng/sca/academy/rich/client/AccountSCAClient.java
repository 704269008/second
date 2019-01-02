/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.service.AccountService;

import java.util.List;
import java.util.Map;

public class AccountSCAClient implements AccountService {

    private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}
	
	
	public void setAccountService(AccountService accountService) {
		this.accountService =accountService;
	}
	
	
			   
		@Override
		public Long insert(Account account)throws ServiceException, ServiceDaoException{
		
		return accountService.insert(account);
		          
		
		}	
		  
    	   
		@Override
		public List<Account> insertList(List<Account> accountList)throws ServiceException, ServiceDaoException{
		
		return accountService.insertList(accountList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return accountService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Account account)throws ServiceException, ServiceDaoException{
		
		return accountService.update(account);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Account> accountList)throws ServiceException, ServiceDaoException{
		
		return accountService.updateList(accountList);
		          
		
		}	
		  
    	   
		@Override
		public Account getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return accountService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Account> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return accountService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAccountIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return accountService.getAccountIds(start, limit);
	}

	@Override
	public Integer countAccountIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return accountService.countAccountIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return accountService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return accountService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   accountService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.accountService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

