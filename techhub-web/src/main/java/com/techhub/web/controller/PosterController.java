package com.techhub.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techhub.business.service.PosterService;
import com.techhub.common.dto.PosterDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Posters APIs.
 */
@RestController
@Api(value = "/api/posters", tags = "Posters API")
public class PosterController {

    private static Logger log = LoggerFactory.getLogger(PosterController.class);

    @Autowired
    private PosterService posterService;

    /**
     * REST service to get all posters.
     * 
     * @return ResponseEntity with posters and HTTP status.
     */
    @RequestMapping(value = "/api/posters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all posters.")
    public ResponseEntity<List<PosterDto>> getAllQuestions() {
        log.info("Getting all posters.");
        final List<PosterDto> posters = this.posterService.findAllPosters();
        log.info("Total number of posters found " + posters.size());
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }
}
