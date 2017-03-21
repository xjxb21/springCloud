package com.xjsystem.controller;

import com.xjsystem.entity.User;
import com.xjsystem.service.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiao on 2017/3/13.
 * 用户接口服务
 */

@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    UserSrv userSrv;

    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String userId) {
        return userSrv.getUser(userId);
    }

    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public User findUser4Post(@RequestParam("userId") String userId) {
        return userSrv.getUser(userId);
    }

    /**
     * feign client 在POST这个URL时，将USER对象转换成了JSON格式提交
     *
     * @param user 必须现实使用@RequestBody注解处理数据，否则获取为空
     */
    @RequestMapping(value = "/postUser4pojo", method = RequestMethod.POST)
    public User findUser4PostPojo(@RequestBody User user) {
        System.out.println(user.toString());
        return userSrv.getUser4Pojo(user);
    }

    @RequestMapping(value = "/postUser4pojo2", method = RequestMethod.POST)
    public User findUser4PostPojo2(@RequestBody User user, @RequestParam String randomStr) {
        System.out.println(user.toString() + "--------" + randomStr);
        return userSrv.getUser4Pojo(user);
    }
}
