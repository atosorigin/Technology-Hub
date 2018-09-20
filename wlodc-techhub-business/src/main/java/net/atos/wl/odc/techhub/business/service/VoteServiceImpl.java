/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.common.dto.VoteDto;
import net.atos.wl.odc.techhub.data.dao.VoteDAO;

/**
 * Vote Service Implementation.
 * 
 * @author a120065
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
