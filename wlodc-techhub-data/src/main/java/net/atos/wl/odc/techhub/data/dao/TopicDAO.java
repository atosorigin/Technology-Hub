/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;
import net.atos.wl.odc.techhub.data.entity.Topic;

/**
 * Topic DAO.
 * 
 * @author a120065
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
}
