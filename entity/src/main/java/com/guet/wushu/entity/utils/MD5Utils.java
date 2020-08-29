package com.guet.wushu.entity.utils;

import java.security.MessageDigest;

/**
 * @ClassName MD5Utils
 * @Author asus
 * @Version 1.0
 * MD5工具类
 */
public class MD5Utils {

    /**
     * 对密码进行加密
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) |
                        0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
