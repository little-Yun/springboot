package com.xy.study.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 获取配置文件工具类
 */
@Slf4j
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
           log.error("loadProperties exception:" ,e);
        }

        if(null == pro){
            return null;
        }

        return pro.getProperty(propertyName);
    }

    public static void main(String[] args) {
        String value = PropertiesUtils.getPropertiseVule("ipconfig");
        System.out.print("value:" + value);
    }
}
