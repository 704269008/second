package com.ptteng.academy.rich.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
    public static String md5Encrypt(String password,String salt){
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
        return encodedPassword;
    }
}
