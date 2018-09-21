/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#findTopicsByRoomNumber(net.atos
     * .wl.odc.techhub.common.enums.RoomNumber)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Topic> findTopicsByRoomNumber(final RoomNumber roomNumber) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByRoom");
        query.setParameter("roomNumber", roomNumber);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#findTopicsByTimeSlot(java.lang.
     * String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Topic> findTopicsByTimeSlot(final String timeSlot) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsBySlot");
        query.setParameter("timeSlot", timeSlot);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#findTopicsByPresenter(java.lang
     * .Integer)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Topic> findTopicsByPresenter(final Integer presenterId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByPresenter");
        query.setParameter("presenterId", presenterId);
        return query.getResultList();
    }
}
