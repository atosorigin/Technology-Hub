/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.FeedbackDto;

/**
 * Feedback Service.
 * 
 * @author a120065
 */
public interface FeedbackService {

    /**
     * Method to post all user feedbacks.
     * 
     * @param userFeedbacks
     *            List of
     *            <code>net.atos.wl.odc.techhub.common.dto.FeedbackDto</code>.
     */
    void postUserFeedback(final List<FeedbackDto> userFeedbacks);
}
