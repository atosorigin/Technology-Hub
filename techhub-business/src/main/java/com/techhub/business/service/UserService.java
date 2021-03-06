package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.UserDto;
import com.techhub.common.dto.WhiteListUserDto;

/**
 * User Service.
 */
public interface UserService {

    /**
     * Method create a new user record in DB.
     * 
     * @param user
     *            <code>net.atos.wl.odc.techhub.common.dto.UserDto</code> .
     * @return <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    UserDto create(final UserDto user);

    /**
     * Method to fetch user details for the given user Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    UserDto read(final Integer id);

    /**
     * Method to update user details.
     * 
     * @param user
     *            <code>net.atos.wl.odc.techhub.common.dto.UserDto</code> .
     */
    void update(final UserDto user);

    /**
     * Method to delete the given user record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find a particular user for the given userId.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    UserDto findUserByUserId(final String userId);

    /**
     * Method to find all users.
     * 
     * @return List of <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    List<UserDto> findAllUsers();

    /**
     * Method to fetch the users for the given topic.
     * 
     * @param topicId
     *            Integer.
     * @return List of <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    List<UserDto> findUsersByTopic(final Integer topicId);

    /**
     * Method to find the user from the white list.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.WhiteListUserDto</code>.
     */
    WhiteListUserDto findWhiteListUserByUserId(final String userId);
}
