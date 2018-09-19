/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JPA Entity representing the event information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "event")
public class Event extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 6482268712824358166L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "event_date")
    private Date eventDate;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Topic> topics = new ArrayList<Topic>();

    /**
     * Getter for name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for eventDate.
     *
     * @return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Setter for eventDate.
     *
     * @param eventDate
     *            the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Getter for topics.
     *
     * @return the topics
     */
    public List<Topic> getTopics() {
        return topics;
    }

    /**
     * Setter for topics.
     *
     * @param topics
     *            the topics to set
     */
    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

}
