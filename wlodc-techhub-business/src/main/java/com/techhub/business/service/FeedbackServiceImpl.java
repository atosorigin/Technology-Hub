/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.common.dto.FeedbackDto;
import com.techhub.data.dao.FeedbackDAO;

/**
 * Feedback Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDAO feedbackDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.FeedbackService#postUserFeedback
     * (java.util.List)
     */
    @Override
    public void postUserFeedback(final List<FeedbackDto> userFeedbacks) {
        this.getFeedbackDAO().postUserFeedback(userFeedbacks);
    }

    /**
     * Getter for feedbackDAO.
     *
     * @return the feedbackDAO
     */
    public final FeedbackDAO getFeedbackDAO() {
        return feedbackDAO;
    }

    /**
     * Setter for feedbackDAO.
     *
     * @param feedbackDAO
     *            the feedbackDAO to set
     */
    public final void setFeedbackDAO(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

}
