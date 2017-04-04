package com.xjsystem.consumer.feignClient.fallback;

import com.xjsystem.consumer.entity.User;
import com.xjsystem.consumer.feignClient.UserFeignClientWithHystrixFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用 fallback factory 获取异常信息
 */
@Component
public class MyHystrixFallbackFactory implements FallbackFactory<UserFeignClientWithHystrixFallbackFactory> {

    private static final Logger logger = LoggerFactory.getLogger(MyHystrixFallbackFactory.class);

    @Override
    public UserFeignClientWithHystrixFallbackFactory create(Throwable throwable) {

        logger.info("MyHystrixFallbackFactory:{}",throwable.getMessage());

        return new HystrixClientWithFallBackFactory() {
            @Override
            public User getUser4Feign(String userId) {
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
        };
    }
}
