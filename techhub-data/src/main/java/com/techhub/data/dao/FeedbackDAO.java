/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import java.util.List;

import com.techhub.common.dto.FeedbackDto;
import com.techhub.data.entity.Feedback;

/**
 * Feedback DAO.
 * 
 * @author a120065
 */
public interface FeedbackDAO extends GenericDAO<Feedback> {

    /**
     * Method to post all user feedbacks.
     * 
     * @param userFeedbacks
     *            List of
     *            <code>net.atos.wl.odc.techhub.common.dto.FeedbackDto</code>.
     */
    void postUserFeedback(final List<FeedbackDto> userFeedbacks);
}
