/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API Documentation configuration.
 * 
 * @author a120065
 */
@EnableSwagger2
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {

    /**
     * Swagger configuration to used while generating Swagger API documentation.
     * 
     * @return <code>springfox.documentation.spring.web.plugins.Docket</code>.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                        .apis(RequestHandlerSelectors.basePackage("net.atos.wl.odc.techhub.web.controller"))
                        .paths(PathSelectors.any()).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.config.annotation.
     * WebMvcConfigurationSupport#addViewControllers(org.springframework.web.
     * servlet.config.annotation.ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/swagger-resources/configuration/ui",
                        "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/swagger-resources/configuration/security",
                        "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.config.annotation.
     * WebMvcConfigurationSupport#addResourceHandlers(org.springframework.web.
     * servlet.config.annotation.ResourceHandlerRegistry)
     */
    @Override
    protected void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.config.annotation.
     * WebMvcConfigurationSupport#addCorsMappings(org.springframework.web.
     * servlet.config.annotation.CorsRegistry)
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    /**
     * Get the high level API information to be displayed in Swagger API
     * documentation for the service.
     * 
     * @return <code>springfox.documentation.service.ApiInfo</code>.
     */
    private ApiInfo getApiInfo() {
        final Contact contact = new Contact("Worldline ODC Team", "https://worldline.com/", "rupesh.deshmukh@atos.net");
        return new ApiInfoBuilder().title("Worldline ODC Technology Hub API")
                        .description("Worldline ODC Technology Hub API").version("1.0.0").license("Apache 2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact).build();
    }
}
