/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.wl.odc.techhub.business.service.LdapService;
import net.atos.wl.odc.techhub.common.dto.UserDto;

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

    /**
     * Method to authenticate user against LDAP and returning the detail in case
     * use is valid.
     * 
     * @param authString
     *            String.
     * @return ResponseEntity<UserDto>.
     */
    @RequestMapping(value = "/api/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Authenticate user and return user detail if user is valid.")
    public ResponseEntity<UserDto> authenticateUser(@RequestHeader(value = "Authorization") final String authString) {
        try {
            final UserDto user = this.ldapService.authenticateUser(authString);
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
