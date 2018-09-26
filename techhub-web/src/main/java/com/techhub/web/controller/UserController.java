package com.techhub.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.techhub.business.service.UserService;
import com.techhub.common.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Users APIs.
 */
@RestController
@Api(value = "/api/users", tags = "Users API")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(PresenterController.class);

    @Autowired
    private UserService userService;

    /**
     * REST service to create user.
     * 
     * @param userDto
     *            <code>net.atos.wl.odc.techhub.common.dto.UserDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create new user.")
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) {
        Preconditions.checkNotNull(userDto);
        log.info("Adding a new user details with user id " + userDto.getUserId());
        final UserDto persistedUserDto = this.userService.create(userDto);
        log.info("User detail was added successfully.");
        return new ResponseEntity<>(persistedUserDto, HttpStatus.CREATED);
    }

    /**
     * REST service to get user by given userId.
     * 
     * @param userId
     *            String of the user to be searched.
     * @return ResponseEntity with user and HTTP status.
     */
    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get user by user id.")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") final String userId) {
        log.info("Getting user details with user id " + userId);
        final UserDto userDto = this.userService.findUserByUserId(userId);
        if (userDto == null) {
            log.info("User not found with user id " + userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("User exists. Returning the detail for the same.");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * REST service to update user by given details.
     * 
     * @param userDto
     *            <code>net.atos.wl.odc.techhub.common.dto.UserDto</code> .
     * @return ResponseEntity with user and HTTP status.
     */
    @RequestMapping(value = "/api/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update user.")
    public ResponseEntity<UserDto> updateUser(@RequestBody final UserDto userDto) {
        Preconditions.checkNotNull(userDto);
        log.info("Updating user details with user id " + userDto.getUserId());
        this.userService.update(userDto);
        log.info("User detail was updated successfully.");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    /**
     * REST service to get all users.
     * 
     * @return ResponseEntity with user and HTTP status.
     */
    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all users.")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        log.info("Getting all users.");
        final List<UserDto> users = this.userService.findAllUsers();
        log.info("Total number of users found " + users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * REST service to get users for the given topic.
     * 
     * @return ResponseEntity with user and HTTP status.
     */
    @RequestMapping(value = "/api/users/topic/{topicId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get users for given topic.")
    public ResponseEntity<List<UserDto>> getUsersByTopic(@PathVariable("topicId") final Integer topicId) {
        log.info("Getting users for topic " + topicId);
        final List<UserDto> users = this.userService.findUsersByTopic(topicId);
        log.info("Total number of users found " + users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
