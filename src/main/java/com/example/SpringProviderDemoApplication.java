package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringProviderDemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringProviderDemoApplication.class, args);
		new SpringApplicationBuilder(SpringProviderDemoApplication.class).web(true).run(args);
	}
}
