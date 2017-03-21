package com.xjsystem.consumer.service;

import com.xjsystem.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiao on 2017/3/13.
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
    public User getUser(String userName) {
        User user = restTemplate.getForObject("http://microsrv-provider-user/user/getUser/" + userName, User.class);
        return user;
    }
}
