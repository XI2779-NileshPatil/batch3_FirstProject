package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		System.out.println(LocalDate.now().getDayOfWeek());
//		System.out.println(LocalDate.of(2021, 1, 1).lengthOfMonth());
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	   return new WebMvcConfigurerAdapter() {
//		   @Override
//		      public void addCorsMappings(CorsRegistry registry) {
//		         registry.addMapping("/hello").allowedOrigins("http://localhost:4200");
//		      } 
//	};
//	}
}
