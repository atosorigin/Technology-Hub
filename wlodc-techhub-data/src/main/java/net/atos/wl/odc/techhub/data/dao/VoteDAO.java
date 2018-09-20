/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import net.atos.wl.odc.techhub.common.dto.VoteDto;

/**
 * Vote DAO.
 * 
 * @author a120065
 */
public interface VoteDAO {

    /**
     * Method to post user vote.
     * 
     * @param voteDto
     *            <code>net.atos.wl.odc.techhub.common.dto.VoteDto</code>.
     */
    void postUserVote(final VoteDto voteDto);
}
