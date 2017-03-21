package com.xjsystem.service;

import com.xjsystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by xiao on 2017/3/13.
 */
@Service
public class UserSrv {

    public User getUser(String userId) {
        String s = UUID.randomUUID().toString();
        System.out.println("invoke userSrv..." + s);
        User user = new User();
        user.setUserName(s);
        user.setAge(99);
        return user;
    }

    public User getUser4Pojo(User user) {
        String s = UUID.randomUUID().toString();
        System.out.println("invoke getUser4Pojo userSrv..." + s);
        user.setUserName(user.getUserName() + ":" + s);
        user.setAge(user.getAge() + 2);
        return user;
    }
}
