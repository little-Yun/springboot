package com.xy.utils;

import java.util.Random;

public class SmsUtil {
    /**
     * 获取短信随机码
     *
     * @return
     */
    public static String getRandomCode() {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        return verifyCode;
    }
}
