package com.qualigy.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	Logger logger = LoggerFactory.getLogger(GatewayApplication.class);
	public static void main(String[] args) {

		GatewayApplication obj = new GatewayApplication();
		obj.logMethod();
		SpringApplication.run(GatewayApplication.class, args);
	}
	public void logMethod(){
		logger.info("API gateway received the request ...");
	}

}
