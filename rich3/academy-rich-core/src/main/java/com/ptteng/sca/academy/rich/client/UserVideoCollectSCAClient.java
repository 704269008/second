/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.UserVideoCollect;
import com.ptteng.academy.rich.service.UserVideoCollectService;

import java.util.List;
import java.util.Map;

public class UserVideoCollectSCAClient implements UserVideoCollectService {

    private UserVideoCollectService userVideoCollectService;

	public UserVideoCollectService getUserVideoCollectService() {
		return userVideoCollectService;
	}
	
	
	public void setUserVideoCollectService(UserVideoCollectService userVideoCollectService) {
		this.userVideoCollectService =userVideoCollectService;
	}
	
	
			   
		@Override
		public Long insert(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.insert(userVideoCollect);
		          
		
		}	
		  
    	   
		@Override
		public List<UserVideoCollect> insertList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.insertList(userVideoCollectList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserVideoCollect userVideoCollect)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.update(userVideoCollect);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserVideoCollect> userVideoCollectList)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.updateList(userVideoCollectList);
		          
		
		}	
		  
    	   
		@Override
		public UserVideoCollect getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserVideoCollect> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userVideoCollectService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getUserVideoCollectIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoCollectService.getUserVideoCollectIds(start, limit);
	}

	@Override
	public Integer countUserVideoCollectIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoCollectService.countUserVideoCollectIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoCollectService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userVideoCollectService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userVideoCollectService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userVideoCollectService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

