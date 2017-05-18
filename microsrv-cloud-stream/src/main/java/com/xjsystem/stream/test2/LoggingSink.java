package com.xjsystem.stream.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by xiao on 2017/4/3.
 */
@Service
@EnableBinding(MessageSource.class)
public class SendService {

    private MessageSource messageSource;

    @Autowired
    public SendService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 传递字符串
     * @param message
     */
    public void sendMessage(String message) {
        try {
            messageSource.output().send(MessageBuilder.withPayload(message).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}