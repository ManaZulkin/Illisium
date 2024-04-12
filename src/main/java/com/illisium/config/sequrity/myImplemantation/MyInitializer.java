package com.illisium.config.sequrity.myImplemantation;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;

public class MyInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(new HttpSessionEventPublisher());
    }
}
