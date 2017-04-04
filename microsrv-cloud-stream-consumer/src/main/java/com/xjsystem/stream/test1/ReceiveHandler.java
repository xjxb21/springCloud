package com.xjsystem.stream.test1;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by xiao on 2017/4/3.
 */
@EnableBinding(MessageSink.class)
@Component
public class ReceiveHandler {

    @StreamListener(MessageSink.MESSAGE_SINK)
    public void show(String message) {
        try {
            System.out.println("receive message:" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
