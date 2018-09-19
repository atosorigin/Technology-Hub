/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring application initializer.
 * 
 * @author a120065
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
     * .ServletContext)
     */
    @Override
    public void onStartup(final ServletContext container) {
        final ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
