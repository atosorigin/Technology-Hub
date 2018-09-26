package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.VoteDto;
import com.techhub.common.dto.VoteStatsDto;
import com.techhub.common.enums.VotingType;

/**
 * Vote Service.
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

    /**
     * Method to get all the votes posted by the given user.
     * 
     * @param userId
     *            String.
     * @return List of <code>com.techhub.common.dto.VoteDto</code>.
     */
    List<VoteDto> getUserVotes(final String userId);
}
