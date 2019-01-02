package com.ptteng.academy.rich.util;

import com.aliyun.oss.OSSClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
* @Description:    oss对象存储工具类
* @Author:         zhh
* @CreateDate:     2018/11/20 17:31
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/20 17:31
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class OssUtil {
    private static String endpoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    private static String realmName;


    //oss初始化
    public  static OSSClient getOssClient(){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    //判断图片类型
    public static boolean checkImgType(String type){
        String[] typeList = {".bmp",".png",".gif",".jpg",".JPG"};
        return Arrays.asList(typeList).contains(type);
    }

    //区别图片类型
    public static boolean checkImgModule(String module){
        String[] moduleList = {"article","video","user","teacher"};
        return Arrays.asList(moduleList).contains(module);
    }


    public static String UploadPictureByInputStream(OSSClient ossClient,String filePath, InputStream inputStream) throws IOException {
        //上传到oss
        ossClient.putObject(bucketName,filePath,inputStream);
        //关闭输入流
        inputStream.close();
        //关闭客户端
        closeOosClient(ossClient);

        //获取oss存储的图片url
        String imgUrl = realmName + filePath;

        return imgUrl;
 }

    //oss关闭
    public  static void closeOosClient(OSSClient ossClient){
        ossClient.shutdown();
    }

    public static void setEndpoint(String endpoint) {
        OssUtil.endpoint = endpoint;
    }

    public static void setAccessKeyId(String accessKeyId) {
        OssUtil.accessKeyId = accessKeyId;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        OssUtil.accessKeySecret = accessKeySecret;
    }

    public static void setBucketName(String bucketName) {
        OssUtil.bucketName = bucketName;
    }


    public static void setRealmName(String realmName) {
        OssUtil.realmName = realmName;
    }
}
