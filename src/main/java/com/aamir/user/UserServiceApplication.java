package com.aamir.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {
	/*
	* Feign client is a declarative HTTP web client developed by netflix
	* create an interface, and annotate it then use it
	* */
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
