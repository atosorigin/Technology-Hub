/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Swagger API Documentation configuration.
 * 
 * @author a120065
 */
public class ApplicationConfig extends WebMvcConfigurationSupport {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.config.annotation.
     * WebMvcConfigurationSupport#addCorsMappings(org.springframework.web.
     * servlet.config.annotation.CorsRegistry)
     */
    @Override
    protected void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins("*")
                        .allowedHeaders("origin", "content-type", "accept", "authorization", "access_token")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD").allowCredentials(true)
                        .maxAge(3600);
    }
}
