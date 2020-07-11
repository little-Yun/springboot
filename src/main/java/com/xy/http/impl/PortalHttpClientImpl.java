package com.xy.http.impl;

import com.xy.config.HttpConfig;
import com.xy.config.PortalHttpRequest;
import com.xy.http.PortalHttpClient;
import com.xy.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class PortalHttpClientImpl implements PortalHttpClient {

    private RestTemplate restTemplate;

    @Autowired
    private HttpConfig httpConfig;

    @PostConstruct
    public void init() {
        if (null != httpConfig) {
            restTemplate = construct(httpConfig);
        }
    }

    @Override
    public <T> T execute(PortalHttpRequest portalHttpRequest, Class<T> cla) {
        log.info("请求地址:{}, 请求参数:{}", portalHttpRequest.getRequstUrl(), portalHttpRequest.getParams());

        HttpEntity entity = this.getEntity(portalHttpRequest);
        T result = null;
        int resultCode = 0;
        for (int i = 0; i <= httpConfig.getRetryTimes(); i++) {
            try {
                ResponseEntity responseEntity = restTemplate.exchange(portalHttpRequest.getRequstUrl(), portalHttpRequest.getHttpMethod(), entity, cla);
                resultCode = responseEntity.getStatusCodeValue();
                result = (T) responseEntity.getBody();
            } catch (Exception e) {
                log.error("request remote api exception:", e);

                if (httpConfig.getRetryTimes() > i) {
                    log.info("继续尝试请求 第{}次", i);
                    continue;
                }

                log.info("超过尝试请求次数，请求失败");
                break;
            }

            log.info("请求地址:{}, 响应code:{}, 结果:{}", portalHttpRequest.getRequstUrl(), resultCode, result);
            return result;
        }
        return null;
    }

    public HttpEntity getEntity(PortalHttpRequest portalHttpRequest) {
        StringHttpMessageConverter t = new StringHttpMessageConverter();
        t.setWriteAcceptCharset(false);//设置为false就可以修改header中的accept-charset属性
        restTemplate.getMessageConverters().add(0, t);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        return requestEntity;
    }

    private RestTemplate construct(HttpConfig httpConfig) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 单位为ms
        factory.setReadTimeout(httpConfig.getSocketTimeOut());
        // 单位为ms
        factory.setConnectTimeout(httpConfig.getConnectionTimeOut());

        return new RestTemplate(factory);
    }
}
