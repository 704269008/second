package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.Teacher;
import com.ptteng.academy.rich.service.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
* @Description:    老师信息新增和删除
* @Author:         zhh
* @CreateDate:     2018/11/21 14:36
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/21 14:36
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class TeacherController {
	private static final Log log = LogFactory.getLog(TeacherController.class);

	@Autowired
	private TeacherService teacherService;

	/**
	* @Description:    获取老师匿名列表
	* @Author:         zhh
	* @CreateDate:     2018/11/21 14:39
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 14:39
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/teacher/list", method = RequestMethod.GET)
	public String getTeacherNameList(ModelMap model) throws Exception {
		log.info("<======>get  /a/u/teacher/list  begin getTeacherNameList() method:");
		try {
			List<Long> teacherIdsList = teacherService.getTeacherIds(0,Integer.MAX_VALUE);
			List<Teacher> teacherList = teacherService.getObjectsByIds(teacherIdsList);
			log.info("get  teacher data is " + teacherList);

			model.addAttribute("code", 0);
			model.addAttribute("total",teacherList.size());
			model.addAttribute("teacherList", teacherList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get teacher error");
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/teacher/json/teacherListJson";
	}

	/**
	* @Description:    删除老师姓名
	* @Author:         zhh
	* @CreateDate:     2018/11/21 16:09
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 16:09
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/teacher/{id}", method = RequestMethod.DELETE)
	public String deleteTeacherJson( ModelMap model, @PathVariable Long id) throws Exception {

		log.info("delete teacher : id= " + id);
		try {
			teacherService.delete(id);
			log.info("delete teacher success");
			model.addAttribute("code", 0);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete teacher error,id is  " + id);
			model.addAttribute("code", -100000);
		}
		return "/academy-rich-admin-service/data/json";
	}


	/**
	* @Description:    新增老师
	* @Author:         zhh
	* @CreateDate:     2018/11/21 14:45
	* @UpdateUser:     zhh
	* @UpdateDate:     2018/11/21 14:45
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/teacher", method = RequestMethod.POST)
	public String addTeacher(ModelMap model, @RequestBody Teacher teacher) throws Exception {
		
		log.info("add teacher : teacher= " + teacher);
		Long time = System.currentTimeMillis();
		teacher.setCreateAt(time);
		teacher.setUpdateAt(time);
		//判断老师匿名是否重复
		List<Long> teacherIdsList = teacherService.getTeacherIds(0,Integer.MAX_VALUE);
		List<Teacher> teacherList = teacherService.getObjectsByIds(teacherIdsList);
		for(Teacher teacher1 : teacherList){
			if(teacher.getName().equals(teacher1.getName())){
				log.error("this teacherName is exist ");
				model.addAttribute("code", -7001);
				return "/academy-rich-admin-service/data/json";
			}
		}
		try { 
			teacher.setId(null);
			teacherService.insert(teacher);
			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add teacher error ");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-admin-service/data/json";
	}
	
}

