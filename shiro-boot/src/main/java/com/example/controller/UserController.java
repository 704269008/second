package com.example.controller;

import com.example.pojo.Role;
import com.example.pojo.User;
import com.example.service1.RoleService;
import com.example.service1.UserRoleService;
import com.example.service1.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("config")
public class UserController {
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("listUser")
    public String list(Model model){
        List<User> us= userService.list();
        model.addAttribute("us", us);
        Map<User,List<Role>> user_roles = new HashMap<>();
        for (User user : us) {
            List<Role> roles=roleService.listRoles(user);
            user_roles.put(user, roles);
        }
        model.addAttribute("user_roles", user_roles);
        return "include/listUser";
    }
    @RequestMapping("editUser")
    public String edit(Model model, long id){
        List<Role> rs = roleService.list();
        model.addAttribute("rs", rs);
        User user =userService.get(id);
        model.addAttribute("user", user);

        List<Role> roles =roleService.listRoles(user);
        model.addAttribute("currentRoles", roles);

        return "include/editUser";
    }
    @RequestMapping("deleteUser")
    public String delete(Model model, long id){
        userService.delete(id);
        return "redirect:listUser";
    }
    @RequestMapping("updateUser")
    public String update(User user,long[] roleIds){
        userRoleService.setRoles(user,roleIds);
        String password=user.getUserPassword();
        //如果在修改的时候没有设置密码，就表示不改动密码
        if(password.length()!=0) {
            System.out.println("333");
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5";
            String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
            user.setSalt(salt);
            user.setUserPassword(encodedPassword);
        }
        else
            user.setUserPassword(null);

        userService.update(user);
        return "redirect:listUser";

    }

    @RequestMapping("addUser")
    public String add(Model model, String name, String password){

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();

        User u = new User();
        u.setUserName(name);
        u.setUserPassword(encodedPassword);
        u.setSalt(salt);
        userService.add(u);

        return "redirect:listUser";
    }

}
