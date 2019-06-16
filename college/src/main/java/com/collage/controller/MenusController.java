package com.collage.controller;

import com.collage.pojo.Bill;
import com.collage.pojo.Cart;
import com.collage.pojo.Menus;
import com.collage.service.*;
import com.collage.utils.tips.SuccessTip;
import com.collage.wrapper.MenusWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 菜品管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:22:09
 */
@Controller
@RequestMapping("/menus")
public class MenusController {

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private String PREFIX = "/menus/";

    @Autowired
    private MenusService menuService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private WatierService watierService;

    @Autowired
    private CartService cartService;

    @Autowired
    private BillService billService;

    /**
     * 跳转到菜品管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "menus.html";
    }

    /**
     * 跳转到添加菜品管理
     */
    @RequestMapping("/menus_add")
    public String menuAdd() {
        return PREFIX + "menus_add.html";
    }



    /**
     * 跳转到修改菜品管理
     */
    @RequestMapping("/menus_update/{menuId}")
    public String menuUpdate(@PathVariable Integer menuId, Model model) {
        Menus menu = menuService.selectById(menuId);
        model.addAttribute("item",menu);
        return PREFIX + "menus_edit.html";
    }

    /**
     * 获取菜品管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false)String condition,@RequestParam(required = false)Integer type,@RequestParam(required = false)Integer status) {
        List<Map<String, Object>> menus = menuService.list(condition,type, status);
        return new MenusWarpper(menus).warp();
    }

    /**
     * 新增菜品管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Menus menu) {
        menuService.insert(menu);
        return SUCCESS_TIP;
    }

    /**
     * 删除菜品管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer menuId) {
        menuService.deleteById(menuId);
        return SUCCESS_TIP;
    }

    /**
     * 加入购物车
     */
    @RequestMapping(value = "/gwc")
    @ResponseBody
    public Object gwc(@RequestParam Integer menuId) {
        Menus menus=menuService.selectById(menuId);
        Cart cart=new Cart();
        cart.setName(menus.getName());
        cart.setPicture(menus.getPicture());
        cart.setPrice(menus.getPrice());
        cart.setType(menus.getType());
        cartService.insertSelective(cart);
        return SUCCESS_TIP;
    }

    /**
     * 跳转到购物车页面
     */
    @RequestMapping("/menus_details")
    public String menuDetails(Model model) {
        List<Map<String, Object>> gwc = cartService.list();
        List<String> rooms =roomService.selectName();
        List<String> watiers =watierService.selectName();
        model.addAttribute("rooms",rooms);
        model.addAttribute("watiers",watiers);
        model.addAttribute("items",new MenusWarpper(gwc).warp());
        return PREFIX + "menus_details.html";
    }

    /**
     * 删除购物车数据
     */
    @RequestMapping(value = "/gwcDel")
    @ResponseBody
    public Object gwcDel(@RequestParam Integer menuId) {
        cartService.deleteById(menuId);
        return SUCCESS_TIP;
    }

    /**
     * 提交订单
     */
    @RequestMapping(value = "/gwcUpdate")
    @ResponseBody
    public Object gwcUpdate( HttpServletRequest request) {
        List<Cart> list=cartService.selCart();
        int orderid = cartService.selectByIDMax()+1;
        String [] num=request.getParameterValues("num");
        String wname=request.getParameter("wname");
        String rname=request.getParameter("rname");
        Bill bill=new Bill();
        for (int i = 0; i < list.size(); i++) {
            bill.setOrderid(orderid);
            bill.setPicture(list.get(i).getPicture());
            bill.setName(list.get(i).getName());
            bill.setWname(wname);
            bill.setRname(rname);
            bill.setNum(Integer.parseInt(num[i]));
            bill.setType(list.get(i).getType());
            bill.setPrice(list.get(i).getPrice());
            bill.setPaystatus(1);
            bill.setMealstatus(1);
            bill.setTime(new Date());
            billService.insert(bill);
            cartService.deleteById(list.get(i).getId());
        }
        return SUCCESS_TIP;
    }

    /**
     * 修改菜品管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Menus menu) {
        menuService.updateById(menu);
        return SUCCESS_TIP;
    }

    /**
     * 菜品管理详情
     */
    @RequestMapping(value = "/detail/{menuId}")
    @ResponseBody
    public Object detail(@PathVariable("menuId") Integer menuId) {
        return menuService.selectById(menuId);
    }
}
