package com.dcb.springboot_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootMongodbApplication {

	public static void main(String[] args) {
		System.out.println("added");
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

}
