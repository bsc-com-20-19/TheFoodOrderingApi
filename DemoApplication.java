package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.function.Predicate;


@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Primary
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())

				.build()
				.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"food ordering api ",
				"its an website where you can order food online anywhere at anytime",	"6.0",
				"Terms of service",
				new Contact("Chikondi juma", "", "bsc-com-20-19@unima.ac.mw"),
				"License of API", "API license URL", Collections.emptyList());
	}
}
