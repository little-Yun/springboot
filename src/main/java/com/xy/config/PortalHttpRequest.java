package com.xy.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 * 请求封装类
 */
@Data
public class PortalHttpRequest {

    private String requstUrl;

    private HttpMethod httpMethod;

    private Map<String, Object> params;

    PortalHttpRequest(HttpMethod httpMethod, String requstUrl) {
        this.httpMethod = httpMethod;
        this.requstUrl = requstUrl;
    }

    PortalHttpRequest(HttpMethod httpMethod, String requstUrl, Map<String, Object> params) {
        this.httpMethod = httpMethod;
        this.requstUrl = requstUrl;
        this.params = params;
    }

    public static PortalHttpRequest buildGet(String requstUrl) {
        return new PortalHttpRequest(HttpMethod.GET, requstUrl);
    }

    public static PortalHttpRequest buildPost(String requstUrl, Map<String, Object> params) {
        return new PortalHttpRequest(HttpMethod.POST, requstUrl, params);
    }
}
