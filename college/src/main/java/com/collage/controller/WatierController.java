package com.collage.controller;


import com.collage.pojo.Watier;
import com.collage.service.WatierService;
import com.collage.utils.tips.SuccessTip;
import com.collage.wrapper.WatierWarpper;
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
 * 服务员管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:22:51
 */
@Controller
@RequestMapping("/watier")
public class WatierController {

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private String PREFIX = "/watier/";

    @Autowired
    private WatierService watierService;

    /**
     * 跳转到服务员管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "watier.html";
    }

    /**
     * 跳转到添加服务员管理
     */
    @RequestMapping("/watier_add")
    public String watierAdd() {
        return PREFIX + "watier_add.html";
    }

    /**
     * 跳转到修改服务员管理
     */
    @RequestMapping("/watier_update/{watierId}")
    public String watierUpdate(@PathVariable Integer watierId, Model model) {
        Watier watier = watierService.selectById(watierId);
        model.addAttribute("item",watier);
        return PREFIX + "watier_edit.html";
    }

    /**
     * 获取服务员管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false)String condition,@RequestParam(required = false)Integer status) {
        List<Map<String, Object>> waiters = watierService.list(condition,status);
        return new WatierWarpper(waiters).warp();
    }

    /**
     * 新增服务员管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Watier watier) {
        System.out.println(watier);
        watierService.insert(watier);
        return SUCCESS_TIP;
    }

    /**
     * 删除服务员管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer watierId) {
        watierService.deleteById(watierId);
        return SUCCESS_TIP;
    }

    /**
     * 修改服务员管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Watier watier) {
        watierService.updateById(watier);
        return SUCCESS_TIP;
    }

    /**
     * 服务员管理详情
     */
    @RequestMapping(value = "/detail/{watierId}")
    @ResponseBody
    public Object detail(@PathVariable("watierId") Integer watierId) {
        return watierService.selectById(watierId);
    }
}
