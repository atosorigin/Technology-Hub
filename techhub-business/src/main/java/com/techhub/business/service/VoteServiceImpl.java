package com.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.business.mapper.ObjectMapper;
import com.techhub.common.dto.VoteDto;
import com.techhub.common.dto.VoteStatsDto;
import com.techhub.common.enums.VotingType;
import com.techhub.data.dao.VoteDAO;
import com.techhub.data.entity.Vote;

/**
 * Vote Service Implementation.
 */
@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.VoteService#postUserVote(net.
     * atos.wl.odc.techhub.common.dto.VoteDto)
     */
    @Override
    public void postUserVote(final VoteDto voteDto) {
        this.getVoteDAO().postUserVote(voteDto);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.VoteService#
     * getVoteStatsByVoteType(net.atos.wl.odc.techhub.common.enums.VotingType)
     */
    @Override
    public List<VoteStatsDto> getVoteStatsByVoteType(final VotingType votingType) {
        return this.getVoteDAO().getVoteStatsByVoteType(votingType);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.techhub.business.service.VoteService#getUserVotes(java.lang.String)
     */
    @Override
    public List<VoteDto> getUserVotes(final String userId) {
        // First fetch all votes by invoking DAO.
        final List<Vote> votes = this.getVoteDAO().getUserVotes(userId);

        // If votes are found them iterate through the list and map all
        // entities to VoteDto.
        if (CollectionUtils.isNotEmpty(votes)) {
            final List<VoteDto> voteDtos = new ArrayList<>();
            for (final Vote vote : votes) {
                final VoteDto voteDto = new VoteDto();
                voteDto.setVoteType(vote.getVoteType());
                if (vote.getVoteType() == VotingType.POSTER) {
                    voteDto.setPosterId(vote.getPoster().getId());
                } else if (vote.getVoteType() == VotingType.VIDEO) {
                    voteDto.setVideoId(vote.getVideo().getId());
                } else if (vote.getVoteType() == VotingType.VIDEO) {
                    voteDto.setTopicId(vote.getTopic().getId());
                }
                voteDtos.add(voteDto);
            }
            return voteDtos;
        }

        return new ArrayList<VoteDto>();
    }

    /**
     * Getter for voteDAO.
     *
     * @return the voteDAO
     */
    public final VoteDAO getVoteDAO() {
        return voteDAO;
    }

    /**
     * Setter for voteDAO.
     *
     * @param voteDAO
     *            the voteDAO to set
     */
    public final void setVoteDAO(VoteDAO voteDAO) {
        this.voteDAO = voteDAO;
    }

    /**
     * Getter for objectMapper.
     *
     * @return the objectMapper
     */
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Setter for objectMapper.
     *
     * @param objectMapper
     *            the objectMapper to set
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
