package com.zoorb.zoomanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.zoorb.zoomanagement","com.zoorb.controllers","com.zoorb.model","com.zoorb.repository","com.zoorb.services"})
@EnableJpaRepositories(basePackages = "com.zoorb.repository")
@EntityScan("com.zoorb.model")
public class ZoomanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoomanagementApplication.class, args);
	}

}
