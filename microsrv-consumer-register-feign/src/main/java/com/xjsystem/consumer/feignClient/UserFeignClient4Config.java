package com.xjsystem.consumer.feignClient;

import cloudConfig.FeignConfig;
import com.xjsystem.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * feign client
 * 注解FeignClient 表示要调用的服务名称
 */
@FeignClient(name = "microsrv-provider-user", configuration = FeignConfig.class)
public interface UserFeignClient4Config {

    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    User getUser4Feign(@PathVariable("userId") String userId);

}