/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.odc.web.security;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

/**
 * @author a120065
 *
 */
@Service
public class LdapService {

    public UserDto doValidate(final String authString) throws Exception {
        final String decodedAuth = this.decodeAuthString(authString);
        final String userId = decodedAuth.substring(0, decodedAuth.indexOf(":")).trim();
        final String pass = decodedAuth.substring(decodedAuth.indexOf(":") + 1, decodedAuth.length()).trim();
        final Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldaps://ldap.myatos.net:636/dc=atosorigin,dc=com");
        props.put(Context.SECURITY_PRINCIPAL, "aoLdapKey=AA" + userId + ",ou=people,dc=atosorigin,dc=com");
        props.put(Context.SECURITY_CREDENTIALS, pass);

        InitialDirContext context = null;
        try {
            context = new InitialDirContext(props);
            return this.getUserDetail(context, userId);
        } catch (Exception e) {
            throw e;
        }        
    }

    private String decodeAuthString(final String authString) {
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    private UserDto getUserDetail(final InitialDirContext context, final String userId) {
        final SearchControls ctrls = new SearchControls();
        ctrls.setReturningAttributes(new String[] {"*", "+"});
        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        NamingEnumeration<SearchResult> answers = null;
        try {
            answers = context.search("ou=people", "(uid=" + userId + ")", ctrls);            
            try {
                final UserDto dto = new UserDto();
                final SearchResult result = answers.nextElement();
                final NamingEnumeration e = result.getAttributes().getAll();
                dto.setUserId(userId);
                while (e.hasMoreElements()) {
                    Object name = (Object) e.nextElement();
                    if (name.toString().startsWith("aoLegalGivenName:")) {
                        dto.setFirstName(name.toString().replace("aoLegalGivenName:", "").trim());
                    } else if (name.toString().startsWith("aoLegalSurname:")) {
                        dto.setLastName(name.toString().replace("aoLegalSurname:", "").trim());
                    } else if (name.toString().startsWith("l:")) {
                        dto.setLocation(name.toString().replace("l:", "").trim());
                    } else if (name.toString().startsWith("street:")) {
                        dto.setLocation(name.toString().replace("street:", "").trim());
                    }
                }
                return dto;
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                return null;
            }
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
