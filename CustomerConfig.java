package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CustomerConfig {


    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository) {
        return args -> {
           Customer kayla = new  Customer(
                    "kayla",
                    "kaylajuma@gmail.com",
                    LocalDate.of(2001, MAY, 3)
            );
            Customer Yohane = new  Customer(
                    "Yohane",
                    "kayla@gmail.com",
                    LocalDate.of(2002, MAY, 3)
            );

            repository.toString();

        };
    }

//    @Primary
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
}
