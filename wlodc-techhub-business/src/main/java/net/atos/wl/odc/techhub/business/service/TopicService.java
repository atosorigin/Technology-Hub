/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.TopicDto;

/**
 * Topic Service.
 * 
 * @author a120065
 */
public interface TopicService {

    /**
     * Method create a new topic record in DB.
     * 
     * @param topicDto
     *            <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code> .
     * @return <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code>.
     */
    TopicDto create(final TopicDto topicDto);

    /**
     * Method to fetch topic details for the given topic Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code>.
     */
    TopicDto read(final Integer id);

    /**
     * Method to update topic details.
     * 
     * @param topicDto
     *            <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code> .
     */
    void update(final TopicDto topicDto);

    /**
     * Method to delete the given topic record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find all topics.
     * 
     * @return List of <code>net.atos.wl.odc.techhub.common.dto.TopicDto</code>.
     */
    List<TopicDto> findAllTopics();
}
