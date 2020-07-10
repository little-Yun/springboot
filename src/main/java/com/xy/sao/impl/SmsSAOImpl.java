package com.xy.sao.impl;

import com.alibaba.fastjson.JSONObject;
import com.xy.config.PortalHttpRequest;
import com.xy.http.PortalHttpClient;
import com.xy.sao.SmsSAO;
import com.xy.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
@Component
public class SmsSAOImpl implements SmsSAO {
    @Value("spring.sms.template.code")
    private String templateCode;
    @Value("spring.sms.template.signName")
    private String signName;
    @Value("spring.sms.template.accessKeyId")
    private String accessKeyId;
    @Autowired
    private PortalHttpClient client;

    @Override
    public String sendSms(Map<String, Object> params) {
        PortalHttpRequest request = PortalHttpRequest.buildGet(getSendSmsRequestUrl(params));
        String resultStr = client.execute(request, String.class);
        if (StringUtils.isEmpty(resultStr)) {
            return null;
        }

        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        // 请求状态码。返回OK代表请求成功,其他表示失败
        String code = jsonObject.getString("Code");
        // 发送回执ID，可根据该ID在接口QuerySendDetails中查询具体的发送状态。
        String BizId = jsonObject.getString("BizId");
        // 状态码描述信息
        String message = jsonObject.getString("Message");
        // 请求ID
        String RequestId = jsonObject.getString("RequestId");
        if ("OK".equals(jsonObject.getString("code"))) {
            log.info("sms send sucess!");
            return SmsSAOImpl.SmsConstants.SMS_SEND_SUCESS;
        } else {
            log.info("sms send fail");
            return SmsSAOImpl.SmsConstants.SMS_SEND_FAIL;
        }
    }

    private String getSendSmsRequestUrl(Map<String, Object> params) {
        String hostUrl = SmsSAOImpl.SmsConstants.ALIYUN_SMS_HOST_URL;
        StringBuffer sub = new StringBuffer();
        sub.append(hostUrl).append("?").append("PhoneNumbers=").append(MapUtils.getString(params, "PhoneNumbers"));
        sub.append("SignName=").append(signName);
        sub.append("TemplateCode=").append(templateCode);
        sub.append("AccessKeyId=").append(accessKeyId);
        sub.append("Action=").append("SendSms");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", SmsUtil.getRandomCode());
        String templateParam = null;
        sub.append("TemplateParam=").append(jsonObject.toJSONString());
        return sub.toString();
    }

    public static class SmsConstants {
        public static final String ALIYUN_SMS_HOST_URL = "dysmsapi.aliyuncs.com";

        public static final String SMS_SEND_SUCESS = "200";

        public static final String SMS_SEND_FAIL = "555";
    }
}
