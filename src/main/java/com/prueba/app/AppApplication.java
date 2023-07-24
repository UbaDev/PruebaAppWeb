package com.prueba.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		Logger logger = LoggerFactory.getLogger(AppApplication.class);

		logger.info("Mensaje informativo");
		logger.warn("Mensaje de advertencia");
		logger.error("Mensaje de error"); 
	}
	

}
