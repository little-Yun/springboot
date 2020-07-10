package com.xy.service.impl;

import com.xy.sao.SmsSAO;
import com.xy.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsSAO smsSAO;

    @Override
    public String sendSms(Map<String, Object> params) {
        return smsSAO.sendSms(params);
    }

}
