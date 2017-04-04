package com.xjsystem.stream.test1;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by xiao on 2017/4/3.
 */
public interface MessageSource {

    String MESSAGE_SOURCE = "message-source";

    @Output(MessageSource.MESSAGE_SOURCE)
    MessageChannel output();
}
