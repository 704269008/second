package com.ptteng.academy.rich.shiro.realm;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.controller.AccountLoginController;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.model.Role;
import com.ptteng.academy.rich.model.RoleModule;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.service.RoleModuleService;
import com.ptteng.academy.rich.service.RoleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* @Description:    shiro核心---Realm
* @Author:         zhh
* @CreateDate:     2018/11/23 16:10
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/23 16:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class DatabaseRealm extends AuthorizingRealm {
    private static final Logger log =  LoggerFactory.getLogger(AccountLoginController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleModuleService roleModuleService;

    @Autowired
    private ModuleService moduleService;


    //为账户授予角色以及角色对应下的权限，（从数据库中读取账户角色和权限）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //首先进入这里，表示已经通过验证了。
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        //给账户授予角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> modules = new HashSet<>();
        Set<String> roles = new HashSet<>();
        try {
            //根据账户id获取角色
            Role role = roleService.getObjectById(account.getRoleId());
            log.info("roleId:"+role.getId().toString());
            //授予账户角色
            roles.add(role.getId().toString());
            //根据角色id获取模块id
            Map<String,Object> map = DynamicSqlUtil.getModuleIdsByRoleId(role.getId());
            List<Long> ModuleIds =roleModuleService.getIdsByDynamicCondition(RoleModule.class,map,0,Integer.MAX_VALUE);
            //根据roleModule中的moduleId获取模块
            List<Module> moduleList = moduleService.getObjectsByIds(ModuleIds);
            log.info("getModuleList: "+moduleList);
            for(int i=0;i<moduleList.size();i++){
                //授予账户权限
                log.info("moduleId:"+moduleList.get(i).getId().toString());
                modules.add(moduleList.get(i).getId().toString());
            }
            authorizationInfo.setRoles(roles);
            authorizationInfo.setStringPermissions(modules);
            return authorizationInfo;

      } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServiceDaoException e) {
            e.printStackTrace();
        }
        return null;
    }


    //账户名和密码验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取账户和密码组成的token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //获取账户登录名
        String accountName = token.getPrincipal().toString();

        try {
            Map<String,Object> map = DynamicSqlUtil.getAccountByName(accountName);
            log.info("params:"+ map);
            //动态查询，返回账户ID
            List<Long> accountIds = accountService.getIdsByDynamicCondition(Account.class,map,0,Integer.MAX_VALUE);
            log.info("accountIds"+accountIds);
            if(accountIds.size()==0){
                log.info("accountName is not exist");
                return null;
            }
            List<Account> accountList = accountService.getObjectsByIds(accountIds);
            //获取数据库中该账户名的所有信息
            Account account = accountList.get(0);
            log.info("get account data success is"+account);

            //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(accountName,account.getPassword(),
                    ByteSource.Util.bytes(account.getSalt()),getName());

            return simpleAuthenticationInfo;

        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServiceDaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
