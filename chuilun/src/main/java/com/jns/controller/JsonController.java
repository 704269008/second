package com.jns.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class JsonController {
    @RequestMapping("/arrayJson")
    public String toArrayJson(){
        return "/arrayJson";
    }
    @RequestMapping(value = "/arrayData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String toArrayJson(HttpServletRequest request){
        //前端传入数组到后端接收
        String json= request.getParameter("myArrayData");
        JSONArray jsonArray = JSONArray.fromObject(json);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            System.out.println("前端array: "+jsonObject.getString("name")+""+jsonObject.getString("password"));
        }
        //后端传数组到前端
        JSONArray array=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","新姓名");
        jsonObject.put("password","新密码");
        array.add(jsonObject);
        System.out.println("后端array: "+array.toString());
        return array.toString();
    }


    @RequestMapping("/listJson")
    public String toListJson(){
        return "/listJson";
    }
    @RequestMapping(value="/listData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String toListJson(HttpServletRequest request){
        //后端接受前端传来的list集合
        String list=request.getParameter("myListData");
        JSONObject jsonObject1=JSONObject.fromObject(list);
        //控制台输出接收到的数据。
        System.out.println("前端list: "+jsonObject1.getString("name")+jsonObject1.getString("password"));

        //后端传list集合到前端接收
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","新姓名");
        jsonObject.put("password","新密码");
        System.out.println("后端list "+jsonObject.toString());
        return jsonObject.toString();
    }
}
