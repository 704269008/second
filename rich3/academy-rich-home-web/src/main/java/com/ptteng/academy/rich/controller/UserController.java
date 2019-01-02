package com.ptteng.academy.rich.controller;

import com.aliyun.oss.OSSClient;
import com.ptteng.academy.rich.model.User;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserService;
import com.ptteng.academy.rich.service.UserSignService;
import com.ptteng.academy.rich.util.BindUtil;
import com.ptteng.academy.rich.util.DynamicSqlUtil;
import com.ptteng.academy.rich.util.OssUtil;
import com.ptteng.academy.rich.util.WXUtil;
import com.qding.common.util.DataUtils;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
* @Description:    前台--学生证模块
* @Author:         zhh
* @CreateDate:     2018/11/28 15:28
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/28 15:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UserController {
	private static final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserSignService userSignService;

	@Autowired
	private RedisTemplate redisTemplate;


	/**
	 * @Description:    学生证信息展示
	 * @Author:         wyq
	 * @Date:     2018/11/28 15:54
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */

	@RequestMapping(value = "/a/u/user", method = RequestMethod.GET)
	public String getUserDetail(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model, Long userId) throws Exception {

		try {
			User user = userService.getObjectById(userId);
			Map<String, Object> params = DynamicSqlUtil.getUserSignByUserId(userId);
			List<Long> idList = userSignService.getIdsByDynamicCondition(UserSign.class, params, 0, Integer.MAX_VALUE);
			Long id = idList.get(0);
			UserSign userSign = userSignService.getObjectById(id);
			int binding = 0;
			if (DataUtils.isNotNullOrEmpty(user.getEmail()) || DataUtils.isNotNullOrEmpty(user.getPhone())) {
				binding = 1;
			}

			model.addAttribute("code",0);
			model.addAttribute("user", user);
			model.addAttribute("userSign", userSign);
			model.addAttribute("binding",binding);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			log.error(" get user error,id is  " + userId);
			model.addAttribute("code",-100000);
		}
		log.info("/user  to /user/view/userList");

		return "/academy-rich-home-service/user/json/stuCardDetailJson";
	}

	/**
	 * @Description:    绑定信息展示
	 * @Author:         wyq
	 * @Date:     2018/11/28 15:54
	 * @UpdateUser:     wyq
	 * @UpdateRemark:   修改内容
	 * @Version:        1.0
	 */

	@RequestMapping(value = "/a/u/security", method = RequestMethod.GET)
	public String getUserSecurity(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model, Long userId)
			throws Exception {

		log.info("get data : id= " + userId);
		try {
			User user = userService.getObjectById(userId);
			log.info("get user data is " + user);

			model.addAttribute("code", 0);

			model.addAttribute("user", user);

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get security error,id is  " + userId);
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/user/json/userDetailJson";
	}

	/**
	* @Description:    手机验证码
	* @Author:         wyq
	* @Date:     2018/11/28 19:20
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/phone/code", method = RequestMethod.POST)
	public String getPhoneCodeJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, String phone) throws Exception {
		
		log.info("get code for phone : phone = " + phone);

		Object phoneCode;
		String code;

		try { 
			Map<String,Object> params = DynamicSqlUtil.getUserIdByPhone(phone);
			List<Long> userIdList = userService.getIdsByDynamicCondition(User.class,params,0,Integer.MAX_VALUE);
			log.info(userIdList);
			if (0 != userIdList.size()){
				model.addAttribute("code",1002);
			}else {
				phoneCode = redisTemplate.opsForValue().get(phone);
				if(phoneCode == null){
					code = String.valueOf(Math.random()).substring(2, 8);
					log.info("get code: " + code);
					BindUtil.sendMessageCode(phone,code);
					redisTemplate.opsForValue().set(phone,code);
					redisTemplate.expire(phone,60*3,TimeUnit.SECONDS);
					model.addAttribute("code",0);
				}else {
					model.addAttribute("code", 1006);
				}
			}
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get validate code error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:    手机绑定
	* @Author:         wyq
	* @Date:     2018/11/29 15:57
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/phone", method = RequestMethod.PUT)
	public String bindUserPhone(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long userId, String phone, String code)
			throws Exception {

		log.info("update user phone for userId = " + userId);
		int beans;
		Object phoneCode;
		Object verificationTimes;

        verificationTimes = redisTemplate.opsForValue().get(phone + "times");
        //判断验证是否超过三次
        if (DataUtils.isNotNullOrEmpty(verificationTimes)){
            int times = Integer.parseInt(verificationTimes.toString());
            if (times >= 3){
                model.addAttribute("code",1003);
                return "/academy-rich-home-service/user/json/userBindingJson";
            }
        }

		try {
            //判断手机是否已使用
            Map<String, Object> params = DynamicSqlUtil.getUserIdByPhone(phone);
            List<Long> userIdList = userService.getIdsByDynamicCondition(User.class, params, 0, Integer.MAX_VALUE);
            if (0 != userIdList.size()) {
                //手机已使用，提示手机已注册
                model.addAttribute("code", 1002);
            }else {
                //从缓存中获取验证码
                phoneCode = redisTemplate.opsForValue().get(phone);
                if (DataUtils.isNotNullOrEmpty(phoneCode)) {
                    if (phoneCode.toString().equals(code)) {
                        User user = userService.getObjectById(userId);
                        if (DataUtils.isNullOrEmpty(user.getPhone())) {

                            Map<String, Object> param = DynamicSqlUtil.getUserSignByUserId(userId);
                            List<Long> userSignIdList = userSignService.getIdsByDynamicCondition(UserSign.class, param, 0, Integer.MAX_VALUE);
                            Long id = userSignIdList.get(0);
                            UserSign userSign = userSignService.getObjectById(id);
                            beans = userSign.getBeans();
                            userSign.setBeans(beans + 20);
                            userSignService.update(userSign);
                            model.addAttribute("increaseBeans", 20);
                        }
                        user.setPhone(phone);
                        userService.update(user);

                        log.info("banding phone success");
                        model.addAttribute("increaseBeans", 0);
                        model.addAttribute("code", 0);

                        //验证码错误
                    } else {
                        model.addAttribute("code", 1005);
                    }
                //缓存中没有验证码，提示验证码已失效
                } else {
                    model.addAttribute("code", 1004);
                }
            }

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("banding phone error, phone is " + phone);
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-home-service/user/json/userBindingJson";
	}
	

	/**
	* @Description:    邮箱验证码
	* @Author:         wyq
	* @Date:     2018/11/29 15:57
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/email/code", method = RequestMethod.POST)
	public String getEmailCode(HttpServletRequest request,
							  HttpServletResponse response, ModelMap model, String email) throws Exception {

		log.info("get code for email : email = " + email);

		Object emailCode;
		String code;

		try {
			Map<String,Object> params = DynamicSqlUtil.getUserIdByEmail(email);
			List<Long> userIdList = userService.getIdsByDynamicCondition(User.class,params,0,Integer.MAX_VALUE);
			if (0 != userIdList.size()){
				model.addAttribute("code",1002);
			}else {
				emailCode = redisTemplate.opsForValue().get(email);
				if(emailCode == null){
					code = String.valueOf(Math.random()).substring(2, 8);
					log.info("get code: " + code);
					BindUtil.sendEmailCode(email,code);
					redisTemplate.opsForValue().set(email,code);
					redisTemplate.expire(email,60*3,TimeUnit.SECONDS);
					model.addAttribute("code",0);
				}else {
					model.addAttribute("code", 1006);
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("get validate code error");
			model.addAttribute("code", -100000);
		}

		return "/academy-rich-home-service/data/json";
	}

	/**
	* @Description:    绑定邮箱
	* @Author:         wyq
	* @Date:     2018/11/29 16:05
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/email", method = RequestMethod.PUT)
	public String bindUserEmail(HttpServletRequest request,
									HttpServletResponse response, ModelMap model, Long userId, String email, String code)
			throws Exception {

		log.info("update user email for userId = " + userId);
		int beans;
		Object emailCode;
        Object verificationTimes;

        verificationTimes = redisTemplate.opsForValue().get(email + "times");
        //判断验证是否超过三次
        if (DataUtils.isNotNullOrEmpty(verificationTimes)){
            int times = Integer.parseInt(verificationTimes.toString());
            if (times >= 3){
                model.addAttribute("code",1003);
                return "/academy-rich-home-service/user/json/userBindingJson";
            }
        }

		try {
			emailCode = redisTemplate.opsForValue().get(email);
			if (DataUtils.isNotNullOrEmpty(emailCode)) {
                if (emailCode.toString().equals(code)) {
                    Map<String,Object> params = DynamicSqlUtil.getUserIdByEmail(email);
                    List<Long> userIdList = userService.getIdsByDynamicCondition(User.class,params,0,Integer.MAX_VALUE);
                    if (0 != userIdList.size()) {
                        model.addAttribute("code", 1002);
                    } else {
                        User user = userService.getObjectById(userId);
                        if (DataUtils.isNullOrEmpty(user.getEmail())) {

                            Map<String, Object> param = DynamicSqlUtil.getUserSignByUserId(userId);
                            List<Long> userSignIdList = userSignService.getIdsByDynamicCondition(UserSign.class, param, 0, Integer.MAX_VALUE);
                            Long id = userSignIdList.get(0);
                            UserSign userSign = userSignService.getObjectById(id);
                            beans = userSign.getBeans();
                            userSign.setBeans(beans + 20);
                            userSignService.update(userSign);
                            model.addAttribute("increaseBeans", 20);
                        }
                        user.setEmail(email);
                        userService.update(user);

                        log.info("banding phone success");
                        model.addAttribute("increaseBeans", 0);
                        model.addAttribute("code", 0);
                    }
                } else {
                    model.addAttribute("code", 1005);
                }
            }else {
			    model.addAttribute("code",1004);
            }

		} catch (Throwable t) {
			t.printStackTrace();
			log.error(t.getMessage());
			log.error("banding phone error, email is " + email);
			model.addAttribute("code", -100000);

		}

		return "/academy-rich-home-service/user/json/userBindingJson";
	}

	/**
	* @Description:    学生证资料编辑页面
	* @Author:         wyq
	* @Date:     2018/11/29 19:38
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/data", method = RequestMethod.GET)
    public String getUserData(HttpServletRequest request,
                              HttpServletResponse response, ModelMap model, Long userId)
            throws Exception{
	    log.info("get user data, id = " + userId);

	    try{
	        User user = userService.getObjectById(userId);
	        model.addAttribute("code",0);
	        model.addAttribute("user",user);
        }catch (Throwable t){
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("banding user data error, id is " + userId);
            model.addAttribute("code", -100000);
        }

        return "/academy-rich-home-service/user/json/userDetailJson";
    }

    /**
    * @Description:    学生证资料编辑头像上传
    * @Author:         wyq
    * @Date:     2018/11/29 19:45
    * @UpdateUser:     wyq
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping(value = "/a/u/user/picture", method = RequestMethod.POST)
	public String uploadPicture(ModelMap model, @RequestParam(value = "file")MultipartFile file)
		throws Exception{

		log.info("upload file: "+file.getOriginalFilename());

		//判断文件是否为空
		if(file.isEmpty()) {
			log.info("file is empty");
			model.addAttribute("code", -6001);
			return "/academy-rich-home-service/data/json";
		}

		//判断文件类型
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

		if(!OssUtil.checkImgType(type)){
			log.info("picture type error");
			model.addAttribute("code",-6003);
			return "/academy-rich-home-service/data/json";
		}


		try {
			//初始化oss客户端
			OSSClient ossClient=OssUtil.getOssClient();
			//文件输入流
			InputStream inputStream = file.getInputStream();
			//根据模块划分，并统一图片路径
			String filePath = "avatar/"+new Date().getTime()+String.valueOf(file.getOriginalFilename());
			//返回图片url
			String imgUrl = OssUtil.UploadPictureByInputStream(ossClient,filePath,inputStream);

			model.addAttribute("url",imgUrl);
			model.addAttribute("code",0);

		} catch (IOException e) {
			log.info("picture upload failure");
			e.printStackTrace();
			model.addAttribute("code",-6004);
			return "/academy-rich-home-service/data/json";
		}
		return "/academy-rich-home-service/user/json/uploadPictureJson";
	}

	/**
	* @Description:    学生证资料编辑
	* @Author:         wyq
	* @Date:     2018/11/30 13:45
	* @UpdateUser:     wyq
	* @UpdateRemark:   修改内容
	* @Version:        1.0
	*/
	@RequestMapping(value = "/a/u/user/data",method = RequestMethod.PUT)
	public String updateUserData(HttpServletRequest request, HttpServletResponse response, ModelMap model, Long userId,
								 String avatar, String name, int grade){
		log.info("update User( avatar: " + avatar + " name: " + name + " grade: " + grade + " ) data of useId: " + userId);

		try {
			User user = userService.getObjectById(userId);
			user.setAvatar(avatar);
			user.setName(name);
			user.setGrade(grade);
			userService.update(user);

			model.addAttribute("code",0);
		}catch (Throwable t){
			t.printStackTrace();
			log.error(t.getMessage());
			model.addAttribute("code",-100000);
		}

		return "/academy-rich-home-service/data/json";
	}


	/**
	 * @Description: 根据code获取
	 * @Author: zhh
	 * @CreateDate: 2018/11/30 17:52
	 * @UpdateUser: zhh
	 * @UpdateDate: 2018/11/30 17:52
	 * @UpdateRemark: 修改内容
	 * @Version: 1.0
	 */
	@RequestMapping(value = "/a/u/login", method = RequestMethod.POST)
	public String homeLogin(ModelMap model, String code, String rawData, String signature, String encrypteData, String iv) throws Exception {

		log.info("code:" + code);

		log.info("start get sessionKey:");
		log.info("用户非敏感信息" + rawData);

		JSONObject rawDataJson = JSONObject.fromObject(rawData);

		//获取sessionKey和openid
		JSONObject sessionKeyOpenid = WXUtil.getSessionKeyOropenid(code);

		log.info("获取到的sessionKey和openid：" + sessionKeyOpenid);
		String openid = sessionKeyOpenid.getString("openid");
		String sessionKey = sessionKeyOpenid.getString("session_key");

		Map<String, Object> map = DynamicSqlUtil.userDynamicSql(openid);
		log.info("map:" + map);
		List<Long> userIds = userService.getIdsByDynamicCondition(User.class, map, 0, Integer.MAX_VALUE);
		log.info("userIds:" + userIds);

		//判断用户是否第一次登录
		if (userIds.isEmpty()) {
			String nickName = rawDataJson.getString("nickName");
			String avatarUrl = rawDataJson.getString("avatarUrl");
			String city = rawDataJson.getString("city");
			String provice = rawDataJson.getString("province");

			User user = new User();
			user.setStatus(User.NOT_FROZEN_STATE);
			user.setName(nickName);
			user.setArea(provice + city);
			user.setAvatar(avatarUrl);
			user.setOpenid(openid);
			log.info("add data into user");

			Long userId = userService.insert(user);
			if (userId != null) {
				log.info("add user success");
			}
			//更新签到表
			UserSign userSign = new UserSign();
			userSign.setUserId(userId);
			userSign.setBeans(0);
			log.info("userSign" + userSign);
			userSignService.insert(userSign);

			//redisTemplate.opsForValue().set(openid,sessionKey);
			//redisTemplate.expire(openid,60*5,TimeUnit.SECONDS);

			model.addAttribute("userId", user.getId());
			model.addAttribute("openedId", user.getOpenid());
			model.addAttribute("name", user.getName());
			model.addAttribute("code", 0);
		} else {
			Long uid = userIds.get(0);
			log.info("userId:" + uid);
			User user = userService.getObjectById(uid);
			//判断用户是否冻结
			if (user.getStatus() == User.FROZEN_STATE) {
				model.addAttribute("code", -5000);
			} else {
				model.addAttribute("code", 0);
				model.addAttribute("userId", user.getId());
				model.addAttribute("openedId", user.getOpenid());
				model.addAttribute("name", user.getName());
			}
		}
		return "/academy-rich-home-service/data/loginSuccess";
	}
}

