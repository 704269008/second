package com.collage.controller;

import com.collage.pojo.Evaluate;
import com.collage.service.EvaluateService;
import com.collage.utils.tips.SuccessTip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评价管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:21:49
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController  {

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();

    private String PREFIX = "/evaluate/";

    @Autowired
    private EvaluateService evaluateService;

    /**
     * 跳转到评价管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "evaluate.html";
    }

    /**
     * 跳转到添加评价管理
     */
    @RequestMapping("/evaluate_add")
    public String evaluateAdd() {
        return PREFIX + "evaluate_add.html";
    }

    /**
     * 跳转到修改评价管理
     */
    @RequestMapping("/evaluate_update/{evaluateId}")
    public String evaluateUpdate(@PathVariable Integer evaluateId, Model model) {
        Evaluate evaluate = evaluateService.selectById(evaluateId);
        model.addAttribute("item",evaluate);
        return PREFIX + "evaluate_edit.html";
    }

    /**
     * 获取评价管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return evaluateService.list(condition);
    }

    /**
     * 新增评价管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Evaluate evaluate) {
        evaluateService.insert(evaluate);
        return SUCCESS_TIP;
    }

    /**
     * 删除评价管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer evaluateId) {
        evaluateService.deleteById(evaluateId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评价管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Evaluate evaluate) {
        evaluateService.updateById(evaluate);
        return SUCCESS_TIP;
    }

    /**
     * 评价管理详情
     */
    @RequestMapping(value = "/detail/{evaluateId}")
    @ResponseBody
    public Object detail(@PathVariable("evaluateId") Integer evaluateId) {
        return evaluateService.selectById(evaluateId);
    }
}
