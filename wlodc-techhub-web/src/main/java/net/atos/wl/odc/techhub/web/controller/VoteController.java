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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.wl.odc.techhub.business.service.VoteService;
import net.atos.wl.odc.techhub.common.dto.VoteDto;

/**
 * Spring REST Controller for exposing Vote APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/vote", tags = "Voting API")
public class VoteController {

    private static Logger log = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    private VoteService voteService;

    /**
     * REST service to post the user vote.
     * 
     * @param voteDto
     *            <code>net.atos.wl.odc.techhub.common.dto.VoteDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/vote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Post user vote.")
    public ResponseEntity<Void> postUserVote(@RequestBody final VoteDto voteDto) {
        Preconditions.checkNotNull(voteDto);
        log.info("Posting vote for user " + voteDto.getUserId());
        this.voteService.postUserVote(voteDto);
        log.info("User vote has been posted successfully.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
