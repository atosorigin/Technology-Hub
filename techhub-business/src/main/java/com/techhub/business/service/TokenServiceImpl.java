/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Token Service Implementation.
 * 
 * @author a120065
 */
@Service
public class TokenServiceImpl implements TokenService {

    /**
     * Logger instance for logging.
     */
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    /**
     * Cache for storing access tokens.
     */
    private static final Cache restApiAuthTokenCache = CacheManager.getInstance().getCache("restApiAuthTokenCache");

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TokenService#generateNewToken()
     */
    @Override
    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TokenService#store(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void store(final String userId, final String token) {
        restApiAuthTokenCache.put(new Element(token, userId));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TokenService#retrieve(java.lang.
     * String)
     */
    @Override
    public String retrieve(final String token) {
        final Element element = restApiAuthTokenCache.get(token);
        if (element != null) {
            return (String) element.getObjectValue();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TokenService#remove(java.lang.
     * String)
     */
    @Override
    public void remove(final String token) {
        if (restApiAuthTokenCache.get(token) != null) {
            restApiAuthTokenCache.remove(token);
        }
    }

    /**
     * Delete all expired tokens.
     */
    @Scheduled(fixedRate = TOKEN_EXPIRY)
    public void evictExpiredTokens() {
        log.info("Evicting expired tokens.");
        restApiAuthTokenCache.evictExpiredElements();
    }
}
