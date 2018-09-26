package com.techhub.data.dao;

import java.util.List;

import com.techhub.common.enums.RoomNumber;
import com.techhub.data.entity.Topic;

/**
 * Topic DAO.
 */
public interface TopicDAO extends GenericDAO<Topic> {

    /**
     * Method to find topics that will be presented within a particular room
     * identified by given room number.
     * 
     * @param roomNumber
     *            <code>net.atos.wl.odc.techhub.common.enums.RoomNumber</code>.
     * @return List of <code>net.atos.wl.odc.techhub.data.entity.Topic</code>.
     */
    List<Topic> findTopicsByRoomNumber(final RoomNumber roomNumber);

    /**
     * Method to find topics that will be presented within given time slot.
     * 
     * @param timeSlot
     *            String.
     * @return List of <code>net.atos.wl.odc.techhub.data.entity.Topic</code>.
     */
    List<Topic> findTopicsByTimeSlot(final String timeSlot);

    /**
     * Method to find topics that will be presented presenter identified by
     * given id.
     * 
     * @param presenterId
     *            Integer.
     * @return List of <code>net.atos.wl.odc.techhub.data.entity.Topic</code>.
     */
    List<Topic> findTopicsByPresenter(final Integer presenterId);

    /**
     * Method to find topics for which user has registered for.
     * 
     * @param userId
     *            String.
     * @return List of <code>net.atos.wl.odc.techhub.data.entity.Topic</code>.
     */
    List<Topic> findTopicsByUser(final String userId);

    /**
     * Method to register a given user to a topic.
     * 
     * @param userId
     *            String.
     * @param topicId
     *            Integer.
     */
    void registerUserToTopic(final String userId, final Integer topicId);

    /**
     * Method to un-register a given user from a topic.
     * 
     * @param userId
     *            String.
     * @param topicId
     *            Integer.
     */
    void unRegisterUserFromTopic(final String userId, final Integer topicId);
}
