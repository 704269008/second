/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleUpvote;
import com.ptteng.academy.rich.service.UserArticleUpvoteService;

import java.util.List;
import java.util.Map;

public class UserArticleUpvoteSCAClient implements UserArticleUpvoteService {

    private UserArticleUpvoteService userArticleUpvoteService;

	public UserArticleUpvoteService getUserArticleUpvoteService() {
		return userArticleUpvoteService;
	}
	
	
	public void setUserArticleUpvoteService(UserArticleUpvoteService userArticleUpvoteService) {
		this.userArticleUpvoteService =userArticleUpvoteService;
	}
	
	
			   
		@Override
		public Long insert(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.insert(userArticleUpvote);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticleUpvote> insertList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.insertList(userArticleUpvoteList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserArticleUpvote userArticleUpvote)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.update(userArticleUpvote);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticleUpvote> userArticleUpvoteList)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.updateList(userArticleUpvoteList);
		          
		
		}	
		  
    	   
		@Override
		public UserArticleUpvote getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticleUpvote> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userArticleUpvoteService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getUserArticleUpvoteIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleUpvoteService.getUserArticleUpvoteIds(start, limit);
	}

	@Override
	public Integer countUserArticleUpvoteIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleUpvoteService.countUserArticleUpvoteIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleUpvoteService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleUpvoteService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userArticleUpvoteService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userArticleUpvoteService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

