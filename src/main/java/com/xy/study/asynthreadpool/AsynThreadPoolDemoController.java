package com.xy.study.asynthreadpool;

import com.xy.study.asynthreadpool.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步线程池 demo
 */
@RestController
public class AsynThreadPoolDemoController {

    @Autowired
    private AsynService asynService;

    @RequestMapping("/asynThreadPoolDemo")
    @ResponseBody
    public String asynTest(){
        return asynService.test();
    }
}
