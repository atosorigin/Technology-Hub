package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.FeedbackDto;

/**
 * Feedback Service.
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
