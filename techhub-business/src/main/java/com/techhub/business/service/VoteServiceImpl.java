package com.techhub.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.common.dto.VoteDto;
import com.techhub.common.dto.VoteStatsDto;
import com.techhub.common.enums.VotingType;
import com.techhub.data.dao.VoteDAO;

/**
 * Vote Service Implementation.
 */
@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDAO voteDAO;

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
    public List<VoteStatsDto> getVoteStatsByVoteType(VotingType votingType) {
        return this.getVoteDAO().getVoteStatsByVoteType(votingType);
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
}
