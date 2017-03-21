package com.xjsystem.consumer.feignClient.fallback;

import com.xjsystem.consumer.entity.User;
import com.xjsystem.consumer.feignClient.UserFeignClientWithHystrix;
import org.springframework.stereotype.Component;

/**
 * Hystrix fall back
 */
@Component
public class MyHystrixFallback implements UserFeignClientWithHystrix{
    @Override
    public User getUser4Feign(String userId) {
        System.out.println(this.hashCode());
        User user = new User();
        user.setUserName("error");
        user.setAge(-1);
        return user;
    }

    @Override
    public User postUser4Feign(String userId) {
        return null;
    }

    @Override
    public User postUser4FeignPojo(User user) {
        return null;
    }

    @Override
    public User postUser4FeignPojo2(User user, String randomStr) {
        return null;
    }
}
