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

import net.atos.wl.odc.techhub.common.dto.UserDto;

/**
 * LDAP Service to make LDAP look-up.
 * 
 * @author a120065
 */
@Service
public class LdapService {

    /**
     * Logger instance for logging.
     */
    private static Logger log = LoggerFactory.getLogger(LdapService.class);

    @Autowired
    private UserService userService;

    /**
     * Service to authentic user credentials passes as authorization header and
     * return user details in case user is valid.
     * 
     * @param authString
     *            String.
     * @return <code>net.atos.wl.odc.common.dto.UserDto</code>.
     * @throws Exception
     */
    public UserDto authenticateUser(final String authString) throws Exception {

        // First decode the given authorization string.
        final String decodedAuth = this.decodeAuthString(authString);

        // First part of the decoded string would be user name.
        final String userId = decodedAuth.substring(0, decodedAuth.indexOf(":")).trim();

        // Second part of the decoded string would be password.
        final String pass = decodedAuth.substring(decodedAuth.indexOf(":") + 1, decodedAuth.length()).trim();

        // LDAP Connection settings for doing user validation.
        final Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldaps://ldap.myatos.net:636/dc=atosorigin,dc=com");
        props.put(Context.SECURITY_PRINCIPAL, "aoLdapKey=AA" + userId + ",ou=people,dc=atosorigin,dc=com");
        props.put(Context.SECURITY_CREDENTIALS, pass);

        InitialDirContext context = null;
        try {
            // Authenticate the user.
            context = new InitialDirContext(props);

            // If user is valid then get the user details.
            UserDto userDto = this.getUserDetailFromDb(userId);

            if (userDto != null) {
                return userDto;
            } else {
                userDto = this.getUserDetailFromLdap(context, userId);
                return this.getUserService().create(userDto);
            }
        } catch (final Exception e) {
            log.error("", e);
            throw e;
        }
    }

    /**
     * Method to decode the given authorization string and return decoded value.
     * 
     * @param authString
     *            String
     * @return String decoded authorization value.
     */
    private String decodeAuthString(final String authString) {

        // Split the authorization string into two parts.
        final String[] authParts = authString.split("\\s+");

        // Second part of the authorization string should be encoded user
        // credentials.
        final String authInfo = authParts[1];

        // Decode the data back to original string.
        byte[] bytes = null;
        try {
            bytes = Base64.getDecoder().decode(authInfo);
            return new String(bytes);
        } catch (final Exception e) {
            log.error("", e);
            throw e;
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
}
