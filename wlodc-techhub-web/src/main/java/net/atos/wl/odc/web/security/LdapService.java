/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.odc.web.security;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.InitialDirContext;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

/**
 * @author a120065
 *
 */
@Service
public class LdapService {

    public boolean doValidate(final String authString) throws Exception {
        boolean isValid = false;

        final String decodedAuth = decodeAuthString(authString);

        final String user = decodedAuth.substring(0, decodedAuth.indexOf(":")).trim();
        final String pass = decodedAuth.substring(decodedAuth.indexOf(":") + 1, decodedAuth.length()).trim();
        final Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldaps://ldap.myatos.net:636/dc=atosorigin,dc=com");
        props.put(Context.SECURITY_PRINCIPAL, "aoLdapKey=AA" + user + ",ou=people,dc=atosorigin,dc=com");
        props.put(Context.SECURITY_CREDENTIALS, pass);

        InitialDirContext context = null;
        try {
            context = new InitialDirContext(props);
            isValid = true;
        } catch (Exception e) {
            throw e;
        }
        return isValid;
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
}
