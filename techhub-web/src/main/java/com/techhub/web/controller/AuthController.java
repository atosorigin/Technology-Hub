/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.web.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.techhub.business.service.LdapService;
import com.techhub.business.service.UserService;
import com.techhub.common.dto.UserAccessToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing user Authentication APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/auth", tags = "Authentication API")
public class AuthController {

    private static Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private LdapService ldapService;

    @Autowired
    private UserService userService;

    /**
     * Method to authenticate user against LDAP and returning the detail in case
     * use is valid.
     * 
     * @param authString
     *            String.
     * @return ResponseEntity<UserAccessToken>.
     */
    @RequestMapping(value = "/api/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Authenticate user and return API access token.")
    public ResponseEntity<UserAccessToken> authenticateUser(@RequestHeader(value = "Authorization") final String authString) {
        Preconditions.checkNotNull(authString);
        try {
            // First decode the given authorization string.
            final String decodedAuth = this.decodeAuthString(authString);

            // First part of the decoded string would be user name.
            final String userId = decodedAuth.substring(0, decodedAuth.indexOf(":")).trim();

            // Second part of the decoded string would be password.
            final String pass = decodedAuth.substring(decodedAuth.indexOf(":") + 1, decodedAuth.length()).trim();

            // Check whether user is part of white list. If not return forbidden
            // error.
            if (null == this.userService.findWhiteListUserByUserId(userId)) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            // Authenticate user against LDAP.
            final UserAccessToken userAccessToken = this.ldapService.authenticateUser(userId, pass);
            if (userAccessToken != null) {
                return new ResponseEntity<>(userAccessToken, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Method to logout user.
     * 
     * @param userId
     *            String.
     * @param token
     *            String.
     * @return ResponseEntity<Void>
     */
    @RequestMapping(value = "/api/logout", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User logout.")
    public ResponseEntity<Void> logout(@RequestHeader(value = "X-Auth-UserId") final String userId,
                                       @RequestHeader(value = "X-Auth-Token") final String token) {

        this.ldapService.logout(userId, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method to decode the given authorization string and return decoded value.
     * 
     * @param authString
     *            String
     * @return String decoded authorization value.
     */
    private String decodeAuthString(final String authString) {
        try {
            // Split the authorization string into two parts.
            final String[] authParts = authString.split("\\s+");

            // Second part of the authorization string should be encoded user
            // credentials.
            final String authInfo = authParts[1];

            // Decode the data back to original string.
            byte[] bytes = Base64.getDecoder().decode(authInfo);
            return new String(bytes);
        } catch (final Exception e) {
            log.error("", e);
            throw e;
        }
    }
}
