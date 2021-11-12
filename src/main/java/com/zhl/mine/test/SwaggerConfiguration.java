package com.zhl.mine.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/11/1 18:03
 */
@Configuration
@EnableSwagger2
@Profile(value = {"staging", "development"})
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.xxxxx.controller"))
//                .paths(any())
                .build();
    }
}