package com.xjsystem.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xjsystem.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 用户服务
 */
@Service
public class UserSrv {

    @Autowired
    @Qualifier("balancedRestTemplate4Random")
    RestTemplate restTemplate;

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public User getUser(String userName) {
        System.out.println("123123123");
        User user = restTemplate.getForObject("http://microsrv-provider-user/user/getUser/" + userName, User.class);
        return user;
    }

    public User getUserFallback(String userName) {
        System.out.println("fall back call...");
        return null;
    }
}
