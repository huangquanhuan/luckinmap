package com.coldsmog.luckinmap.common.utils;

import java.security.MessageDigest;
import java.util.Random;


/**
 * @Description: MD5 加盐保密
 * @Author: https://blog.csdn.net/qq_39135287/article/details/82012441
 * @Date: 2019/9/11 14:38
 */
public class Md5Util {
    private final static Integer STEP = 3;
    private final static Integer RANDOM_DIGIT_LENGTH = 16;
    private final static Integer MD5_LENGTH = 32;
    private final static Integer SALT_LENGTH = 48;

    /**
     * byte[]字节数组 转换成 十六进制字符串
     *
     * @param arr 要转换的byte[]字节数组
     * @return String 返回十六进制字符串
     */
    public static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

    /**
     * MD5加密,字符串转换成十六进制字符串
     *
     * @param str 要加密的内容
     * @return String 返回加密后的十六进制字符串
     */
    public static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return hex(digest);
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 生成含有随机盐的密码
     *
     * @param password 要加密的密码
     * @return String 含有随机盐的密码
     */
    public static String getEncryptedPwd(String password) {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(RANDOM_DIGIT_LENGTH);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < RANDOM_DIGIT_LENGTH) {
            for (int i = 0; i < RANDOM_DIGIT_LENGTH - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String salt = sBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[SALT_LENGTH];
        for (int i = 0; i < SALT_LENGTH; i += STEP) {
            cs[i] = password.charAt(i / STEP * 2);
            char c = salt.charAt(i / STEP);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / STEP * 2 + 1);
        }
        return String.valueOf(cs);
    }


    /**
     * 验证加盐后是否和原密码一致
     *
     * @param password 原密码
     * @param md5str   加密之后的密码
     * @return boolean true表示和原密码一致   false表示和原密码不一致
     */
    public static boolean validPassword(String password, String md5str) {
        char[] cs1 = new char[MD5_LENGTH];
        char[] cs2 = new char[RANDOM_DIGIT_LENGTH];
        for (int i = 0; i < SALT_LENGTH; i += STEP) {
            cs1[i / STEP * 2] = md5str.charAt(i);
            cs1[i / STEP * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / STEP] = md5str.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(String.valueOf(cs1));
    }
}


