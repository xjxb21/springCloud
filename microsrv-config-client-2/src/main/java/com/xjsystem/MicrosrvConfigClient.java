package com.xjsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RefreshScope   //动态刷新bean
public class MicrosrvConfigClient {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvConfigClient.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "spring cloud config client";
    }

    //测试Profile的获取值
    @Value("${profile}")
    private String profile;

    @RequestMapping("/getProfile")
    public String getProfile() {
        return this.profile;
    }

    //测试Profile的获取值
    @Value("${profile2}")
    private String profile2;

    @RequestMapping("/getProfile2")
    public String getProfile2() {
        return this.profile2;
    }
}
