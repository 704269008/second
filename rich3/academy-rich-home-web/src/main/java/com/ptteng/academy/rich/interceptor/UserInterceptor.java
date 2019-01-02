package com.ptteng.academy.rich.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description:    前台拦截器
* @Author:         zhh
* @CreateDate:     2018/12/1 4:43
* @UpdateUser:     zhh
* @UpdateDate:     2018/12/1 4:43
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UserInterceptor implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
