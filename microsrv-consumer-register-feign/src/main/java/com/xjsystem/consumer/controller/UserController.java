package com.xjsystem.consumer.controller;

import com.xjsystem.consumer.entity.User;
import com.xjsystem.consumer.feignClient.UserFeignClient;
import com.xjsystem.consumer.feignClient.UserFeignClient4Config;
import com.xjsystem.consumer.feignClient.UserFeignClientWithHystrix;
import com.xjsystem.consumer.service.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiao on 2017/3/13.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserFeignClient userFeignClient;

    /**
     * 更具ID获取用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String userId) {
        return userFeignClient.getUser4Feign(userId);
    }


    /**
     * Post data
     * @param userId
     * @return
     */
    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public User findUser4Post(@RequestParam("userId") String userId) {
        System.out.println("post url");
        return userFeignClient.postUser4Feign(userId);
    }

    /**
     * example Post Json
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/postUserPojo", method = RequestMethod.POST)
    public User findUser4PostPojo(@RequestBody User user) {
        System.out.println(user.toString());
        return userFeignClient.postUser4FeignPojo(user);
    }

    /**
     * example Post Json
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/postUserPojo2", method = RequestMethod.POST)
    public User findUser4PostPojo2(@RequestBody User user, @RequestParam("hello") String hello) {
        System.out.println(user.toString());
        String str = hello;
        return userFeignClient.postUser4FeignPojo2(user, str);
    }

    @Autowired
    UserFeignClient4Config userFeignClient4Config;

    /**
     * example use configuration feign
     */
    @RequestMapping(value = "/postUser2", method = RequestMethod.POST)
    public User findUser4PostUseFeignConfig(@RequestParam("userId") String userId) {
        System.out.println("invoke findUser4PostUseFeignConfig..");
        return userFeignClient4Config.getUser4Feign(userId);
    }
}
