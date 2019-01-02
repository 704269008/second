package com.ptteng.academy.rich.controller;

import com.ptteng.academy.rich.model.User;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserService;
import com.ptteng.academy.rich.service.UserSignService;
import com.ptteng.academy.rich.utils.DynamicSqlUtil;
import com.ptteng.academy.rich.utils.PageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 后台用户模块
 * @Author: zhh
 * @CreateDate: 2018/11/18 13:57
 * @UpdateUser: zhh
 * @UpdateDate: 2018/11/18 13:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */


@Controller
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;


    @Autowired
    private UserSignService userSignService;


    /**
     * @Description: 获取用户列表, 动态查询
     * @Author: zhh
     * @CreateDate: 2018/11/18 13:58
     * @UpdateUser: zhh
     * @UpdateDate: 2018/11/18 13:58
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */

    @RequestMapping(value = "/a/u/user/list", method = RequestMethod.GET)
    public String getUserList(ModelMap model, Long id, String name, Integer grade, String phone, String email,
                              Integer status, Integer minBeans, Integer maxBeans, String area, Integer pageNow, Integer pageSize) throws Exception {

        log.info("<======>get  /a/u/user/list  begin getUserList() method: ");


        //获取开始记录数和每页记录数。
        Map<String,Integer> pageMap = PageUtil.checkPageAndSize(pageNow, pageSize);

        Integer start = pageMap.get("start");

        Integer size = pageMap.get("size");
        Integer page = pageMap.get("page");

        try {

            Map<String, Object> params = DynamicSqlUtil.userDynamicSql(id, name, grade, phone, email, status, minBeans, maxBeans, area);
            log.info("params: " + params);

            //获取用户总数量
            List<Long> totalUserIds = userService.getIdsByDynamicCondition(User.class, params, 0, Integer.MAX_VALUE);
            if(totalUserIds==null){
                log.info("user is not exist");
                model.addAttribute("code", -5003);
                return "/academy-rich-admin-service/data/json";
            }
            Integer total = totalUserIds.size();
            log.info("用户总数："+total);

            //获取一页的记录
            List<Long> partUserIds = userService.getIdsByDynamicCondition(User.class, params, start, size);
            List<User> userList = userService.getObjectsByIds(partUserIds);

            //beans存放在签到表，新建一个集合，存放所有返回信息。
            List<Map<String, Object>> maps = new ArrayList<>();
            for (User user : userList) {

                long userSignId = userSignService.getUserSignIdByUserId(user.getId());

                UserSign userSign = userSignService.getObjectById(userSignId);

                if(userSign==null){
                    log.error("userId="+user.getId()+"response userSign is not exit");
                    model.addAttribute("code", -2007);
                    return "/academy-rich-admin-service/data/json";
                }
                Map<String, Object> map = new HashMap<>();
                map.put("id", user.getId());
                map.put("name", user.getName());
                map.put("email", user.getEmail());
                map.put("phone", user.getPhone());
                map.put("beans", userSign.getBeans());
                map.put("grade", user.getGrade());
                map.put("area", user.getArea());
                map.put("status", user.getStatus());
                log.info("map: "+map);
                //把数据合并到新建的集合中。
                maps.add(map);
            }
            log.info("maps"+maps);
            model.addAttribute("code", 0);
            model.addAttribute("userList", maps);
            model.addAttribute("total", total);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
        } catch (Throwable t) {
            log.error("server error");
            t.printStackTrace();
            model.addAttribute("code", -100000);
        }
        return "/academy-rich-admin-service/user/json/userListJson";
    }

/**
* @Description:    获取用户详情
* @Author:         zhh
* @CreateDate:     2018/11/18 16:53
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/18 16:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.GET)
    public String getUser(ModelMap model, @PathVariable Long id) throws Exception {

        log.info("<======>get  /a/u/user  begin getUser() method: ");
        log.info("get user data : id=" + id);
        try {
            User user = userService.getObjectById(id);
            log.info("get user data:" + user);
            if (user == null) {
                model.addAttribute("code", -5003);
                return "/academy-rich-admin-service/data/json";
            }
            log.info("开始调用userSign服务。");
            Long userSignId = userSignService.getUserSignIdByUserId(user.getId());
            UserSign userSign = userSignService.getObjectById(userSignId);

            model.addAttribute("beans", userSign.getBeans());
            model.addAttribute("code", 0);
            model.addAttribute("user", user);
        } catch (Throwable t) {
            log.error("server error");
            t.printStackTrace();
            model.addAttribute("code", -100000);
            return "/academy-rich-admin-service/data/json";
        }
        return "/academy-rich-admin-service/user/json/userDetailJson";
    }


    /**
    * @Description:    更新用户状态，冻结/解冻
    * @Author:         zhh
    * @CreateDate:     2018/11/18 16:54
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/18 16:54
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping(value = "/a/u/user/{id}/status", method = RequestMethod.PUT)
    public String updateUserJson(@PathVariable Long id, ModelMap model) throws Exception {

        log.info("update user status: id= " + id);

        try {

            User user = userService.getObjectById(id);
            log.info("get user data:" + user);
            if (user == null) {
                model.addAttribute("code", -5003);
                return "/academy-rich-admin-service/data/json";
            }
            int status = user.getStatus();
            //未冻结
            if (status == User.NOT_FROZEN_STATE) {
                log.info("begin frozen");
                user.setStatus(User.FROZEN_STATE);
            } else {
                log.info("begin recover");
                user.setStatus(User.NOT_FROZEN_STATE);
            }
            userService.update(user);

            model.addAttribute("code", 0);

        } catch (Throwable t) {
            log.error("server error");
            t.printStackTrace();
            model.addAttribute("code", -100000);
            return "/academy-rich-admin-service/data/json";
        }
        return "/academy-rich-admin-service/user/json/userStatus";
    }

}

