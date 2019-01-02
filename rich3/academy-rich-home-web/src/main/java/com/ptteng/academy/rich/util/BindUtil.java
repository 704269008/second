package com.ptteng.academy.rich.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BindUtil {

    private static final Log log = LogFactory.getLog(BindUtil.class);


    //阿里云短信服务

    private static String accessKeyId;
    private static String accessKeySecret;

    //初始化ascClient需要的几个参数
   private static final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
   private static final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）


    //sendCloud

    private static String url;
    private static String apiUser;
    private static String apiKey;
    private static String from;
    private static String fromName;
    private static String subject;

    public static void setAccessKeyId(String accessKeyId) {
        BindUtil.accessKeyId = accessKeyId;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        BindUtil.accessKeySecret = accessKeySecret;
    }

    /**
    * @Description:    发送手机短信验证码
    * @Author:         zhh
    * @CreateDate:     2018/11/27 15:56
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/27 15:56
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static String sendMessageCode(String phone, String code){

        log.info("begin send Message");
        //生成6位验证码
//        String code = String.valueOf(Math.random()).substring(2, 8);
//        log.info(code);

        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("技能树");
            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
            request.setTemplateCode("SMS_151910385");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
            request.setTemplateParam("{\"code\":\"CODE\"}".replace("CODE",code));
            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            //请求失败这里会抛ClientException异常
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                log.info("短信接口返回的数据----------------");
                log.info("Code=" + sendSmsResponse.getCode());
                log.info("Message=" + sendSmsResponse.getMessage());
                log.info("RequestId=" + sendSmsResponse.getRequestId());
                log.info("BizId=" + sendSmsResponse.getBizId());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
       return code;
    }

    /**
    * @Description:    发送邮箱验证码
    * @Author:         zhh
    * @CreateDate:     2018/11/27 15:57
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/27 15:57
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    public static String sendEmailCode(String email, String code) throws IOException {
        //生成6位验证码
//        String code = String.valueOf(Math.random()).substring(2, 8);


        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httPost = new HttpPost(url);

        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser",apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", from));
        params.add(new BasicNameValuePair("fromName", fromName));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", code));
        httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httPost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.err.println("error");
        }
        httPost.releaseConnection();
        return code;
    }

    public static void setUrl(String url) {
        BindUtil.url = url;
    }

    public static void setApiUser(String apiUser) {
        BindUtil.apiUser = apiUser;
    }

    public static void setFrom(String from) {
        BindUtil.from = from;
    }

    public static void setApiKey(String apiKey) {
        BindUtil.apiKey = apiKey;
    }

    public static void setFromName(String fromName) {
        BindUtil.fromName = fromName;
    }

    public static void setSubject(String subject) {
        BindUtil.subject = subject;
    }
}
