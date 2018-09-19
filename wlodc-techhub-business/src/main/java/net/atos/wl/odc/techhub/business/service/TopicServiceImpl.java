/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.business.mapper.ObjectMapper;
import net.atos.wl.odc.techhub.common.dto.TopicDto;
import net.atos.wl.odc.techhub.data.dao.TopicDAO;
import net.atos.wl.odc.techhub.data.entity.Topic;

/**
 * Topic Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    /**
     * Topic DAO instance that will be initialized by spring using constructor
     * injection.
     */
    @Autowired
    private TopicDAO topicDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TopicService#create(net.atos.wl.
     * odc.techhub.common.dto.TopicDto)
     */
    @Override
    public TopicDto create(final TopicDto topicDto) {

        // First map all information passed from TopicDto to Topic
        // entity.
        final Topic topic = this.getObjectMapper().map(topicDto, Topic.class);

        // Invoke DAO to persist the topic data.
        this.getTopicDAO().create(topic);

        // Finally reverse map entity information to the TopicDto.
        return this.getObjectMapper().map(topic, TopicDto.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TopicService#read(java.lang.
     * Integer)
     */
    @Override
    public TopicDto read(final Integer id) {

        // Fetch topic record for the given Id.
        final Topic topic = this.getTopicDAO().read(id);

        // If topic exists then map entity information to TopicDto.
        if (topic != null) {
            return this.getObjectMapper().map(topic, TopicDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TopicService#update(net.atos.wl.
     * odc.techhub.common.dto.TopicDto)
     */
    @Override
    public void update(final TopicDto topicDto) {

        // Fetch topic record for the given Id.
        final Topic topicFromDb = this.getTopicDAO().read(topicDto.getId());

        // Map updated information from TopicDto to topic entity.
        this.getObjectMapper().map(topicDto, topicFromDb);

        // Finally invoke DAO to update details.
        this.getTopicDAO().update(topicFromDb);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TopicService#delete(java.lang.
     * Integer)
     */
    @Override
    public void delete(final Integer id) {
        this.getTopicDAO().deleteById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.TopicService#findAllTopics()
     */
    @Override
    public List<TopicDto> findAllTopics() {

        // First fetch all topics by invoking DAO.
        final List<Topic> topics = this.getTopicDAO().findAll();

        // If topics are found them iterate through the list and map all
        // entities to TopicDto.
        if (topics != null && !topics.isEmpty()) {
            final List<TopicDto> topicDtos = new ArrayList<TopicDto>();
            for (final Topic topic : topics) {
                topicDtos.add(this.objectMapper.map(topic, TopicDto.class));
            }

            return topicDtos;
        }

        return new ArrayList<TopicDto>();
    }

    /**
     * Getter for topicDAO.
     *
     * @return the topicDAO
     */
    public final TopicDAO getTopicDAO() {
        return topicDAO;
    }

    /**
     * Setter for topicDAO.
     *
     * @param topicDAO
     *            the topicDAO to set
     */
    public final void setTopicDAO(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
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
}
