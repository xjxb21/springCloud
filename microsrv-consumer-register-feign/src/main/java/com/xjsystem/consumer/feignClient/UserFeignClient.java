package com.xjsystem.consumer.feignClient;

import com.xjsystem.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * feign client
 * 注解FeignClient 表示要调用的服务名称
 */
@FeignClient(name = "microsrv-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    User getUser4Feign(@PathVariable("userId") String userId);

    @RequestMapping(value = "/user/postUser", method = RequestMethod.POST)
    User postUser4Feign(@RequestParam("userId") String userId);

    @RequestMapping(value = "/user/postUser4pojo", method = RequestMethod.POST)
    User postUser4FeignPojo(@RequestBody User user);

    @RequestMapping(value = "/user/postUser4pojo2", method = RequestMethod.POST)
    User postUser4FeignPojo2(@RequestBody User user, @RequestParam("randomStr") String randomStr);

}