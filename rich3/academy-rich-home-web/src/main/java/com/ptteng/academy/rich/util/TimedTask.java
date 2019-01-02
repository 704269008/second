package com.ptteng.academy.rich.util;

import com.ptteng.academy.rich.controller.UserController;
import com.ptteng.academy.rich.model.UserSign;
import com.ptteng.academy.rich.service.UserSignService;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TimedTask {
    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserSignService userSignService;

    @Autowired
    RedisTemplate redisTemplate;

    public void resetRecordSign() throws Exception{
        try {
            Map<String, Object> params = DynamicSqlUtil.getIdsByRecordSign();
            List<Long> idsList = userSignService.getIdsByDynamicCondition(UserSign.class, params, 0, Integer.MAX_VALUE);
            List<UserSign> userSignList = userSignService.getObjectsByIds(idsList);
            log.info("size: "+userSignList.size());
            for(int i = 0; i < userSignList.size();i++) {
                log.info("i: "+i);
                UserSign userSign = userSignList.get(i);
                userSign.setRecordSign(UserSign.NOT_SIGN_TAG);
                userSignList.set(i,userSign);
            }
            userSignService.updateList(userSignList);
        }catch (Throwable t){
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("reset recordSign error: " + System.currentTimeMillis());
        }
    }

    public void resetSignSet() throws Exception{
        try {
            List<Long> idsList = userSignService.getUserSignIds(0,Integer.MAX_VALUE);
            List<UserSign> userSignList = userSignService.getObjectsByIds(idsList);
            log.info("size: "+userSignList.size());
            for(int i = 0; i < userSignList.size();i++) {
                log.info("i: "+i);
                UserSign userSign = userSignList.get(i);
                userSign.setSignSet("0000000000000000000000000000000");
                userSignList.set(i,userSign);
            }
            userSignService.updateList(userSignList);
        }catch (Throwable t){
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("reset recordSign error: " + System.currentTimeMillis());
        }
    }

    public void resetVerificationTimes(){
        //redis模糊查询所有vt结尾的key，然后删除
        String keys = "*times";
        if (DataUtils.isNotNullOrEmpty(redisTemplate.keys(keys))){
            Set<String> keysList = redisTemplate.keys(keys);
            log.info("keysList: "+keysList);
            redisTemplate.delete(keysList);
        }
    }
}