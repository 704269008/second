package com.collage.controller;

import com.collage.mapper.MenuMapper;
import com.collage.mapper.UserMapper;
import com.collage.pojo.ShiroUser;
import com.collage.pojo.User;
import com.collage.utils.node.MenuNode;
import com.collage.utils.util.ShiroKit;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("")
public class LoginController  {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/WEB-INF/html/main/login.html";
        }
        List<MenuNode> menus = menuMapper.getMenusByRoleIds(roleList);
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userMapper.selectById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/main/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return "redirect:/";
        } else {
            return "/main/login.html";
        }
    }
    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali(HttpServletRequest request) {


        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        try {

            currentUser.login(token);

            ShiroUser shiroUser = ShiroKit.getUser();

            request.getSession().setAttribute("shiroUser", shiroUser);
            request.getSession().setAttribute("username", shiroUser.getAccount());

            return "redirect:/";
        }catch (AuthenticationException e){
            return "/main/login.html";
        }
    }



    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        ShiroKit.getSubject().logout();
        return "redirect:/login";
    }
}
