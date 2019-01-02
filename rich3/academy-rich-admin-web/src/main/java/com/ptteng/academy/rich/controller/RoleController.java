package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.model.Role;
import com.ptteng.academy.rich.model.RoleModule;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.service.RoleModuleService;
import com.ptteng.academy.rich.service.RoleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.ptteng.academy.rich.utils.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    角色模块
* @Author:         zhh
* @CreateDate:     2018/11/25 12:47
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/25 12:47
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class RoleController {
	private static final Log log = LogFactory.getLog(RoleController.class);

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleModuleService roleModuleService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private AccountService accountService;



	/**
	* @Description:   获取角色列表
	* @Author:         zhh
	* @CreateDate:     2018/11/25 12:53
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 12:53
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/role/list", method = RequestMethod.GET)
	public String getRoleList(ModelMap model, Integer pageNow ,Integer pageSize) throws Exception {

		log.info("get role list");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");

		Integer size = pageMap.get("size");
		Integer page = pageMap.get("page");

		List<Long> roleIds = null;
		List<Role> roleList;
		Integer total;

		List<Long> createByIds = new ArrayList<>();
		List<Long> updateByIds = new ArrayList<>();
		List<Account> createByList;
		List<Account> updateByList;

		Map<Long, String> createByMap=new HashMap<>();
		Map<Long, String> updateByMap=new HashMap<>();

		try {
			//获取所有角色列表
			Map<String,Object> map=DynamicSqlUtil.getRoles();

			roleIds = roleService.getIdsByDynamicCondition(Role.class,map,0,Integer.MAX_VALUE);
			log.info("the role idList size is {}"+ roleIds.size());
			roleList = roleService.getObjectsByIds(roleIds);

			//获取角色创建人和更新人id
			for (Role role : roleList) {
				createByIds.add(role.getCreateBy());
				updateByIds.add(role.getUpdateBy());
			}

			//获取创建者列表和更新者列表
			createByList = accountService.getObjectsByIds(createByIds);
			updateByList = accountService.getObjectsByIds(updateByIds);

			for (Account account: createByList) {
				createByMap.put(account.getId(), account.getName());
			}

			for (Account account : updateByList) {
				updateByMap.put(account.getId(), account.getName());
			}

			total = roleService.countRoleIds();


			model.addAttribute("code", 0);
			model.addAttribute("total",total);
			model.addAttribute("page",page);
			model.addAttribute("size",size);
			model.addAttribute("roleList", roleList);
			model.addAttribute("updateBy", updateByMap);
			model.addAttribute("createBy", createByMap);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get role error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/role/json/roleListJson";
	}



	/**
	 * @Description:    查看角色详情
	 * @Author:         zhh
	 * @CreateDate:     2018/11/25 14:25
	 * @UpdateUser:     zhh
	 * @UpdateDate:     2018/11/25 14:25
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.GET)
	public String getRole(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("get data : id= " + id);
		try {
			Role role = roleService.getObjectById(id);
			log.info("get role data is " + role);

			//使用角色id查询相应权限
			Map<String,Object> map=DynamicSqlUtil.getModuleIdsByRoleId(role.getId());
			log.info("map"+map);
			List<Long> moduleIds = roleModuleService.getIdsByDynamicCondition(RoleModule.class,map,0,Integer.MAX_VALUE);
			log.info("moduleIds"+moduleIds);
			List<Module> moduleList= moduleService.getObjectsByIds(moduleIds);

			model.addAttribute("code", 0);
			model.addAttribute("moduleList",moduleList);
			model.addAttribute("role", role);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get role error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/role/json/roleDetailJson";
	}

	/**
	* @Description:    修改角色
	* @Author:         zhh
	* @CreateDate:     2018/11/25 14:51
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 14:51
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/role", method = RequestMethod.PUT)
	public String updateRole(HttpServletRequest request, ModelMap model,@RequestParam("moduleList")Long[] moduleList, @RequestBody Role role) throws Exception {
		
		log.info("update role : role= " + role);
		List<RoleModule> roleModuleList=new ArrayList<>();
		try {
			Map<String,Object> map=DynamicSqlUtil.getRoleIdByRoleName(role.getName());
			log.info("map"+map);
			List<Long> roleIds = roleService.getIdsByDynamicCondition(Role.class,map,0,Integer.MAX_VALUE);
			List<Role> roleList = roleService.getObjectsByIds(roleIds);
			if(roleList.size()!=0){
				model.addAttribute("code", -9002);
				log.warn("the role name already exists");
				return "/academy-rich-admin-service/data/json";
			}

			Long accountId = (Long) request.getSession().getAttribute("accountId");
			//移除原本所有的权限关联
			Map<String,Object> param = DynamicSqlUtil.getRoleModuleIdsByRoleId(role.getId());

			List<Long> roleModuleIds = roleModuleService.getIdsByDynamicCondition(RoleModule.class,param,0,Integer.MAX_VALUE);
			log.info("roleModuleIds:"+roleModuleIds);
			roleModuleService.deleteList(RoleModule.class,roleModuleIds);
			log.info("delete old modules success");


			//将前端传过来的权限与角色id建立关联
			for(Long moduleId:moduleList){
				RoleModule roleModule = new RoleModule();
				roleModule.setRoleId(role.getId());
				roleModule.setModuleId(moduleId);
				roleModuleList.add(roleModule);
			}
			roleModuleService.insertList(roleModuleList);
			log.info("insert roleModule success");
			role.setUpdateBy(accountId);
			roleService.update(role);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update role error,id is  " + role.getId());
			model.addAttribute("code", -100000);

		}
		return "/academy-rich-admin-service/data/json";
	}


	/**
	* @Description:    新增角色
	* @Author:         zhh
	* @CreateDate:     2018/11/25 13:25
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 13:25
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/role", method = RequestMethod.POST)
	public String addRole(ModelMap model, @RequestBody Role role,@RequestParam("moduleList")Long[] moduleList, HttpServletRequest request) throws Exception {

		log.info("add role : roleName= " + role.getName());
		for (Long moduleId : moduleList) {
			log.info("输入module id 为:{}" + moduleId);
		}
		List<RoleModule> roleModuleList = new ArrayList<>();
		try {
			//参数校验
			if (DataUtils.isNullOrEmpty(role.getName()) || DataUtils.isNullOrEmpty(moduleList)) {
				log.warn("role request parameter error.");
				model.addAttribute("code", -200000);
				return "/academy-rich-admin-service/data/json";
			}
			//校验角色id对应角色是否存在
			Map<String,Object> map=DynamicSqlUtil.getRoleIdByRoleName(role.getName());
			List<Long> roleIds = roleService.getIdsByDynamicCondition(Role.class,map,0,Integer.MAX_VALUE);
			if(roleIds.size()!=0){
				log.warn("Role does not exist");
				model.addAttribute("code", -9001);
				return "/academy-rich-admin-service/data/json";
			}
			Long accountId = (Long) request.getSession().getAttribute("accountId");
			role.setCreateBy(accountId);
			role.setUpdateBy(accountId);
			role.setId(null);

			Long insertId=roleService.insert(role);

			//授予角色相应的权限
			for(Long moduleId : moduleList){
				RoleModule roleModule=new RoleModule();
				roleModule.setRoleId(insertId);
				roleModule.setModuleId(moduleId);
				roleModuleList.add(roleModule);
			}
			roleModuleService.insertList(roleModuleList);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add role error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/data/json";
	}


	/**
	* @Description:    删除角色
	* @Author:         zhh
	* @CreateDate:     2018/11/25 15:36
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 15:36
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/role/{id}", method = RequestMethod.DELETE)
	public String deleteRole( ModelMap model, @PathVariable Long id) throws Exception {

		log.info("delete role : id= " + id);

		try {

			roleService.delete(id);
			Map<String,Object> map=DynamicSqlUtil.getModuleIdsByRoleId(id);
			log.info("map:"+map);
			List<Long> moduleIds=roleModuleService.getIdsByDynamicCondition(RoleModule.class,map,0,Integer.MAX_VALUE);
			log.info("moduleIds:"+moduleIds);
			roleModuleService.deleteList(RoleModule.class,moduleIds);

			log.info("delete role success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete role error,id is  " + id);
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-admin-service/data/json";
	}
	
}

