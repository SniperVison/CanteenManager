package com.vison.canteen.biz.config;

import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by huangwenshen on 2018/3/9
 */
@Configuration
@ConditionalOnClass({Swagger.class})
@ConditionalOnProperty(name = {"swagger.init"}, havingValue = "true")
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.base-package:com.vison}")
    String basePackage;
    @Value("${swagger.title:xxx}")
    String title;
    @Value("${swagger.desc:xxx}")
    String desc;
    @Value("${swagger.url:xxx}")
    String author;
    @Value("${swagger.name:xxx}")
    String url;
    @Value("${swagger.email:xxx}")
    String email;
    @Value("${swagger.version:xxx}")
    String version;

    public Swagger2Config() {
    }

    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.SWAGGER_2))
                .apiInfo(this.apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title(this.title)
                .description(this.desc)
                .termsOfServiceUrl(this.url)
                .contact(new Contact(this.author, this.url, this.email))
                .version(this.version)
                .build();
    }

}
