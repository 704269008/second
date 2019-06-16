package com.collage.controller;


import com.collage.pojo.Bill;
import com.collage.service.BillService;
import com.collage.utils.constant.PayStatus;
import com.collage.utils.tips.SuccessTip;
import com.collage.wrapper.BillWarpper;
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
 * 账单管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:20:42
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private String PREFIX = "/bill/";

    @Autowired
    private BillService billService;

    /**
     * 跳转到账单管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bill.html";
    }



    /**
     * 跳转到修改账单管理
     */
    @RequestMapping("/bill_update/{orderid}")
    public String billUpdate(@PathVariable("orderid") int orderid, Model model) {
        List<Bill> billList=billService.selectBill(orderid);
        int sum=0;
        for(Bill bill:billList){
            sum+=bill.getNum()*bill.getPrice();
        }
        List<Map<String, Object>> bill = billService.selByOrderId(orderid);
        model.addAttribute("item",bill);
        model.addAttribute("sum",sum);
        return PREFIX + "bill_edit.html";
    }

    /**
     * 获取账单管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name,Integer paystatus,Integer mealstatus, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime) {
        List<Map<String, Object>> bills = billService.getOrderIdList(name,paystatus);
        return new BillWarpper(bills).warp();
    }

    /**
     * 跳转账单详情列表
     */
    @RequestMapping(value = "/bill_order/{orderid}")
    public String listOrder(@PathVariable("orderid") int orderId,Model model) {
        List<Bill> billList=billService.selectBill(orderId);
        int sum=0;
        for(Bill bill:billList){
            sum+=bill.getNum()*bill.getPrice();
        }
        model.addAttribute("orderid",orderId);
        model.addAttribute("sum",sum);
        return PREFIX + "bill_view.html";
    }

    /**
     * 获取账单详情列表
     */
    @RequestMapping(value = "/order/{orderid}")
    @ResponseBody
    public Object order(@PathVariable("orderid") Integer orderid) {
        List<Map<String, Object>> bills = billService.selectByOrderId(orderid);
        return new BillWarpper(bills).warp();
    }



    /**
     * 修改账单管理
     */
    @RequestMapping("/update/{orderid}")
    @ResponseBody
    public Object update(@PathVariable("orderid") Integer orderid) {
        List<Bill> billList=billService.selectBill(orderid);
        for(Bill bill:billList){
            bill.setPaystatus(PayStatus.PAY.getCode());
            billService.updateById(bill);
        }
        return SUCCESS_TIP;
    }

}
