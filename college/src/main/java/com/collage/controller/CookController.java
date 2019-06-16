package com.collage.controller;


import com.collage.pojo.Cook;
import com.collage.service.CookService;
import com.collage.utils.tips.SuccessTip;
import com.collage.wrapper.CookWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 厨师管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:21:25
 */
@Controller
@RequestMapping("/cook")
public class CookController{


    protected static SuccessTip SUCCESS_TIP = new SuccessTip();

    private String PREFIX = "/cook/";

    @Autowired
    private CookService cookService;

    /**
     * 跳转到厨师管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "cook.html";
    }

    /**
     * 跳转到添加厨师管理
     */
    @RequestMapping("/cook_add")
    public String cookAdd() {
        return PREFIX + "cook_add.html";
    }

    /**
     * 跳转到修改厨师管理
     */
    @RequestMapping("/cook_update/{cookId}")
    public String cookUpdate(@PathVariable Integer cookId, Model model) {
        Cook cook = cookService.selectById(cookId);
        model.addAttribute("item",cook);
        return PREFIX + "cook_edit.html";
    }

    /**
     * 获取厨师管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false)String condition,Integer  type,Integer status) {

        List<Map<String, Object>> cooks = cookService.list(condition,type,status);
        return new CookWarpper(cooks).warp();
    }

    /**
     * 新增厨师管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Cook cook) {
        cookService.insert(cook);
        return SUCCESS_TIP;
    }

    /**
     * 删除厨师管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer cookId) {
        cookService.deleteById(cookId);
        return SUCCESS_TIP;
    }

    /**
     * 修改厨师管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Cook cook) {
        cookService.updateById(cook);
        return SUCCESS_TIP;
    }

    /**
     * 厨师管理详情
     */
    @RequestMapping(value = "/detail/{cookId}")
    @ResponseBody
    public Object detail(@PathVariable("cookId") Integer cookId) {
        return cookService.selectById(cookId);
    }
}
