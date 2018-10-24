package com.jns.controller;

import com.danga.MemCached.MemCachedClient;
import com.jns.entity.Photo;
import com.jns.service.PhotoService;
import com.jns.utils.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {
    Log log= LogFactory.getLog(ManagerController.class);
    @Autowired
    MemCachedClient memCachedClient;

    @Autowired
    PhotoService photoService;

    //使用memcache缓存，读取数据库。
    @RequestMapping(value="/photo",method = RequestMethod.GET)
    public ModelAndView listPhotos(@RequestParam(value = "currPage",defaultValue = "1",required = true)int currPage){
        Page<Photo> photoPage= (Page<Photo>) memCachedClient.get("photoList"+currPage);
        if(photoPage!=null ){
        	log.info("使用memcache缓存");
        }else{
        	photoPage=photoService.showByPage(currPage);
        	memCachedClient.set("photoList"+currPage,photoPage);
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("page",photoPage);
        modelAndView.setViewName("listPhoto");
        return  modelAndView;
    }

    //nocache，读取数据
    @RequestMapping(value="/photos",method = RequestMethod.GET)
    public ModelAndView listPhoto(@RequestParam(value = "currPage",defaultValue = "1",required = true)int currPage){
        Page<Photo> photoPage=photoService.showByPage(currPage);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("page",photoPage);
        modelAndView.setViewName("listPhoto");
        return  modelAndView;
    }

    @RequestMapping(value="/photos/{id}",method = RequestMethod.GET)
    public ModelAndView editPhoto(@PathVariable(value = "id")int id){
        Photo photo=photoService.get(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("photo",photo);
        modelAndView.setViewName("editPhoto");
        return  modelAndView;
    }

    @RequestMapping(value="/photos/{id}",method = RequestMethod.DELETE)
    public String deletePhoto(@PathVariable(value = "id")int id, Model model){
        photoService.delete(id);
        return  "redirect:/photos";
    }

    @RequestMapping(value="/photos/{id}",method = RequestMethod.POST)
    public String updatePhoto(Photo photo, Model model){
        photoService.update(photo);
        return  "redirect:/photos";
    }

    @RequestMapping(value="/photos",method = RequestMethod.PUT)
    public String addPhoto(Photo photo, Model model){
        photoService.add(photo);
        return  "redirect:/photos";
    }
}
