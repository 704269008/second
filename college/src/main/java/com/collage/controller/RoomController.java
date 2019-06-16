package com.collage.controller;

import com.collage.pojo.Room;
import com.collage.service.RoomService;
import com.collage.utils.tips.SuccessTip;
import com.collage.wrapper.RoomWarpper;
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
 * 房间管理控制器
 *
 * @author fengshuonan
 * @Date 2019-05-03 09:22:28
 */
@Controller
@RequestMapping("/room")
public class RoomController  {

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private String PREFIX = "/room/";

    @Autowired
    private RoomService roomService;

    /**
     * 跳转到房间管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "room.html";
    }

    /**
     * 跳转到添加房间管理
     */
    @RequestMapping("/room_add")
    public String roomAdd() {
        return PREFIX + "room_add.html";
    }

    /**
     * 跳转到修改房间管理
     */
    @RequestMapping("/room_update/{roomId}")
    public String roomUpdate(@PathVariable Integer roomId, Model model) {
        Room room = roomService.selectById(roomId);
        model.addAttribute("item",room);
        return PREFIX + "room_edit.html";
    }

    /**
     * 获取房间管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition,Integer status) {
        List<Map<String, Object>> rooms = roomService.list(condition,status);
        return new RoomWarpper(rooms).warp();
    }

    /**
     * 新增房间管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Room room) {
        roomService.insert(room);
        return SUCCESS_TIP;
    }

    /**
     * 删除房间管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer roomId) {
        roomService.deleteById(roomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改房间管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Room room) {
        roomService.updateById(room);
        return SUCCESS_TIP;
    }

    /**
     * 房间管理详情
     */
    @RequestMapping(value = "/detail/{roomId}")
    @ResponseBody
    public Object detail(@PathVariable("roomId") Integer roomId) {
        return roomService.selectById(roomId);
    }
}
