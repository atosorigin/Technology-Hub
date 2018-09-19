/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Data transfer object for event details.
 * 
 * @author a120065
 */
public class EventDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -102053208665368724L;

    private String name;

    private String description;

    private Date eventDate;

    private List<TopicDto> topics;

    /**
     * Getter for name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name
     *            the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description
     *            the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for eventDate.
     *
     * @return the eventDate
     */
    public final Date getEventDate() {
        return eventDate;
    }

    /**
     * Setter for eventDate.
     *
     * @param eventDate
     *            the eventDate to set
     */
    public final void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Getter for topics.
     *
     * @return the topics
     */
    public final List<TopicDto> getTopics() {
        return topics;
    }

    /**
     * Setter for topics.
     *
     * @param topics
     *            the topics to set
     */
    public final void setTopics(List<TopicDto> topics) {
        this.topics = topics;
    }
}
