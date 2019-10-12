package com.xy.study.asynthreadpool.service.impl;

import com.xy.study.asynthreadpool.service.AsynService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynServiceImpl  implements AsynService
{
    @Async
    @Override
    public String test() {
        return "异步线程测试～～～！";
    }
}
