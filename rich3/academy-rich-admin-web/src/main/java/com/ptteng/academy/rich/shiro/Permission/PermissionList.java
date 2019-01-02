package com.ptteng.academy.rich.shiro.Permission;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.model.Role;
import com.ptteng.academy.rich.model.RoleModule;
import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.service.RoleModuleService;
import com.ptteng.academy.rich.service.RoleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @Description:    shiro中的权限维护
* @Author:         zhh
* @CreateDate:     2018/11/26 0:46
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 0:46
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Component
public class PermissionList {
    private static final Log log = LogFactory.getLog(PermissionList.class);

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleModuleService roleModuleService;

    public static PermissionList permissionList;

    @PostConstruct
    public void init(){
        permissionList = this;
        permissionList.moduleService = this.moduleService;
        permissionList.roleService = this.roleService;
        permissionList.roleModuleService = this.roleModuleService;
    }



    /**
    * @Description:    获取所有权限列表
    * @Author:         zhh
    * @CreateDate:     2018/11/26 0:29
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 0:29
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    public  List<Module> list() throws ServiceException, ServiceDaoException {
        Module module = permissionList.moduleService.getObjectById(4L);
        log.info("module"+module);
        List<Long> moduleIds = permissionList.moduleService.getModuleIds(0,Integer.MAX_VALUE);
        log.info("moduleIds"+moduleIds);
        List<Module> moduleList = permissionList.moduleService.getObjectsByIds(moduleIds);
        return moduleList;
    }

    public boolean needInterceptor(String requestURI) throws ServiceException, ServiceDaoException {
        List<Module> moduleList = list();
        for(Module module:moduleList){
            if(module.getUrl().equals(requestURI))
                return true;
        }
        return false;
    }

    public Set<String> listPermissionURLs(String accountName) throws ServiceException, ServiceDaoException {
        Set<String> result = new HashSet<>();
        //获取账户角色
        Map<String,Object> map = DynamicSqlUtil.getRoleIdByName(accountName);
        List<Long> roleIds = permissionList.roleService.getIdsByDynamicCondition(Role.class,map,0,Integer.MAX_VALUE);
        List<Role> roles = permissionList.roleService.getObjectsByIds(roleIds);
        log.info("roles"+roles);

        //获取roleModule列表
        Map<String,Object> map1 = DynamicSqlUtil.getRoleModuleIdsByRoleId(roles.get(0).getId());
        List<Long> roleModuleIds =  permissionList.roleModuleService.getIdsByDynamicCondition(RoleModule.class,map1,0,Integer.MAX_VALUE);
        log.info("roleModuleIds"+roleModuleIds);
        List<RoleModule> roleModuleList = permissionList.roleModuleService.getObjectsByIds(roleModuleIds);

        //获取角色下对应的module集合
        for(RoleModule roleModule:roleModuleList){
            Module module =permissionList.moduleService.getObjectById(roleModule.getModuleId());
            log.info(module);
            result.add(module.getUrl());
        }
        return result;
    }
}
