/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.VoteDto;
import net.atos.wl.odc.techhub.common.dto.VoteStatsDto;
import net.atos.wl.odc.techhub.common.enums.VotingType;

/**
 * Vote Service
 * 
 * @author a120065
 */
public interface VoteService {

    /**
     * Method to post user vote.
     * 
     * @param voteDto
     *            <code>net.atos.wl.odc.techhub.common.dto.VoteDto</code>.
     */
    void postUserVote(final VoteDto voteDto);

    /**
     * Method to get latest vote statistics for the given voting type.
     * 
     * @param votingType
     *            <code>net.atos.wl.odc.techhub.common.enums.VotingType</code>.
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.VoteStatsDto</code>.
     */
    List<VoteStatsDto> getVoteStatsByVoteType(final VotingType votingType);
}
