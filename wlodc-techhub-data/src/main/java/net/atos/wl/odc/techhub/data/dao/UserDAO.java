/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import net.atos.wl.odc.techhub.data.entity.User;

/**
 * User DAO.
 * 
 * @author a120065
 */
public interface UserDAO extends GenericDAO<User> {

    /**
     * Method to fetch the user details by given user Id.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.data.entity.User</code>.
     */
    User findUserByUserId(final String userId);

    /**
     * Method to fetch the users for the given topic.
     * 
     * @param topicId
     *            Integer.
     * @return List of <code>net.atos.wl.odc.techhub.data.entity.User</code>.
     */
    List<User> findUsersByTopic(final Integer topicId);
}
