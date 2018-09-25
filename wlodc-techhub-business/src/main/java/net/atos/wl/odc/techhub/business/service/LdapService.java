/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import net.atos.wl.odc.techhub.common.dto.UserAccessToken;

/**
 * LDAP Service.
 * 
 * @author a120065
 */
public interface LdapService {

    /**
     * Service to authentic user credentials passes as authorization header and
     * return user details in case user is valid.
     * 
     * @param userId
     *            String.
     * @param pass
     *            String.
     * @return <code>net.atos.wl.odc.common.dto.UserAccessToken</code>.
     * @throws Exception
     *             occurred while authenticating user.
     */
    UserAccessToken authenticateUser(final String userId, final String pass) throws Exception;

    /**
     * Method to logout user by deleting the access token.
     * 
     * @param userId
     *            String.
     * @param token
     *            String.
     */
    void logout(final String userId, final String token);
}
