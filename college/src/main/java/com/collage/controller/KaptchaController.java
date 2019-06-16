package com.collage.controller;


import com.collage.utils.util.FileUtil;
import com.collage.utils.util.GunsProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码生成
 *
 * @author fengshuonan
 * @date 2017-05-05 23:10
 */
@Controller
@RequestMapping("/kaptcha")
public class KaptchaController {

    GunsProperties gunsProperties = new GunsProperties();

    /**
     * 返回图片
     *
     * @author stylefeng
     * @Date 2017/5/24 23:00
     */
    @RequestMapping("/{pictureId}")
    public void renderPicture(@PathVariable("pictureId") String pictureId, HttpServletResponse response) {

        String path = gunsProperties.getFileUploadPath() + pictureId + ".jpg";

        try {
            byte[] bytes = FileUtil.toByteArray(path);
            response.getOutputStream().write(bytes);
        }catch (Exception e){
            //如果找不到图片就返回一个默认图片
            try {
                response.sendRedirect("/static/img/girl.gif");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
