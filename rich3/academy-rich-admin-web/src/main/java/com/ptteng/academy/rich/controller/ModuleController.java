package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Account;
import com.ptteng.academy.rich.model.Module;
import com.ptteng.academy.rich.service.AccountService;
import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.ptteng.academy.rich.utils.PageUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    模块管理
* @Author:         zhh
* @CreateDate:     2018/11/25 15:54
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/25 15:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class ModuleController {
	private static final Log log = LogFactory.getLog(ModuleController.class);

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private AccountService accountService;


	/**
	* @Description:    模块列表
	* @Author:         zhh
	* @CreateDate:     2018/11/25 15:59
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 15:59
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/module/list", method = RequestMethod.GET)
	public String getModuleList(ModelMap model,Integer pageNow,Integer pageSize) throws Exception {

		log.info("get module list");
		//获取开始记录数和每页记录数。
		Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

		Integer start = pageMap.get("start");

		Integer size = pageMap.get("size");
		Integer page = pageMap.get("page");

		List<Long> moduleIds = null;
		List<Module> moduleList;

		List<Long> createByIds = new ArrayList<>();
		List<Long> updateByIds = new ArrayList<>();
		List<Account> createByList;
		List<Account> updateByList;

		Map<Long, String> createByMap=new HashMap<>();
		Map<Long, String> updateByMap=new HashMap<>();


		try {
			Map<String,Object> map = DynamicSqlUtil.getModules();
			moduleIds=moduleService.getIdsByDynamicCondition(Module.class,map,0,Integer.MAX_VALUE);
			log.info("the moduleIds is {}"+ moduleIds);
			moduleList = moduleService.getObjectsByIds(moduleIds);

			log.info("get  module data is " + moduleList);
			Integer total = moduleService.countModuleIds();
			log.info("the moduleIds total is {}"+ total);

			for (Module module : moduleList) {
				createByIds.add(module.getCreateBy());
				updateByIds.add(module.getUpdateBy());
			}

			createByList = accountService.getObjectsByIds(createByIds);
			updateByList = accountService.getObjectsByIds(updateByIds);

			for (Account account : createByList) {
				createByMap.put(account.getId(), account.getName());
			}

			for (Account account : updateByList) {
				updateByMap.put(account.getId(), account.getName());
			}


			model.addAttribute("code", 0);
			model.addAttribute("total",total);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			model.addAttribute("updateBy", updateByMap);
			model.addAttribute("createBy", createByMap);
			model.addAttribute("moduleList", moduleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get module error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/module/json/moduleListJson";
	}
	

	/**
	* @Description:    查看模块详情
	* @Author:         zhh
	* @CreateDate:     2018/11/25 16:17
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 16:17
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.GET)
	public String getModule(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("get data : id= " + id);
		try {
			Module module = moduleService.getObjectById(id);
			log.info("get module data is " + module);

			model.addAttribute("code", 0);

			model.addAttribute("module", module);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get module error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/module/json/moduleDetailJson";
	}

	/**
	* @Description:    修改模块信息
	* @Author:         zhh
	* @CreateDate:     2018/11/25 16:21
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 16:21
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/module", method = RequestMethod.PUT)
	public String updateModule(HttpServletRequest request,ModelMap model,@RequestBody Module module) throws Exception {
		
		log.info("update module : module= " + module);
		Long accountId = (Long) request.getSession().getAttribute("accountId");
		try {
			//验证相同模块名是否存在
			if (DataUtils.isNotNullOrEmpty(module.getName())) {
				Module module1 = moduleService.getObjectById(module.getId());
				if (module1.getName().equals(module.getName())) {
					log.warn("The same module name already exists.");
					model.addAttribute("code", -7003);
					return "/academy-rich-admin-service/data/json";
				}
			}
			module.setUpdateBy(accountId);
			moduleService.update(module);
			log.info("update module success");

			model.addAttribute("code", 0);

			model.addAttribute("module", module);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update module error,id is  " + module.getId());
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-admin-service/data/json";
	}


	/**
	* @Description:    增加模块
	* @Author:         zhh
	* @CreateDate:     2018/11/25 16:49
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 16:49
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
	public String addModule(HttpServletRequest request,ModelMap model, @RequestBody Module module) throws Exception {
		
		log.info("add module : module= " + module);
		Long accountId = (Long) request.getSession().getAttribute("accountId");
		try {

			//参数校验
			if (DataUtils.isNullOrEmpty(module.getParentId())
					|| DataUtils.isNullOrEmpty(module.getName())) {
				log.warn("module request parameter error");
				model.addAttribute("code", -200000);
				return "/academy-rich-admin-service/data/json";
			}
			//验证相同模块名是否存在
			if (DataUtils.isNotNullOrEmpty(module.getName())) {
				Map<String,Object> map = DynamicSqlUtil.getModuleIdByModuleName(module.getName());
				log.info("map"+map);
				List<Long> modules = moduleService.getIdsByDynamicCondition(Module.class,map,0,Integer.MAX_VALUE);
				if(modules.size()!=0) {
					log.warn("The same module name already exists");
					model.addAttribute("code", -7003);
					return "/academy-rich-admin-service/data/json";
				}
			}

			module.setId(null);
			module.setCreateBy(accountId);
			module.setUpdateBy(accountId);

			moduleService.insert(module);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add module error ");
			model.addAttribute("code", -100000);
		}

		return  "/academy-rich-admin-service/data/json";
	}

	/**
	* @Description:    删除模块
	* @Author:         zhh
	* @CreateDate:     2018/11/25 16:56
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/25 16:56
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.DELETE)
	public String deleteModule(ModelMap model, @PathVariable Long id) throws Exception {

		log.info("delete module : id= " + id);
		try {
			moduleService.delete(id);

			log.info("delete module success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete module error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/academy-rich-admin-service/data/json";
	}

}

