package com.xy.study.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 获取配置文件工具类
 */
public class PropertiesUtils {

    public static String PROPERTY_FILE = "config-properties";

    public static String getPropertiseVule(String propertyName){
        if(!StringUtils.hasText(propertyName)){
            return  null;
        }

        Properties pro = null;
        try {
            pro = PropertiesLoaderUtils.loadAllProperties(PROPERTY_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = pro.getProperty(propertyName);

        return value;
    }

    public static void main(String[] args) {
        String value = PropertiesUtils.getPropertiseVule("ipconfig");
        System.out.print("value:" + value);
    }
}
