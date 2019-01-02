/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoUpvote;
import com.ptteng.academy.rich.service.UserVideoUpvoteService;

import java.util.List;
import java.util.Map;

public class UserVideoUpvoteSCAClient implements UserVideoUpvoteService {

    private UserVideoUpvoteService userVideoUpvoteService;

	public UserVideoUpvoteService getUserVideoUpvoteService() {
		return userVideoUpvoteService;
	}
	
	
	public void setUserVideoUpvoteService(UserVideoUpvoteService userVideoUpvoteService) {
		this.userVideoUpvoteService =userVideoUpvoteService;
	}
	
	
			   
		@Override
		public Long insert(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.insert(userVideoUpvote);
		          
		
		}	
		  
    	   
		@Override
		public List<UserVideoUpvote> insertList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.insertList(userVideoUpvoteList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserVideoUpvote userVideoUpvote)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.update(userVideoUpvote);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserVideoUpvote> userVideoUpvoteList)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.updateList(userVideoUpvoteList);
		          
		
		}	
		  
    	   
		@Override
		public UserVideoUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserVideoUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userVideoUpvoteService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getUserVideoUpvoteIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoUpvoteService.getUserVideoUpvoteIds(start, limit);
	}

	@Override
	public Integer countUserVideoUpvoteIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoUpvoteService.countUserVideoUpvoteIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoUpvoteService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoUpvoteService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userVideoUpvoteService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userVideoUpvoteService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

