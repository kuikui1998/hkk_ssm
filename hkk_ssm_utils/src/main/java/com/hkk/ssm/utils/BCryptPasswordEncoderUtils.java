package com.hkk.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @auther kuikui
 * @create 2020-07-15 13:23
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
       return bCryptPasswordEncoder.encode(password);
    }


    public static void main(String[] args) {
        String password = "456";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}
