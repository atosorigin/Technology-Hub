/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * Data transfer object for topic details.
 * 
 * @author a120065
 */
public class TopicDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -1015245138266683167L;

    private Integer id;

    private String name;

    private String description;

    private String imageUrl;

    private String timeSlot;

    private RoomNumber roomNumber;

    private List<PresenterDto> presenters;

    private List<UserDto> users;

    private List<QuestionDto> questions;

    private List<VoteDto> votes;

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

    /**
     * Getter for users.
     *
     * @return the users
     */
    public final List<UserDto> getUsers() {
        return users;
    }

    /**
     * Setter for users.
     *
     * @param users
     *            the users to set
     */
    public final void setUsers(List<UserDto> users) {
        this.users = users;
    }

    /**
     * Getter for questions.
     *
     * @return the questions
     */
    public final List<QuestionDto> getQuestions() {
        return questions;
    }

    /**
     * Setter for questions.
     *
     * @param questions
     *            the questions to set
     */
    public final void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    /**
     * Getter for votes.
     *
     * @return the votes
     */
    public final List<VoteDto> getVotes() {
        return votes;
    }

    /**
     * Setter for votes.
     *
     * @param votes
     *            the votes to set
     */
    public final void setVotes(List<VoteDto> votes) {
        this.votes = votes;
    }
}
