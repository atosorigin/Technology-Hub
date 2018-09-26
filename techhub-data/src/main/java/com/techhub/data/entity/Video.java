package com.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * JPA Entity representing the video information.
 */
@Entity
@Table(name = "video")
public class Video extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -4930060110623424334L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "participants", nullable = false)
    private String participants;

    @Column(name = "url", nullable = false)
    private String url;

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
     * Getter for participants.
     *
     * @return the participants
     */
    public String getParticipants() {
        return participants;
    }

    /**
     * Setter for participants.
     *
     * @param participants
     *            the participants to set
     */
    public void setParticipants(String participants) {
        this.participants = participants;
    }

    /**
     * Getter for url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for url.
     *
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
