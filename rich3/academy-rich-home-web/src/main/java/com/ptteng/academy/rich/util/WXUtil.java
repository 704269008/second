package com.ptteng.academy.rich.util;

import com.ksyun.ks3.utils.StringUtils;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * @Description: 微信公众号工具类，获取token和用户信息
 * @Author: zhh
 * @CreateDate: 2018/11/30 15:10
 * @UpdateUser: zhh
 * @UpdateDate: 2018/11/30 15:10
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WXUtil {

    private static final Log log = LogFactory.getLog(BindUtil.class);

    public static String AppID = "wx47a23d9a514c61a1";

    public static String AppSecret = "126bf4b23498bcdb9b534184221da5fb";





    /**
     * @Description: 获取包含sessionKey信息的对象,sessionKey是用户登录标识
     * @Author: zhh
     * @CreateDate: 2018/11/30 15:11
     * @UpdateUser: zhh
     * @UpdateDate: 2018/11/30 15:11
     * @UpdateRemark: 修改内容
     * @Version: 1.0
     */
    public  static JSONObject getSessionKeyOropenid(String code) throws IOException {
        log.info("begin get OAthInfo:");
        String wxUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        try {
            if (StringUtils.isBlank(code)) {
                log.info("code为空");
            } else {
                String requestUrl = wxUrl.replace("APPID", AppID).replace("SECRET", AppSecret).replace("JSCODE", code);
                JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
                log.info("jsonObject :"+jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
    * @Description:    解密用户敏感数据获取用户信息
    * @Author:         zhh
    * @CreateDate:     2018/12/1 16:56
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/12/1 16:56
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){
        log.info("begin get user info");
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.fromObject(result);
            }
        }catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidParameterSpecException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchProviderException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
