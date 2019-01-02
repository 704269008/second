package com.ptteng.academy.rich.controller;


import com.aliyun.oss.OSSClient;
import com.ptteng.academy.rich.utils.OssUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
* @Description:    接受图片，并回传url
* @Author:         zhh
* @CreateDate:     2018/11/20 18:31
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/20 18:31
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/a/u/upload/{module}",method = RequestMethod.POST)
    public String UploadPicture(ModelMap model, @PathVariable String module, @RequestParam(value = "file")MultipartFile file){

        log.info("upload file",file.getOriginalFilename());

        //判断文件是否为空
        if(file.isEmpty()) {
            log.info("file is empty");
            model.addAttribute("code", -6001);
            return "/academy-rich-admin-service/data/json";
        }

        //区分模块路径
        if(!OssUtil.checkImgModule(module)){
            log.info("module is nto exist");
            model.addAttribute("code",-6002);
            return "/academy-rich-admin-service/data/json";
        }

        //判断文件类型
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));

        if(!OssUtil.checkImgType(type)){
            log.info("picture type error");
            model.addAttribute("code",-6003);
            return "/academy-rich-admin-service/data/json";
        }

        try {
            //初始化oss客户端
            OSSClient ossClient=OssUtil.getOssClient();
            //文件输入流
            InputStream inputStream = file.getInputStream();
            //根据模块划分，并统一图片路径
            String filePath = module+"/"+new Date().getTime()+String.valueOf(file.getOriginalFilename());
            //返回图片url
            String imgUrl = OssUtil.UploadPictureByInputStream(ossClient,filePath,inputStream);

            model.addAttribute("url",imgUrl);
            model.addAttribute("code",0);

        } catch (IOException e) {
            log.info("picture upload failure");
            e.printStackTrace();
            model.addAttribute("code",-6004);
            return "/academy-rich-admin-service/data/json";
        }
        return "/academy-rich-admin-service/article/json/successJson";
    }
}
