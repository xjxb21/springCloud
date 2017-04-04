package com.xjsystem.stream.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiao on 2017/4/3.
 */

@RestController
public class TestController {

    @Autowired
    SendService sendService;

    /**
     * 测试调用
     * /testStream?msg=abcdefg
     * @param msg
     * @return
     */
    @RequestMapping("/testStream")
    public String test(@RequestParam("msg") String msg) {
        sendService.sendMessage(msg);
        return "invoked";
    }
}
