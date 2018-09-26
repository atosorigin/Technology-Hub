package com.techhub.data.dao;

import java.util.List;

import com.techhub.common.dto.VoteDto;
import com.techhub.common.dto.VoteStatsDto;
import com.techhub.common.enums.VotingType;
import com.techhub.data.entity.Vote;

/**
 * Vote DAO.
 */
public interface VoteDAO {

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
     * @param voteType
     *            <code>net.atos.wl.odc.techhub.common.enums.VotingType</code>.
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.VoteStatsDto</code>.
     */
    List<VoteStatsDto> getVoteStatsByVoteType(final VotingType voteType);

    /**
     * Method to get all the votes posted by the given user.
     * 
     * @param userId
     *            String.
     * @return List of <code>com.techhub.data.entity.Vote</code>.
     */
    List<Vote> getUserVotes(final String userId);
}
