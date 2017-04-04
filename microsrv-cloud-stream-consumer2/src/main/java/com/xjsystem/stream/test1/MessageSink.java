package com.xjsystem.stream.test1;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by xiao on 2017/4/3.
 */
public interface MessageSink {

    String MESSAGE_SINK = "message-sink";

    @Input(MessageSink.MESSAGE_SINK)
    MessageChannel input();
}
