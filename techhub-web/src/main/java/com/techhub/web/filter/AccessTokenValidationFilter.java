/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.UrlPathHelper;

import com.google.common.base.Optional;
import com.techhub.business.service.TokenService;

/**
 * Generic filter to validate access token passed in the header.
 * 
 * @author a120065
 */
@Component
@Order(1)
public class AccessTokenValidationFilter extends GenericFilterBean {

    /**
     * Logger instance for logging.
     */
    private final static Logger log = LoggerFactory.getLogger(AccessTokenValidationFilter.class);

    /**
     * URI for authentication service.
     */
    private final static String AUTHENTICATE_URL = "/api/auth";

    /**
     * Instance of token to manage user access tokens.
     */
    @Autowired
    private TokenService tokenService;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpRequest = asHttpRequest(request);
        final HttpServletResponse httpResponse = asHttpResponse(response);

        final Optional<String> userId = Optional.fromNullable(httpRequest.getHeader("X-Auth-UserId"));
        final Optional<String> token = Optional.fromNullable(httpRequest.getHeader("X-Auth-Token"));
        final String resourcePath = new UrlPathHelper().getPathWithinApplication(httpRequest);

        log.info("Recieved request for URI: " + resourcePath);
        if (this.isAuthRequest(httpRequest, resourcePath)) {
            chain.doFilter(request, response);
        } else {
            if (userId.isPresent() && token.isPresent()) {
                final String userIdFromCache = this.tokenService.retrieve(token.get());
                if (userIdFromCache == null || !userId.get().equalsIgnoreCase(userIdFromCache)) {
                    log.error("API user access token is invalid or expired.");
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                    "API User access token is invalid or expired.");
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                log.error("API auth information not passed with the request.");
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "API auth information not passed.");
            }
        }
    }

    /**
     * Method to convert the ServletRequest to HttpServletRequest.
     * 
     * @param request
     *            <code>javax.servlet.ServletRequest</code>.
     * @return <code>javax.servlet.http.HttpServletRequest</code>.
     */
    private HttpServletRequest asHttpRequest(final ServletRequest request) {
        return (HttpServletRequest) request;
    }

    /**
     * Method to convert the ServletResponse to HttpServletResponse.
     * 
     * @param request
     *            <code>javax.servlet.ServletResponse</code>.
     * @return <code>javax.servlet.http.HttpServletResponse</code>.
     */
    private HttpServletResponse asHttpResponse(final ServletResponse response) {
        return (HttpServletResponse) response;
    }

    /**
     * Method to check whether it is an authentication request or not.
     * 
     * @param httpRequest
     *            <code>javax.servlet.http.HttpServletRequest</code>.
     * @param resourcePath
     *            String.
     * @return boolean.
     */
    private boolean isAuthRequest(final HttpServletRequest httpRequest, final String resourcePath) {
        return AUTHENTICATE_URL.equalsIgnoreCase(resourcePath) && httpRequest.getMethod().equals("POST");
    }
}
