package com.xy.sao.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.xy.sao.SmsSAO;
import com.xy.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SmsSAOImpl implements SmsSAO {
    @Value("${spring.sms.template.code}")
    private String templateCode;
    @Value("${spring.sms.template.signName}")
    private String signName;
    @Value("${spring.sms.template.accessKeyId}")
    private String accessKeyId;
    @Value("${spring.sms.template.accessKeySecret}")
    private String accessKeySecret;


    @Override
    public String sendSms(Map<String, Object> params) {
        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        } catch (ClientException e) {
            log.error("addEndpoint ClientException:", e);
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        String phoneNumbers = MapUtils.getString(params, "phoneNumbers");
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumbers);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "123456");
        request.setTemplateParam(jsonObject.toJSONString());

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");

        // hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (null == sendSmsResponse) {
                log.info("sms 短信发送异常");
                return null;
            }

            log.info("sendSmsResponse:{}", JSONObject.toJSONString(sendSmsResponse));
            // 请求状态码。返回OK代表请求成功,其他表示失败
            String code = sendSmsResponse.getCode();
            // 发送回执ID，可根据该ID在接口QuerySendDetails中查询具体的发送状态。
            String BizId = sendSmsResponse.getBizId();
            // 状态码描述信息
            String message = sendSmsResponse.getMessage();
            // 请求ID
            String RequestId = sendSmsResponse.getRequestId();
            if ("OK".equals(code)) {
                log.info("sms send sucess!");
                return SmsSAOImpl.SmsConstants.SMS_SEND_SUCESS;
            } else {
                log.info("sms send fail");
                return SmsSAOImpl.SmsConstants.SMS_SEND_FAIL;
            }
        } catch (ClientException e) {
            log.error("send smsException:", e);
        }

        return null;
    }

    private String getSendSmsRequestUrl(Map<String, Object> params) {
        String hostUrl = SmsSAOImpl.SmsConstants.ALIYUN_SMS_HOST_URL;
        StringBuffer sub = new StringBuffer();
        sub.append(hostUrl).append("?").append("PhoneNumbers=").append(MapUtils.getString(params, "PhoneNumbers"));
        sub.append("&SignName=").append(signName);
        sub.append("&TemplateCode=").append(templateCode);
        sub.append("&AccessKeyId=").append(accessKeyId);
        sub.append("&Action=").append("SendSms");
        sub.append("&TemplateParam=").append(SmsUtil.getRandomCode());
        return sub.toString();
    }

    public static class SmsConstants {
        public static final String ALIYUN_SMS_HOST_URL = "http://dysmsapi.aliyuncs.com";

        public static final String SMS_SEND_SUCESS = "200";

        public static final String SMS_SEND_FAIL = "555";
    }
}
