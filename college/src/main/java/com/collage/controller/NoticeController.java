package com.collage.controller;

import com.collage.mapper.NoticeMapper;
import com.collage.pojo.Notice;
import com.collage.utils.exception.BizExceptionEnum;
import com.collage.utils.exception.GunsException;
import com.collage.utils.support.HttpKit;
import com.collage.utils.tips.SuccessTip;
import com.collage.utils.util.ShiroKit;
import com.collage.utils.util.ToolUtil;
import com.collage.wrapper.NoticeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeMapper noticeMapper;

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private static String PREFIX = "/notice/";

    /**
     * 跳转到通知列表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "notice.html";
    }

    /**
     * 跳转到添加通知
     */
    @RequestMapping("/notice_add")
    public String noticeAdd() {
        return PREFIX + "notice_add.html";
    }

    /**
     * 跳转到修改通知
     */
    @RequestMapping("/notice_update/{noticeId}")
    public String noticeUpdate(@PathVariable Integer noticeId, Model model) {
        Notice notice = this.noticeMapper.selectById(noticeId);
        model.addAttribute("notice",notice);
        return PREFIX + "notice_edit.html";
    }

    /**
     * 跳转到首页通知
     */
    @RequestMapping("/hello")
    public String hello() {
        List<Map<String, Object>> notices = noticeMapper.list(null);
        HttpKit.getRequest().setAttribute("noticeList", notices);
        return PREFIX +"/blackboard.html";
    }

    /**
     * 获取通知列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.noticeMapper.list(condition);
        return new NoticeWrapper(list).warp();
    }

    /**
     * 新增通知
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Notice notice) {
        if (ToolUtil.isOneEmpty(notice, notice.getTitle(), notice.getContent())) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        notice.setCreater(ShiroKit.getUser().getId());
        notice.setCreatetime(new Date());
        System.out.println("添加通知信息"+notice);
        noticeMapper.insertNotice(notice);
        return SUCCESS_TIP;
    }

    /**
     * 删除通知
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer noticeId) {

        this.noticeMapper.deleteById(noticeId);

        return SUCCESS_TIP;
    }

    /**
     * 修改通知
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Notice notice) {
        if (ToolUtil.isOneEmpty(notice, notice.getId(), notice.getTitle(), notice.getContent())) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        System.out.println("通知信息："+notice);
        Notice old = this.noticeMapper.selectById(notice.getId());
        old.setTitle(notice.getTitle());
        old.setContent(notice.getContent());
        noticeMapper.updateById(old);
        return SUCCESS_TIP;
    }

}
