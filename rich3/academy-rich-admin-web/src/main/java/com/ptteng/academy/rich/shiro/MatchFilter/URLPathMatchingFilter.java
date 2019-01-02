package com.ptteng.academy.rich.shiro.MatchFilter;

import com.ptteng.academy.rich.service.ModuleService;
import com.ptteng.academy.rich.shiro.Permission.PermissionList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class URLPathMatchingFilter extends PathMatchingFilter {

    private static final Log log = LogFactory.getLog(URLPathMatchingFilter.class);

    @Autowired
    ModuleService moduleService;

    PermissionList permissionList=new PermissionList();

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String requestURI = getPathWithinApplication(request);

        log.info("requestURI:" + requestURI);

        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/a/login");
            return false;
        }

        // 看看这个路径权限里有没有维护，如果没有维护，一律放行(也可以改为一律不放行)
        boolean needInterceptor = permissionList.needInterceptor(requestURI);
        if (!needInterceptor) {
            return true;
        } else {
            boolean hasPermission = false;
            String accountName = subject.getPrincipal().toString();
            Set<String> permissionUrls = permissionList.listPermissionURLs(accountName);
            for (String url : permissionUrls) {
                // 这就表示当前用户有这个权限
                if (url.equals(requestURI)) {
                    log.info("success");
                    hasPermission = true;
                    break;
                }
            }

            if (hasPermission) {
                log.info("具有这个权限");
                return true;
            } else {
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");

                subject.getSession().setAttribute("ex", ex);

                WebUtils.issueRedirect(request, response, "/a/unauthorized");
                return false;
            }

        }

    }



}
