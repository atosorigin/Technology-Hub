package com.techhub.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for poster details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PosterDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("participants")
    private String participants;

    @JsonProperty("url")
    private String url;

    /**
     * Getter for id.
     *
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id
     *            the id to set
     */
    public final void setId(Integer id) {
        this.id = id;
    }

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
     * Getter for participants.
     *
     * @return the participants
     */
    public final String getParticipants() {
        return participants;
    }

    /**
     * Setter for participants.
     *
     * @param participants
     *            the participants to set
     */
    public final void setParticipants(String participants) {
        this.participants = participants;
    }

    /**
     * Getter for url.
     *
     * @return the url
     */
    public final String getUrl() {
        return url;
    }

    /**
     * Setter for url.
     *
     * @param url
     *            the url to set
     */
    public final void setUrl(String url) {
        this.url = url;
    }
}
