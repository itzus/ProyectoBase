package com.asw.test.app.base.config;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan("com.asw.test.app")
@EnableAsync
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class AppTestConfig {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.asw.test.app.base.controller"))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Aplicativo Base", 
	      "Some custom description of API.", 
	      "API Base", 
	      "Terms of service", 
	      new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
