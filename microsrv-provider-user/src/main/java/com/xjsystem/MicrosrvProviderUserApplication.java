package com.xjsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//启用服务发现注册
@EnableDiscoveryClient
public class MicrosrvProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosrvProviderUserApplication.class, args);
	}

}
