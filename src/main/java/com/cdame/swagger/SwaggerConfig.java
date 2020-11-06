package com.cdame.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.nibr.controller")
public class SwaggerConfig {

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder().title("CUST PORTAL API").description("CUST PORTAL API")
            .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").version("1.0").build();

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build()
                .apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
