package com.jns.controller;

import com.jns.entity.Manager;
import com.jns.service.ManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManagerController {
    Log log= LogFactory.getLog(ManagerController.class);
    @Autowired
    ManagerService managerService;
    @RequestMapping(value="/managers",method=RequestMethod.GET)
    public ModelAndView listManager(){
        List<Manager> managers=managerService.managerList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("manager",managers);
        modelAndView.setViewName("listManager");
        return modelAndView;
    }

    @RequestMapping(value="/managers/{name}",method = RequestMethod.GET)
    public ModelAndView editManager(@PathVariable(value = "name")String name){
        Manager manager=managerService.get(name);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("manager",manager);
        modelAndView.setViewName("editManager");
        return  modelAndView;
    }

    @RequestMapping(value="/managers/{name}",method = RequestMethod.DELETE)
    public String deleteManager(@PathVariable(value = "name")String name, Model model){
        managerService.delete(name);
        return  "redirect:/managers";
    }

    @RequestMapping(value="/managers/{name}",method = RequestMethod.POST)
    public String updateManager(Manager manager, Model model){
        managerService.update(manager);
        return  "redirect:/managers";
    }

    @RequestMapping(value="/managers",method = RequestMethod.PUT)
    public String addManager(Manager manager, Model model){
        managerService.add(manager);
        return  "redirect:/managers";
    }
}
