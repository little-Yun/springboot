package com.xy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.httpconfig")
public class HttpConfig {
    /**
     * 请求尝试次数
     **/
    private int retryTimes;

    /**
     * 链接超时时间
     **/
    private int connectionTimeOut;

    /**
     * 响应超时时间
     **/
    private int socketTimeOut;
}
