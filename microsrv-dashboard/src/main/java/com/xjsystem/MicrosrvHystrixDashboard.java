package com.xjsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class MicrosrvHystrixDashboard {

	public static void main(String[] args) {
		SpringApplication.run(MicrosrvHystrixDashboard.class, args);
	}
}
