package com.xjsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class MicrosrvDiscoveryEurekaPeer3 {

	public static void main(String[] args) {
		SpringApplication.run(MicrosrvDiscoveryEurekaPeer3.class, args);
	}
}
