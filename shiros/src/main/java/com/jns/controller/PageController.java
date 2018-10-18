package com.jns.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("index")
    public String index(){
        return "model/index";
    }

    @RequiresPermissions("deleteOrder")
    @RequestMapping("deleteOrder")
    public String deleteOrder(){
        return "model/deleteOrder";
    }

    @RequiresRoles("productManager")
    @RequestMapping("deleteProduct")
    public String deleteProduct(){
        return "model/deleteProduct";
    }

    @RequestMapping("listProduct")
    public String listProduct(){
        return "model/listProduct";
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "model/login";
    }
    @RequestMapping("unauthorized")
    public String noPerms(){
        return "model/unauthorized";
    }
}
