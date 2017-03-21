package com.xjsystem.consumer.controller;

import com.xjsystem.consumer.entity.User;
import com.xjsystem.consumer.service.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiao on 2017/3/13.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserSrv userSrv;

    public User register(User user) {
        return null;
    }

    /**
     * 更具ID获取用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String userId) {
        return userSrv.getUser(userId);
    }

    /**
     * 查找用户是否存在
     *
     * @param userId
     * @return
     */
    public boolean IsExists(String userId) {
        return false;
    }

    @Autowired
    LoadBalancerClient balancerClient;

    @RequestMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = balancerClient.choose("microsrv-provider-user");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return "1";
    }
}
