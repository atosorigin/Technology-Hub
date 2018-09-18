/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.data.entity.Feedback;

/**
 * Feedback DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class FeedbackDAOImpl extends AbstractJpaDAO<Feedback> implements FeedbackDAO {
    
    /**
     * Default constructor.
     */
    public FeedbackDAOImpl() {
        this.setClazz(Feedback.class);
    }
}
