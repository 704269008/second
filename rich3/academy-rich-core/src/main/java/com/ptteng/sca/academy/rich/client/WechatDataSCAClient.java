/**
 * 
 */
package com.ptteng.sca.academy.rich.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.WechatData;
import com.ptteng.academy.rich.service.WechatDataService;

import java.util.List;
import java.util.Map;

public class WechatDataSCAClient implements WechatDataService {

    private WechatDataService wechatDataService;

	public WechatDataService getWechatDataService() {
		return wechatDataService;
	}
	
	
	public void setWechatDataService(WechatDataService wechatDataService) {
		this.wechatDataService =wechatDataService;
	}
	
	
			   
		@Override
		public Long insert(WechatData wechatData)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.insert(wechatData);
		          
		
		}	
		  
    	   
		@Override
		public List<WechatData> insertList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.insertList(wechatDataList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(WechatData wechatData)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.update(wechatData);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<WechatData> wechatDataList)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.updateList(wechatDataList);
		          
		
		}	
		  
    	   
		@Override
		public WechatData getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<WechatData> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return wechatDataService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getWechatDataIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return wechatDataService.getWechatDataIds(start, limit);
	}

	@Override
	public Integer countWechatDataIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return wechatDataService.countWechatDataIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return wechatDataService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return wechatDataService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   wechatDataService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.wechatDataService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

