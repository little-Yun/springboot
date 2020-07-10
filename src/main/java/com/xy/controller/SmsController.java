package com.xy.controller;

import com.xy.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @ResponseBody
    @RequestMapping("/sendSms")
    public String sendSms(String mobileNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("PhoneNumbers", mobileNo);
        return smsService.sendSms(params);
    }
}
