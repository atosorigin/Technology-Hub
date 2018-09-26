/*
 * Copyright (C) 2018 Worldline ODC.
 */
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

import com.techhub.business.service.VideoService;
import com.techhub.common.dto.VideoDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Videos APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/videos", tags = "Videos API")
public class VideoController {

    private static Logger log = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;

    /**
     * REST service to get all videos.
     * 
     * @return ResponseEntity with videos and HTTP status.
     */
    @RequestMapping(value = "/api/videos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all videos.")
    public ResponseEntity<List<VideoDto>> getAllQuestions() {
        log.info("Getting all videos.");
        final List<VideoDto> videos = this.videoService.findAllVideos();
        log.info("Total number of videos found " + videos.size());
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
}
