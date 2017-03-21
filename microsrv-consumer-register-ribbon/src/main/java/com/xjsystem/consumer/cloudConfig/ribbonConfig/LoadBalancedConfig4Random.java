package com.xjsystem.consumer.cloudConfig.ribbonConfig;

import cloudConfig.RibbonRandomConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @RibbonClient(name = "microsrv-provider-user", configuration = RibbonRandomConfiguration.class)
 * 属性 name 为eureka上的 application name,使用中区分大小写
 */

@Configuration
@RibbonClient(name = "microsrv-provider-user", configuration = RibbonRandomConfiguration.class)
public class LoadBalancedConfig4Random {

    //普通restTemplate
    @Bean(name = "commonRestTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //定义一个random的负载平衡器
    @LoadBalanced
    @Bean(name = "balancedRestTemplate4Random")
    public RestTemplate getLoadBalancedRestTemplate() {
        return new RestTemplate();
    }
}
