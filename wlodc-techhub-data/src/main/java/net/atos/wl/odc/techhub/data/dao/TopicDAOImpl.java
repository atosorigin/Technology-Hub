/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.data.entity.Topic;

/**
 * Topic DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class TopicDAOImpl extends AbstractJpaDAO<Topic> implements TopicDAO {

    /**
     * Default constructor.
     */
    public TopicDAOImpl() {
        this.setClazz(Topic.class);
    }
}
