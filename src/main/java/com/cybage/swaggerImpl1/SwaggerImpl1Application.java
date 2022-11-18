package com.cybage.swaggerImpl1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
public class SwaggerImpl1Application {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerImpl1Application.class, args);
	}

}
