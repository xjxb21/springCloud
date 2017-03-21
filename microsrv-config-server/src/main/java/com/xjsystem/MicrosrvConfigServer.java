package com.xjsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * web 访问格式
 /{application}/{profile}[/{label}]
 /{application}-{profile}.yml
 /{label}/{application}-{profile}.yml
 /{application}-{profile}.properties
 /{label}/{application}-{profile}.properties
 */

@SpringBootApplication
@RestController
@EnableConfigServer
public class MicrosrvConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(MicrosrvConfigServer.class, args);
	}

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

}
