package com.xy.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegexTest {

    public static void main(String[] args) {
        // 匹配 1-9 长度为5至10位的数字
        String regex = "^[1-9]\\d{4,10}$";

        String str = "123121234511";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        boolean isMatch  = matcher.matches();
        System.out.println(isMatch);
    }
}
