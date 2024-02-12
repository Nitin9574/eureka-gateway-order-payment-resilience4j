package com.qualigy.eureka_registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistryApplication {


	Logger logger = LoggerFactory.getLogger(EurekaRegistryApplication.class);
	public static void main(String[] args) {
		EurekaRegistryApplication obj = new EurekaRegistryApplication();
		obj.logmethod();
		SpringApplication.run(EurekaRegistryApplication.class, args);
	}

	public void logmethod(){
		logger.info("Eureka Service registry started on port 8761");
	}

}
