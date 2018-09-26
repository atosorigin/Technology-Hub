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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.techhub.business.service.FeedbackService;
import com.techhub.common.dto.FeedbackDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Feedback APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/feedback", tags = "Feedback API")
public class FeedbackController {

    private static Logger log = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

    /**
     * REST service to mark attendance of the user.
     * 
     * @param userFeedbacks
     *            List of
     *            <code>net.atos.wl.odc.techhub.common.dto.FeedbackDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/feedback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Post user feedback.")
    public ResponseEntity<Void> postUserFeedback(@RequestBody final List<FeedbackDto> userFeedbacks) {
        Preconditions.checkNotNull(userFeedbacks);
        log.info("Posting user feedback.");
        this.feedbackService.postUserFeedback(userFeedbacks);
        log.info("User feedback has been posted successfully.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
