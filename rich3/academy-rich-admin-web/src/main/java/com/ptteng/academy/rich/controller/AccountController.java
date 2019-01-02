package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.model.Role;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.academy.rich.service.RoleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.ptteng.academy.rich.utils.MD5Util;
import com.ptteng.academy.rich.utils.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @Description:    账户模块
* @Author:         zhh
* @CreateDate:     2018/11/24 21:54
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/24 21:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class AccountController {
	private static final Log log = LogFactory.getLog(AccountController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private RoleService roleService;

	/**
	* @Description:    获取账户列表 动态查询
	* @Author:         zhh
	* @CreateDate:     2018/11/24 21:57
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/24 21:57
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/account/list", method = RequestMethod.GET)
	public String getAccountList(ModelMap model, Long roleId,String accountName,Integer pageNow ,Integer pageSize) throws Exception {

		log.info("get account list begin");

		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");

		Integer size = pageMap.get("size");
		Integer page = pageMap.get("page");
		List<Long> roleIds = new ArrayList<>();
		List<Long> createByIds = new ArrayList<>();
		List<Long> updateByIds = new ArrayList<>();

		List<Role> roleList;
		List<Account> createByList;
		List<Account> updateByList;

		Map<Long, Role> roleMap = new HashMap<>();
		Map<Long, String> createByMap=new HashMap<>();
		Map<Long, String> updateByMap=new HashMap<>();
		try {

			Map<String,Object> params = DynamicSqlUtil.accountDynamicSql(roleId,accountName);
			log.info("params"+params);
			List<Long> totalAccountIds = accountService.getIdsByDynamicCondition(Account.class,params,0,Integer.MAX_VALUE);
			if(totalAccountIds==null){
				log.info("account is not exist");
				model.addAttribute("code", -8002);
				return "/academy-rich-admin-service/data/json";
			}
			//获取一页的记录
			List<Long> accountIds = accountService.getIdsByDynamicCondition(Account.class,params,start,size);
			List<Account> accountList = accountService.getObjectsByIds(accountIds);
			log.info("get  account data is " + accountList);

			//将id转换成相应的所需名称
			for(Account account:accountList){
				roleIds.add(account.getRoleId());
				createByIds.add(account.getCreateBy());
				updateByIds.add(account.getUpdateBy());
			}
			//获取对应角色名
			roleList = roleService.getObjectsByIds(roleIds);
			for (Role role : roleList) {
				roleMap.put(role.getId(), role);
			}

			//获取创建/更新者名字
			createByList = accountService.getObjectsByIds(createByIds);
			updateByList = accountService.getObjectsByIds(updateByIds);

			for (Account account : createByList) {
				createByMap.put(account.getId(), account.getName());
			}

			for (Account account : updateByList) {
				updateByMap.put(account.getId(), account.getName());
			}
			model.addAttribute("code", 0);
			model.addAttribute("total",totalAccountIds.size());
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("accountList", accountList);
			model.addAttribute("roleMap", roleMap);
			model.addAttribute("updateBy", updateByMap);
			model.addAttribute("createBy", createByMap);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get account error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/account/json/accountListJson";
	}



	/**
	* @Description:    新增账户
	* @Author:         zhh
	* @CreateDate:     2018/11/24 23:23
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/24 23:23
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/account", method = RequestMethod.POST)
	public String addAccount(ModelMap model, @RequestBody Account account ,HttpServletRequest request) throws Exception {

		log.info("add account : account= " + account);
		//参数校验
		if (DataUtils.isNullOrEmpty(account.getName())
				|| DataUtils.isNullOrEmpty(account.getPassword())
				|| DataUtils.isNullOrEmpty(account.getRoleId())) {
			log.warn("account request parameter error.");
			model.addAttribute("code", -8003);
			return "/academy-rich-admin-service/data/json";
		}
		Long accountId = (Long) request.getSession().getAttribute("accountId");

		try {
			Map<String,Object> map = DynamicSqlUtil.getAccountByName(account.getName());
			List<Long> totalAccountIds = accountService.getIdsByDynamicCondition(Account.class,map,0,Integer.MAX_VALUE);
			//检查用户名是否已存在
			if(totalAccountIds.size()!=0){
				log.info("account is already exist");
				model.addAttribute("code", -8004);
				return "/academy-rich-admin-service/data/json";
			}

			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			String encodedPassword = MD5Util.md5Encrypt(account.getPassword(),salt);

			account.setId(null);
			account.setPassword(encodedPassword);
			account.setSalt(salt);
			account.setCreateBy(accountId);
			account.setUpdateBy(accountId);
			accountService.insert(account);
			log.info("add account success");

			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("add account error ");
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}


	/**
	* @Description:    查看账户信息
	* @Author:         zhh
	* @CreateDate:     2018/11/25 10:51
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 10:51
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/account/{id}", method = RequestMethod.GET)
	public String getAccount(ModelMap model,@PathVariable Long id) {
		if(DataUtils.isNullOrEmpty(id)){
			model.addAttribute("code", -200000);
			return "/academy-rich-admin-service/data/json";
		}
		try{
			Account account=accountService.getObjectById(id);
			String roleName = roleService.getObjectById(account.getRoleId()).getName();
			log.info("角色名:"+roleName);
			model.addAttribute("roleName",roleName);
			model.addAttribute("account",account);
			model.addAttribute("code", 0);
		}catch (Throwable t){
			t.printStackTrace();
			model.addAttribute("code", -100000);
			return "/academy-rich-admin-service/data/json";
		}
		return "/academy-rich-admin-service/account/json/accountDetailJson";
	}


	/**
	* @Description:    修改账户信息
	* @Author:         zhh
	* @CreateDate:     2018/11/25 10:23
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 10:23
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/account", method = RequestMethod.PUT)
	public String updateAccount(ModelMap model,@RequestBody Account account,HttpServletRequest request)throws Exception {

		log.info("update account : account= " + account);
		//参数校验
		if (DataUtils.isNullOrEmpty(account.getName())
				|| DataUtils.isNullOrEmpty(account.getPassword())
				|| DataUtils.isNullOrEmpty(account.getRoleId())) {
			log.warn("account request parameter error.");
			model.addAttribute("code", -8003);
			return "/academy-rich-admin-service/data/json";
		}
		HttpSession session=request.getSession();
		Long accountId = (Long) session.getAttribute("accountId");
		try{
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
			Account account1 = accountService.getObjectById(account.getId());
			account1.setSalt(salt);
			if(account.getName().equals(account1.getName())){
				log.warn("the username has been registered. ");
				model.addAttribute("code", -8004);
				return "/academy-rich-admin-service/data/json";
			}
			account1.setName(account.getName());
			account1.setPassword(MD5Util.md5Encrypt(account.getPassword(),salt));
			account1.setRoleId(account.getRoleId());
			account1.setUpdateBy(accountId);
			accountService.update(account1);
			log.info("update account success");
			model.addAttribute("code", 0);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("update account error ");
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}



	/**
	* @Description:    修改账户密码
	* @Author:         zhh
	* @CreateDate:     2018/11/25 9:39
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 9:39
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/password", method = RequestMethod.PUT)
	public String updateAccountPassword(ModelMap model, String accountName, String oldPassword, String newPassword, HttpServletRequest request) throws Exception {
		
		log.info("update account begin ");

		if(DataUtils.isNullOrEmpty(oldPassword)||DataUtils.isNullOrEmpty(newPassword)){
			model.addAttribute("code",-200000);
			return "/academy-rich-admin-service/data/json";
		}

		try {
			Map<String,Object> map = DynamicSqlUtil.getAccountByName(accountName);
			List<Long> totalAccountIds = accountService.getIdsByDynamicCondition(Account.class,map,0,Integer.MAX_VALUE);
			Account account=accountService.getObjectById(totalAccountIds.get(0));

			//判断原始密码是否正确
			String encodedPassword = MD5Util.md5Encrypt(oldPassword,account.getSalt());
			String salt = new SecureRandomNumberGenerator().nextBytes().toString();

			HttpSession session=request.getSession();
			Long accountId = (Long) session.getAttribute("accountId");
			if(encodedPassword.equals(account.getPassword())){
				account.setPassword(MD5Util.md5Encrypt(newPassword,salt));
				account.setUpdateBy(accountId);
				account.setSalt(salt);
				accountService.update(account);
				log.info("update account password is success");
			}else{
				model.addAttribute("code", -8005);
				return "/academy-rich-admin-service/data/json";
			}

			model.addAttribute("code", 0);
			model.addAttribute("account", account);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update account password error");
			model.addAttribute("code", -8006);
		}
		return "/academy-rich-admin-service/data/json";
	}



	/**
	* @Description:    删除账户
	* @Author:         zhh
	* @CreateDate:     2018/11/25 11:50
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 11:50
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/account/{id}", method = RequestMethod.DELETE)
	public String deleteAccount(ModelMap model, @PathVariable Long id,HttpServletRequest request) throws Exception {

		log.info("delete account : id= " + id);
		try {
			accountService.delete(id);
			log.info("delete account success");
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete account error,id is  " + id);
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}
	
	

	
	
	
	
	
}

