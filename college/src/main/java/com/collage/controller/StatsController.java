package com.collage.controller;

import com.collage.service.BillService;
import com.collage.wrapper.MenusWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stats")
public class StatsController {
    private String PREFIX = "/stats/";



    @Autowired
    private BillService billService;

    /**
     * 跳转到查看服务员业绩页面
     */
    @RequestMapping("/watier_stats")
    public String watierInfo(Model model,Integer codition) {
        return PREFIX + "watier_view.html";
    }

    @RequestMapping("/watier_day")
    @ResponseBody
    public Object watier(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,Integer status){
        List valueList=new ArrayList<>();
        Map<String,Object> list=new HashMap<>();
        if(status==null){
            List<Map<String,Object>> list1= billService.selectDayWaiter(beginTime,endTime);
            List<Map<String,Object>> legendList= billService.legendDayWaiter(beginTime,endTime);
            List<Map<String,Object>> keyList= billService.keyDayWaiter(beginTime,endTime);
            for(Map<String,Object> legend:legendList){
                Map<String,Object> list3=new HashMap<>();
                int i=0;
                for(Map<String,Object> list2:list1){
                    if(legend.get("wname").equals(list2.get("wname"))){
                        list3.put("total"+i,list2.get("total"));
                        i++;
                    }
                }
                valueList.add(list3);
            }
            list.put("nameList",legendList);
            list.put("valueList",valueList);
            list.put("keyList",keyList);
        }else{
            if(status==1){
                List<Map<String,Object>> list1= billService.selectDayWaiter(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendDayWaiter(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyDayWaiter(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("wname").equals(list2.get("wname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==2){
                List<Map<String,Object>> list1= billService.selectMonthWaiter(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendMonthWaiter(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyMonthWaiter(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("wname").equals(list2.get("wname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==3){
                List<Map<String,Object>> list1= billService.selectYearWaiter(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendYearWaiter(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyYearWaiter(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("wname").equals(list2.get("wname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
        }
        return list;
    }

    /**
     * 跳转到查看厨师业绩页面
     */
    @RequestMapping("/cook_stats")
    public String cookInfo(Model model,Integer codition) {

        return PREFIX + "cook_view.html";
    }

    @RequestMapping("/cook_day")
    @ResponseBody
    public Object cook(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,Integer status){
        List valueList=new ArrayList<>();
        Map<String,Object> list=new HashMap<>();
        if(status==null){
            List<Map<String,Object>> list1= billService.selectDayCook(beginTime,endTime);
            List<Map<String,Object>> legendList= billService.legendDayCook(beginTime,endTime);
            List<Map<String,Object>> keyList= billService.keyDayCook(beginTime,endTime);
            for(Map<String,Object> legend:legendList){
                Map<String,Object> list3=new HashMap<>();
                int i=0;
                for(Map<String,Object> list2:list1){
                    if(legend.get("cname").equals(list2.get("cname"))){
                        list3.put("total"+i,list2.get("total"));
                        i++;
                    }
                }
                valueList.add(list3);

            }
            list.put("nameList",legendList);
            list.put("valueList",valueList);
            list.put("keyList",keyList);
        }else{
            if(status==1){
                List<Map<String,Object>> list1= billService.selectDayCook(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendDayCook(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyDayCook(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("cname").equals(list2.get("cname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==2){
                List<Map<String,Object>> list1= billService.selectMonthCook(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendMonthCook(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyMonthCook(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("cname").equals(list2.get("cname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==3){
                List<Map<String,Object>> list1= billService.selectYearCook(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendYearCook(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyYearCook(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("cname").equals(list2.get("cname"))){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",legendList);
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
        }
        return list;
    }


    /**
     * 跳转到查看菜品统计页面
     */
    @RequestMapping("/menus_stats")
    public String menusInfo(Model model) {

        return PREFIX + "menus_view.html";
    }

    @RequestMapping("/menus_day")
    @ResponseBody
    public Object menus(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,Integer status){
        List valueList=new ArrayList<>();
        Map<String,Object> list=new HashMap<>();
        if(status==null){
            List<Map<String,Object>> list1= billService.selectDayMenus(beginTime,endTime);
            List<Map<String,Object>> legendList= billService.legendDayMenus(beginTime,endTime);
            List<Map<String,Object>> keyList= billService.keyDayMenus(beginTime,endTime);
            for(Map<String,Object> legend:legendList){
                Map<String,Object> list3=new HashMap<>();
                int i=0;
                for(Map<String,Object> list2:list1){
                    if(legend.get("type")==list2.get("type")){
                        list3.put("total"+i,list2.get("total"));
                        i++;
                    }
                }
                valueList.add(list3);
            }
            list.put("nameList",new MenusWarpper(legendList).warp());
            list.put("valueList",valueList);
            list.put("keyList",keyList);
        }else{
            if(status==1){
                List<Map<String,Object>> list1= billService.selectDayMenus(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendDayMenus(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyDayMenus(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("type")==list2.get("type")){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",new MenusWarpper(legendList).warp());
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==2){
                List<Map<String,Object>> list1= billService.selectMonthMenus(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendMonthMenus(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyMonthMenus(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("type")==list2.get("type")){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",new MenusWarpper(legendList).warp());
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
            if(status==3){
                List<Map<String,Object>> list1= billService.selectYearMenus(beginTime,endTime);
                List<Map<String,Object>> legendList= billService.legendYearMenus(beginTime,endTime);
                List<Map<String,Object>> keyList= billService.keyYearMenus(beginTime,endTime);
                for(Map<String,Object> legend:legendList){
                    Map<String,Object> list3=new HashMap<>();
                    int i=0;
                    for(Map<String,Object> list2:list1){
                        if(legend.get("type")==list2.get("type")){
                            list3.put("total"+i,list2.get("total"));
                            i++;
                        }
                    }
                    valueList.add(list3);
                }
                list.put("nameList",new MenusWarpper(legendList).warp());
                list.put("valueList",valueList);
                list.put("keyList",keyList);
            }
        }
        return list;
    }



    /**
     * 跳转到查看盈利统计页面
     */
    @RequestMapping("/profit_stats")
    public String profitInfo(Model model, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime) {
        List<Map<String,Object>> list = billService.selectDayProfit(beginTime,endTime);
        model.addAttribute("list",list);

        return PREFIX + "profit_view.html";
    }

    @RequestMapping("/profit_day")
    @ResponseBody
    public Object profit(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,Integer status){
        List<Map<String,Object>> list= billService.selectDayProfit(beginTime,endTime);
        if(status==null){

        }else{
            if(status==1){

                list = billService.selectDayProfit(beginTime,endTime);
            }
            if(status==2){
                list=billService.selectMonthProfit(beginTime,endTime);
            }
            if(status==3){
                list=billService.selectYearProfit(beginTime,endTime);
            }
        }


        return list;
    }


}
