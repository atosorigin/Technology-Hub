/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;
import net.atos.wl.odc.techhub.data.entity.Topic;
import net.atos.wl.odc.techhub.data.entity.User;

/**
 * Topic DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class TopicDAOImpl extends AbstractJpaDAO<Topic> implements TopicDAO {

    @Autowired
    private UserDAO userDAO;

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#findTopicsByUser(java.lang.
     * String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Topic> findTopicsByUser(final String userId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByUser");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#registerUserToTopic(java.lang.
     * String, java.lang.Integer)
     */
    @Override
    public void registerUserToTopic(final String userId, final Integer topicId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicByIdAndUser");
        query.setParameter("userId", userId);
        query.setParameter("topicId", topicId);

        if (query.getResultList().size() == 0) {
            final User user = this.getUserDAO().findUserByUserId(userId);
            final Topic topic = this.read(topicId);
            topic.addUser(user);
            this.persistOrMerge(topic);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.TopicDAO#unRegisterUserFromTopic(java.
     * lang.String, java.lang.Integer)
     */
    @Override
    public void unRegisterUserFromTopic(final String userId, final Integer topicId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicByIdAndUser");
        query.setParameter("userId", userId);
        query.setParameter("topicId", topicId);

        if (query.getResultList().size() > 0) {
            final User user = this.getUserDAO().findUserByUserId(userId);
            final Topic topic = this.read(topicId);
            topic.removeUser(user);
            this.persistOrMerge(topic);
        }
    }

    /**
     * Getter for userDAO.
     *
     * @return the userDAO
     */
    public final UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Setter for userDAO.
     *
     * @param userDAO
     *            the userDAO to set
     */
    public final void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
