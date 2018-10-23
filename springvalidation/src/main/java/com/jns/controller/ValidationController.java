package com.jns.controller;

import com.jns.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ValidationController {
    @RequestMapping("/add")
    public String add(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
//          List<FieldError> errors=bindingResult.getFieldErrors();
//          model.addAttribute("customer", customer);
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "add";
        }
        return "add";
    }

}
