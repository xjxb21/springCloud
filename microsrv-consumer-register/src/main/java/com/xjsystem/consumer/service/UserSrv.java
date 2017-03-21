package com.xjsystem.consumer.service;

import com.xjsystem.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiao on 2017/3/13.
 * 用户服务
 */
@Service
public class UserSrv {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User getUser(String userName) {
        User user = restTemplate.getForObject("http://localhost:7080/user/getUser/"+userName, User.class);
        return user;
    }
}
