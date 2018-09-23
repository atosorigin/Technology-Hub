/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.atos.wl.odc.techhub.business.mapper.ObjectMapper;
import net.atos.wl.odc.techhub.common.dto.UserDto;
import net.atos.wl.odc.techhub.common.dto.WhiteListUserDto;
import net.atos.wl.odc.techhub.data.dao.UserDAO;
import net.atos.wl.odc.techhub.data.entity.User;
import net.atos.wl.odc.techhub.data.entity.WhiteListUser;

/**
 * User Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * User DAO instance that will be initialized by spring using constructor
     * injection.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#create(net.atos
     * .wl.odc.techhub.common.dto.UserDto)
     */
    @Override
    public UserDto create(final UserDto userDto) {

        // First map all information passed from UserDto to User
        // entity.
        final User user = this.getObjectMapper().map(userDto, User.class);

        // Invoke DAO to persist the user data.
        this.getUserDAO().create(user);

        // Finally reverse map entity information to the UserDto.
        return this.getObjectMapper().map(user, UserDto.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#read(java.lang.
     * Integer)
     */
    @Override
    public UserDto read(final Integer id) {

        // Fetch user record for the given Id.
        final User user = this.getUserDAO().read(id);

        // If user exists then map entity information to UserDto.
        if (user != null) {
            return this.getObjectMapper().map(user, UserDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#update(net.atos
     * .wl.odc.techhub.common.dto.UserDto)
     */
    @Override
    public void update(final UserDto userDto) {

        // Fetch user record for the given Id.
        final User userFromDb = this.getUserDAO().read(userDto.getId());

        // Map updated information from UserDto to user entity.
        this.getObjectMapper().map(userDto, userFromDb);

        // Finally invoke DAO to update details.
        this.getUserDAO().update(userFromDb);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#delete(java.
     * lang.Integer)
     */
    @Override
    public void delete(Integer id) {
        this.getUserDAO().deleteById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#
     * findUserByUserId(java.lang.String)
     */
    @Override
    public UserDto findUserByUserId(final String userId) {

        // Fetch user record for the given Id.
        final User user = this.getUserDAO().findUserByUserId(userId);

        // If user exists then map entity information to UserDto.
        if (user != null) {
            return this.getObjectMapper().map(user, UserDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService# findAllUsers()
     */
    @Override
    public List<UserDto> findAllUsers() {
        // First fetch all users by invoking DAO.
        final List<User> users = this.getUserDAO().findAll();

        // If users are found them iterate through the list and map all
        // entities to UserDto.
        if (users != null && !users.isEmpty()) {
            final List<UserDto> userDtos = new ArrayList<>();
            for (final User user : users) {
                userDtos.add(this.getObjectMapper().map(user, UserDto.class));
            }

            return userDtos;
        }

        return new ArrayList<UserDto>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.UserService#findUsersByTopic(
     * java.lang.Integer)
     */
    @Override
    public List<UserDto> findUsersByTopic(final Integer topicId) {
        return this.mapUsersEntityToDto(this.getUserDAO().findUsersByTopic(topicId));
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.UserService#
     * findWhiteListUserByUserId(java.lang.String)
     */
    @Override
    public WhiteListUserDto findWhiteListUserByUserId(String userId) {
        // Fetch user record for the given Id.
        final WhiteListUser user = this.getUserDAO().findWhiteListUserByUserId(userId);

        // If user exists then map entity information to UserDto.
        if (user != null) {
            return this.getObjectMapper().map(user, WhiteListUserDto.class);
        }

        return null;
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

    /**
     * Getter for objectMapper.
     *
     * @return the objectMapper
     */
    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Setter for objectMapper.
     *
     * @param objectMapper
     *            the objectMapper to set
     */
    public final void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Common method to map list of topic entities to topic dto.
     * 
     * @param users
     *            List of <code>net.atos.wl.odc.techhub.data.entity.User</code>.
     * @return List of <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     */
    private List<UserDto> mapUsersEntityToDto(final List<User> users) {
        if (!CollectionUtils.isEmpty(users)) {
            final List<UserDto> userDtos = new ArrayList<UserDto>();
            for (final User user : users) {
                userDtos.add(this.objectMapper.map(user, UserDto.class));
            }
            return userDtos;
        }
        return new ArrayList<UserDto>();
    }
}
