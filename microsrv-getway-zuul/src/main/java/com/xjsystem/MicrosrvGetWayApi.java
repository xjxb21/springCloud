package com.xjsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableZuulProxy
public class MicrosrvGetWayApi {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvGetWayApi.class, args);
    }

    /**
     * ZUUL 映射路由支持正则表达式，推荐使用，主要用于版本号的区分
     * 版本好 在application.name 中表示
     * 如： appxxxx-v1 会被映射为 v1/appxxxx 的形式
     *
     * 如果application.name中没有写入版本号，那么该配置无效，路由的地址还是 /appxxxx
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }
}
