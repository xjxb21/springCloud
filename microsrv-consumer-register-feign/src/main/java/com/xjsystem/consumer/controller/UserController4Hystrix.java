package com.xjsystem.consumer.controller;

import com.xjsystem.consumer.entity.User;
import com.xjsystem.consumer.feignClient.UserFeignClientWithHystrix;
import com.xjsystem.consumer.feignClient.UserFeignClientWithHystrixFallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiao on 2017/3/18.
 */
@RestController
@RequestMapping("/user")
public class UserController4Hystrix {

    @Qualifier("feignClientWithHystrix")    //当前版本IDE不支持feign与Hystrix的注解？
    @Autowired
    UserFeignClientWithHystrix userFeignClientWithHystrix;

    @Qualifier("feignClientWithHystrixWithFallbackFactory")
    @Autowired
    UserFeignClientWithHystrixFallbackFactory userFeignClientWithHystrixFallbackFactory;

    /**
     * use Hystrix feign client
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUser4HystrixFeignClient/{userId}", method = RequestMethod.GET)
    public User findUser4HystrixFeignClient(@PathVariable("userId") String userId) {
        return userFeignClientWithHystrix.getUser4Feign(userId);
    }

    /**
     * use Hystrix feign client, when error, call UserFeignClientWithHystrixFallbackFactory
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUser4HystrixFeignClientWithCallbackFactory/{userId}", method = RequestMethod.GET)
    public User findUser4HystrixFeignClientWithCallbackFactory(@PathVariable("userId") String userId) {
        return userFeignClientWithHystrixFallbackFactory.getUser4Feign(userId);
    }

    
}
