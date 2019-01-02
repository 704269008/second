/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserArticleCollect;
import com.ptteng.academy.rich.service.UserArticleCollectService;

import java.util.List;
import java.util.Map;

public class UserArticleCollectSCAClient implements UserArticleCollectService {

    private UserArticleCollectService userArticleCollectService;

	public UserArticleCollectService getUserArticleCollectService() {
		return userArticleCollectService;
	}
	
	
	public void setUserArticleCollectService(UserArticleCollectService userArticleCollectService) {
		this.userArticleCollectService =userArticleCollectService;
	}
	
	
			   
		@Override
		public Long insert(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.insert(userArticleCollect);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticleCollect> insertList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.insertList(userArticleCollectList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserArticleCollect userArticleCollect)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.update(userArticleCollect);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserArticleCollect> userArticleCollectList)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.updateList(userArticleCollectList);
		          
		
		}	
		  
    	   
		@Override
		public UserArticleCollect getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserArticleCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userArticleCollectService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getUserArticleCollectIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleCollectService.getUserArticleCollectIds(start, limit);
	}

	@Override
	public Integer countUserArticleCollectIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleCollectService.countUserArticleCollectIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleCollectService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userArticleCollectService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userArticleCollectService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userArticleCollectService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

