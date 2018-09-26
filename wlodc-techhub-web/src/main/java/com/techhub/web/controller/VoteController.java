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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.techhub.business.service.VoteService;
import com.techhub.common.dto.VoteDto;
import com.techhub.common.dto.VoteStatsDto;
import com.techhub.common.enums.VotingType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Voting APIs.
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

    /**
     * REST service to post the user vote.
     * 
     * @param voteType
     *            <code>net.atos.wl.odc.techhub.common.enums.VotingType</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/vote/stats/{voteType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get current voting stats.")
    public ResponseEntity<List<VoteStatsDto>> postUserVote(@PathVariable("voteType") final VotingType voteType) {
        Preconditions.checkNotNull(voteType);
        log.info("Getting voting stats for vote type " + voteType);
        final List<VoteStatsDto> votingStats = this.voteService.getVoteStatsByVoteType(voteType);
        return new ResponseEntity<>(votingStats, HttpStatus.OK);
    }
}
