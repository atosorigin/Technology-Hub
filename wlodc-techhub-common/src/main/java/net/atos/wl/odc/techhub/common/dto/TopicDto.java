/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * Data transfer object for topic details.
 * 
 * @author a120065
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -1015245138266683167L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("timeSlot")
    private String timeSlot;

    @JsonProperty("roomNumber")
    private RoomNumber roomNumber;

    @JsonManagedReference
    private List<PresenterDto> presenters;

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
     * Getter for imageUrl.
     *
     * @return the imageUrl
     */
    public final String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter for imageUrl.
     *
     * @param imageUrl
     *            the imageUrl to set
     */
    public final void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Getter for timeSlot.
     *
     * @return the timeSlot
     */
    public final String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Setter for timeSlot.
     *
     * @param timeSlot
     *            the timeSlot to set
     */
    public final void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Getter for roomNumber.
     *
     * @return the roomNumber
     */
    public final RoomNumber getRoomNumber() {
        return roomNumber;
    }

    /**
     * Setter for roomNumber.
     *
     * @param roomNumber
     *            the roomNumber to set
     */
    public final void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Getter for presenters.
     *
     * @return the presenters
     */
    public final List<PresenterDto> getPresenters() {
        return presenters;
    }

    /**
     * Setter for presenters.
     *
     * @param presenters
     *            the presenters to set
     */
    public final void setPresenters(List<PresenterDto> presenters) {
        this.presenters = presenters;
    }
}
