package com.study.mq.demo;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者.
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年8月23日
 */
@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        System.out.println(text);
    }
}
