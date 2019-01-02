package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.User;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserService;
import com.ptteng.academy.rich.service.UserSignService;
import com.ptteng.academy.rich.service.WechatDataService;
import com.ptteng.academy.rich.util.DynamicSqlUtil;
import com.ptteng.academy.rich.util.WXUtil;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @Description: 微信登录模块
 * @Author: zhh
 * @CreateDate: 2018/11/30 17:50
 * @UpdateUser: zhh
 * @UpdateDate: 2018/11/30 17:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Controller
public class WechatDataController {
    private static final Log log = LogFactory.getLog(WechatDataController.class);

    @Autowired
    private WechatDataService wechatDataService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserSignService userSignService;


    /**
     * @Description: 根据code获取
     * @Author: zhh
     * @CreateDate: 2018/11/30 17:52
     * @UpdateUser: zhh
     * @UpdateDate: 2018/11/30 17:52
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    @RequestMapping(value = "/a/u/wechatData/login", method = RequestMethod.POST)
    public String wechatLogin(ModelMap model, String code, String rawData, String signature, String encrypteData, String iv) throws Exception {

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

