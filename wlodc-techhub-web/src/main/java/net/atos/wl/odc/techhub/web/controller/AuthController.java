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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.wl.odc.techhub.business.service.LdapService;
import net.atos.wl.odc.techhub.common.dto.UserDto;

/**
 * Spring REST Controller for exposing user authentication APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "auth", tags = "Authentication API")
public class AuthController {

    private static Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private LdapService ldapService;

    @RequestMapping(value = "/api/auth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Authenticate user and return user detail if user is valid.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")})
    public ResponseEntity<UserDto> authenticateUser(@RequestHeader(value = "Authorization") String authString) {
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
