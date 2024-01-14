package com.lltech.llmall.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {



    @Bean
    public OpenAPI getDocket() {
        Info info = new Info().title("《林联商城》后端接口说明")
                        .description("此文档详细说明了林联商城项目后端接口规范")
                        .version("v 2.0.1")
                        .contact(new Contact()
                                .name("linmu")
                                .url("www.ll.com")
                                .email("ll@ll.com"));


        return new OpenAPI().info(info).externalDocs(new ExternalDocumentation()
                .description("SpringDoc Wiki Documentation")
                .url("https://springdoc.org/v2"));
    }


}
