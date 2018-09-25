/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.Base64;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.common.dto.UserAccessToken;
import net.atos.wl.odc.techhub.common.dto.UserDto;
import net.atos.wl.odc.techhub.common.enums.UserType;

/**
 * LDAP Service to make LDAP look-up.
 * 
 * @author a120065
 */
@Service
public class LdapServiceImpl implements LdapService {

    /**
     * Logger instance for logging.
     */
    private static Logger log = LoggerFactory.getLogger(LdapServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.LdapService#authenticateUser(
     * java.lang.String, java.lang.String)
     */
    public UserAccessToken authenticateUser(final String userId, final String pass) throws Exception {

        try {
            // LDAP Connection settings for doing user validation.
            final Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.put(Context.PROVIDER_URL, "ldaps://ldap.myatos.net:636/dc=atosorigin,dc=com");
            props.put(Context.SECURITY_PRINCIPAL, "aoLdapKey=AA" + userId + ",ou=people,dc=atosorigin,dc=com");
            props.put(Context.SECURITY_CREDENTIALS, pass);

            // Authenticate user against LDAP.
            final InitialDirContext context = new InitialDirContext(props);

            // If user is valid then get the user details.
            UserDto userDto = this.getUserDetailFromDb(userId);

            // If user exists in local DB return the same, else get his/her
            // details from LDAP.
            if (userDto == null) {
                userDto = this.getUserDetailFromLdap(context, userId);
                userDto.setUserType(UserType.USER);
                this.getUserService().create(userDto);
            }
            return this.generateAccessToken(userId);
        } catch (final Exception e) {
            log.error("", e);
            throw e;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.LdapService#logout(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void logout(final String userId, final String token) {
        final String userIdFromCache = this.getTokenService().retrieve(token);
        if (userId.equalsIgnoreCase(userIdFromCache)) {
            this.getTokenService().remove(token);
        }
    }

    /**
     * Method to get user details from DB.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    private UserDto getUserDetailFromDb(final String userId) {
        return this.getUserService().findUserByUserId(userId);
    }

    /**
     * Method to get the user details from LDAP.
     * 
     * @param context
     *            <code>javax.naming.directory.InitialDirContext</code>.
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.common.dto.UserDto</code>.
     * @throws Exception
     *             exception occurred while getting user details.
     */
    @SuppressWarnings("rawtypes")
    private UserDto getUserDetailFromLdap(final InitialDirContext context, final String userId) throws Exception {
        final SearchControls ctrls = new SearchControls();
        ctrls.setReturningAttributes(new String[] {"*", "+"});
        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> answers = null;
        try {
            answers = context.search("ou=people", "(uid=" + userId + ")", ctrls);
            final UserDto dto = new UserDto();
            final SearchResult result = answers.nextElement();
            final NamingEnumeration e = result.getAttributes().getAll();
            dto.setUserId(userId);
            while (e.hasMoreElements()) {
                final Object nameAttribute = (Object) e.nextElement();
                if (nameAttribute.toString().startsWith("aoLegalGivenName:")) {
                    dto.setFirstName(nameAttribute.toString().replace("aoLegalGivenName:", "").trim());
                } else if (nameAttribute.toString().startsWith("aoLegalSurname:")) {
                    dto.setLastName(nameAttribute.toString().replace("aoLegalSurname:", "").trim());
                } else if (nameAttribute.toString().startsWith("l:")) {
                    dto.setLocation(nameAttribute.toString().replace("l:", "").trim());
                } else if (nameAttribute.toString().startsWith("mail:")) {
                    dto.setEmail(nameAttribute.toString().replace("mail:", "").trim());
                } else if (nameAttribute.toString().startsWith("mobile:")) {
                    dto.setMobile(nameAttribute.toString().replace("mobile:", "").trim());
                }
            }
            return dto;
        } catch (Exception e) {
            log.error("", e);
            throw e;
        }
    }

    /**
     * Method to generate, store and return access token for the given user.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.UserAccessToken</code>.
     */
    private UserAccessToken generateAccessToken(final String userId) {
        final UserAccessToken userAccessToken = new UserAccessToken();
        final String token = Base64.getEncoder().encodeToString(this.getTokenService().generateNewToken().getBytes());
        this.getTokenService().store(userId, token);
        userAccessToken.setAccessToken(token);
        return userAccessToken;
    }

    /**
     * Getter for userService.
     *
     * @return the userService
     */
    public final UserService getUserService() {
        return userService;
    }

    /**
     * Setter for userService.
     *
     * @param userService
     *            the userService to set
     */
    public final void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Getter for tokenService.
     *
     * @return the tokenService
     */
    public final TokenService getTokenService() {
        return tokenService;
    }

    /**
     * Setter for tokenService.
     *
     * @param tokenService
     *            the tokenService to set
     */
    public final void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
