package com.ptteng.academy.rich.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.model.Role;
import com.ptteng.academy.rich.model.RoleModule;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.service.RoleModuleService;
import com.ptteng.academy.rich.service.RoleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.qding.common.util.DataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
* @Description:    后台账户登录
* @Author:         zhh
* @CreateDate:     2018/11/23 15:05
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/23 15:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class AccountLoginController {
    private static final Logger log =  LoggerFactory.getLogger(AccountLoginController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private RoleModuleService roleModuleService;


    /**
    * @Description:    后台登录
    * @Author:         zhh
    * @CreateDate:     2018/11/23 15:15
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/23 15:15
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping(value = "/a/login",method = RequestMethod.POST)
    public String doLogin(ModelMap model, String name, String password) throws ServiceException, ServiceDaoException {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        log.info("information checking");

        if(DataUtils.isNullOrEmpty(name) || DataUtils.isNullOrEmpty(password)){
            log.info("param is empty");
            model.addAttribute("code",-200000);
            return "/academy-rich-admin-service/data/json";
        }
        try{
            //登录验证身份
            subject.login(token);
            log.info("<====login success ====>");
            //获取账户和角色信息
            Map<String,Object> map = DynamicSqlUtil.getAccountByName(name);
            List<Long> accountIds = accountService.getIdsByDynamicCondition(Account.class,map,0,Integer.MAX_VALUE);
            List<Account> accountList = accountService.getObjectsByIds(accountIds);
            Account account = accountList.get(0);
            log.info("account"+account);
            Role role = roleService.getObjectById(account.getRoleId());

            //根据角色id获取模块id
            Map<String,Object> param = DynamicSqlUtil.getModuleIdsByRoleId(role.getId());
            List<Long> ModuleIds =roleModuleService.getIdsByDynamicCondition(RoleModule.class,param,0,Integer.MAX_VALUE);
            log.info("modules:"+ModuleIds);
            //根据roleModule中的moduleId获取模块
            List<Module> moduleList = moduleService.getObjectsByIds(ModuleIds);

            //登录成功后将账户信息放入session中
            Session session = subject.getSession();
            session.setAttribute("accountId",account.getId());
            session.setAttribute("subject",subject);
            model.addAttribute("code",0);
            model.addAttribute("role",role);
            model.addAttribute("account",account);
            model.addAttribute("moduleList",moduleList);
        }catch (AuthenticationException e){
            model.addAttribute("code",-8001);
            return "/academy-rich-admin-service/data/json";
        }
        return "/academy-rich-admin-service/data/loginSuccess";
    }


    /**
    * @Description:    无权限访问
    * @Author:         zhh
    * @CreateDate:     2018/11/26 2:04
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 2:04
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping(value = "/a/unauthorized",method = RequestMethod.GET)
    public String noPerms(ModelMap model){
        model.addAttribute("code",-8007);
        return "/academy-rich-admin-service/data/error";
    }

}
