/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import net.atos.wl.odc.techhub.common.dto.VoteDto;

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
}
