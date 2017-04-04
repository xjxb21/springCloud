package com.xjsystem.stream.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiao on 2017/4/3.
 */
@Service
@EnableBinding(MessageSource.class)
public class SendService {

    private MessageSource messageSource;

    private static final AtomicInteger num = new AtomicInteger(0);

    @Autowired
    public SendService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 传递字符串
     *
     * @param message
     */
    public void sendMessage(String message) {
        try {
            messageSource.output().send(MessageBuilder.withPayload(message + ">>>" + String.valueOf(num.incrementAndGet())).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}