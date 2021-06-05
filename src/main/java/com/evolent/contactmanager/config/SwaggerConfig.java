package com.evolent.contactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ContactManager").apiInfo(metadata())
                .select()
                .paths(PathSelectors.ant("/v1/**")).build().pathMapping("/");

    }

    private ApiInfo metadata(){
        return new ApiInfoBuilder().title("SpringBoot Rest API - ContactManager")
                .description("Rest Api Documentation for Contact Manager").version("0.0.1")
                .contact(new Contact("Avijit Kundu", "","k.avijit01@gmail.com")).build();
    }
}
