package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.User;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserService;
import com.ptteng.academy.rich.service.UserSignService;
import com.ptteng.academy.rich.util.DynamicSqlUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * UserSign  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class UserSignController {
	private static final Log log = LogFactory.getLog(UserSignController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserSignService userSignService;






	/**
	 * @Description:    签到页面展示
	 * @Author:         wyq
	 * @Date:     2018/11/26 17:15
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */

	@RequestMapping(value = "/a/u/sign", method = RequestMethod.GET)
	public String getuserSignList(HttpServletRequest request,
								  HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		UserSign userSign = userSignService.getObjectById(userId);
		log.info("userSign: " + userSign);

		User user = userService.getObjectById(userId);
		log.info("user: " + user);

		if(userSign == null || user == null){
			log.info("user or userSign is null");
			model.addAttribute("code",-2005);
			model.addAttribute("user",null);
			model.addAttribute("userSign",null);
		}else {
			model.addAttribute("code",0);
			model.addAttribute("user",user);
			model.addAttribute("userSign",userSign);
		}
		return "/academy-rich-home-service/userSign/json/userSignDetailJson";
	}
    
    

    

	/**
	 * @Description:    签到
	 * @Author:         wyq
	 * @Date:     2018/11/26 21:13
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */
	@RequestMapping(value = "/a/u/sign", method = RequestMethod.PUT)
	public String updateUserSignJson(ModelMap model, Long userId) throws Exception {

		log.info("user sign, id is " + userId);
		int increaseBeans = 1;
		int beans;
		int continuousSign;
		int recordSign;
		Long id;
		String signSet;

		try {
			Map<String,Object> params = DynamicSqlUtil.getUserSignByUserId(userId);
			List<Long> idList = userSignService.getIdsByDynamicCondition(UserSign.class,params,0,Integer.MAX_VALUE);
			id = idList.get(0);
			UserSign userSign = userSignService.getObjectById(id);
			log.info("userSign: " + userSign);
			recordSign = userSign.getRecordSign();
			log.info("user's recordSign is " + recordSign);
			continuousSign = userSign.getContinuousSign();
			log.info("user's continuousSign is " + continuousSign);
			beans = userSign.getBeans();
			log.info("user's beans is " + beans);
			//查看用户今天是否已经签到
			if(recordSign == UserSign.NOT_SIGN_TAG){
				log.info("user has not been signed today");
				userSign.setRecordSign(1);

				//获取当天几号
				Calendar date = Calendar.getInstance();
				int today = date.get(Calendar.DATE);
				log.info("today is " + today);

				//根据几号来确定更新字符串第几位
				signSet = userSign.getSignSet();
				char[] signSetStatus = signSet.toCharArray();
				signSetStatus[today-1] = '1';
				signSet = String.valueOf(signSetStatus);
				log.info("signSet: " + signSet);
				userSign.setSignSet(signSet);

				if(continuousSign > 5){
					//连续签到大于五天，逆袭豆只增价5颗
					beans = beans + 5;
					userSign.setBeans(beans);
					increaseBeans = 5;
					userSign.setContinuousSign(continuousSign+1);
				}else {
					//连续签到小于等于五天，连续签到n天，逆袭豆增加n颗
					beans = beans + continuousSign;
					userSign.setBeans(beans);
					increaseBeans = continuousSign;
					userSign.setContinuousSign(continuousSign+1);
				}
				if(userSign.getMaxSign() < userSign.getContinuousSign()){
					//用户最大连续签到天数小于连续签到天数，更新用户最大连续签到天数
					userSign.setMaxSign(userSign.getContinuousSign());
				}
				userSignService.update(userSign);

				model.addAttribute("code", 0);
				model.addAttribute("increaseBeans",increaseBeans);

			}else {
				log.info("user has been signed today");
				model.addAttribute("code",-2004);
			}

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error(" user sign error,id is  " + userId);
			model.addAttribute("code", -6003);

		}

		return "/academy-rich-home-service/userSign/json/userSignStatusJson";
	}
	
}

