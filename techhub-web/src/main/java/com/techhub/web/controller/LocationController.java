/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.business.service.LocationService;
import com.techhub.common.dto.LocationDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Location APIs.
 */
@RestController
@Api(value = "/api/location", tags = "Location API")
public class LocationController {

    private static Logger log = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    /**
     * REST service to get location by given code.
     * 
     * @param code
     *            String.
     * @return ResponseEntity with location and HTTP status.
     */
    @RequestMapping(value = "/api/location/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get user by user id.")
    public ResponseEntity<LocationDto> getLocationByCode(@PathVariable("code") final String code) {
        log.info("Getting location details with code " + code);
        final LocationDto locationDto = this.locationService.findLocationByCode(code);
        if (locationDto == null) {
            log.info("Location not found with code " + code);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Location exists. Returning the detail for the same.");
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }
}
