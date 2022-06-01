package com.ms.majorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MajorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajorServiceApplication.class, args);
	}

}
