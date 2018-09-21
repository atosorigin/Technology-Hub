/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.wl.odc.techhub.business.service.TopicService;
import net.atos.wl.odc.techhub.common.dto.TopicDto;
import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * Spring REST Controller for exposing Topics APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/topics", tags = "Topics API")
public class TopicController {

    private static Logger log = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    /**
     * REST service to create topic.
     * 
     * @param topicDto
     *            <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/topics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create new topic.")
    public ResponseEntity<TopicDto> createTopic(@RequestBody final TopicDto topicDto) {
        Preconditions.checkNotNull(topicDto);
        log.info("Adding a new topic details with name " + topicDto.getName());
        final TopicDto persistedTopicDto = this.topicService.create(topicDto);
        log.info("Topic detail was added successfully.");
        return new ResponseEntity<>(persistedTopicDto, HttpStatus.CREATED);
    }

    /**
     * REST service to get topic by given id.
     * 
     * @param id
     *            String of the topic to be searched.
     * @return ResponseEntity with topic and HTTP status.
     */
    @RequestMapping(value = "/api/topics/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a particular topic by id.")
    public ResponseEntity<TopicDto> getTopic(@PathVariable("id") final Integer id) {
        log.info("Getting topic details with user id " + id);
        final TopicDto topicDto = this.topicService.read(id);
        if (topicDto == null) {
            log.info("Topic not found with id " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Topic exists. Returning the detail for the same.");
        return new ResponseEntity<>(topicDto, HttpStatus.OK);
    }

    /**
     * REST service to update topic by given details.
     * 
     * @param topicDto
     *            <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code> .
     * @return ResponseEntity with topic and HTTP status.
     */
    @RequestMapping(value = "/api/topics", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update topic detail.")
    public ResponseEntity<TopicDto> updateTopic(@RequestBody final TopicDto topicDto) {
        Preconditions.checkNotNull(topicDto);
        log.info("Updating topic details with user id " + topicDto.getId());
        this.topicService.update(topicDto);
        log.info("Topic detail was updated successfully.");
        return new ResponseEntity<>(topicDto, HttpStatus.OK);
    }

    /**
     * REST service to get all topics.
     * 
     * @return ResponseEntity with topics and HTTP status.
     */
    @RequestMapping(value = "/api/topics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all topics.")
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        log.info("Getting all topics.");
        final List<TopicDto> topics = this.topicService.findAllTopics();
        log.info("Total number of topics found " + topics.size());
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    /**
     * REST service to get topics by room number.
     * 
     * @return ResponseEntity with topics and HTTP status.
     */
    @RequestMapping(value = "/api/topics/room/{roomNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get topics by given room number.")
    public ResponseEntity<List<TopicDto>> getTopicsByRoomNumber(@PathVariable("roomNumber") final RoomNumber roomNumber) {
        log.info("Getting topics by room number " + roomNumber);
        final List<TopicDto> topics = this.topicService.findTopicsByRoomNumber(roomNumber);
        log.info("Total number of topics found " + topics.size());
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    /**
     * REST service to get topics by time slot.
     * 
     * @return ResponseEntity with topics and HTTP status.
     */
    @RequestMapping(value = "/api/topics/slot/{timeSlot}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get topics by given time slot.")
    public ResponseEntity<List<TopicDto>> getTopicsByTimeSlot(@PathVariable("timeSlot") final String timeSlot) {
        log.info("Getting topics by time slot " + timeSlot);
        final List<TopicDto> topics = this.topicService.findTopicsByTimeSlot(timeSlot);
        log.info("Total number of topics found " + topics.size());
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    /**
     * REST service to get topics by time slot.
     * 
     * @return ResponseEntity with topics and HTTP status.
     */
    @RequestMapping(value = "/api/topics/presenter/{presenterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get topics by given presenter id.")
    public ResponseEntity<List<TopicDto>> getTopicsByPresenter(@PathVariable("timeSlot") final Integer presenterId) {
        log.info("Getting topics by presenter " + presenterId);
        final List<TopicDto> topics = this.topicService.findTopicsByPresenter(presenterId);
        log.info("Total number of topics found " + topics.size());
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }
}
