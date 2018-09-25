/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

/**
 * Token Service.
 * 
 * @author a120065
 */
public interface TokenService {

    /**
     * Time for which token will be valid (Half an hour).
     */
    static final int TOKEN_EXPIRY = 30 * 60 * 1000;

    /**
     * Method to generated new token.
     * 
     * @return String.
     */
    String generateNewToken();

    /**
     * Method to store the token against the user.
     * 
     * @param userId
     *            String.
     * @param token
     *            String.
     */
    void store(final String userId, final String token);

    /**
     * Method to remove the given token from local store.
     * 
     * @param token
     *            String.
     */
    void remove(final String token);

    /**
     * Method to get the user based on the given token.
     * 
     * @param token
     *            String
     * @return userId String.
     */
    String retrieve(final String token);
}
