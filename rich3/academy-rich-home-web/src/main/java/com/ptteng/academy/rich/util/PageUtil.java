package com.ptteng.academy.rich.util;

import com.qding.common.util.DataUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    分页模块
* @Author:         zhh
* @CreateDate:     2018/11/18 15:40
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/18 15:40
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class PageUtil {

    public static Map<String,Integer> checkPageAndSize(Integer pageNow,Integer pageSize){


        Map<String,Integer> map = new HashMap<>();

        if(DataUtils.isNullOrEmpty(pageNow)){
            pageNow = 1;
        }
        map.put("page",pageNow);
        if(DataUtils.isNullOrEmpty(pageSize)){
            pageSize = 10;
        }
        map.put("size",pageSize);
        Integer start = (pageNow - 1)* pageSize;
        if(start < 0){
            start = 0 ;
        }
        map.put("start",start);
        return map;
    }
}
