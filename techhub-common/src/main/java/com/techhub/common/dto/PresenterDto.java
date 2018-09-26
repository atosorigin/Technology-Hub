/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for presenter details.
 * 
 * @author a120065
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PresenterDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 4993839245779845564L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("location")
    private String location;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonBackReference
    private List<TopicDto> topics;

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
     * Getter for userId.
     *
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Setter for userId.
     *
     * @param userId
     *            the userId to set
     */
    public final void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter for firstName.
     *
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName.
     *
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName.
     *
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName.
     *
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for location.
     *
     * @return the location
     */
    public final String getLocation() {
        return location;
    }

    /**
     * Setter for location.
     *
     * @param location
     *            the location to set
     */
    public final void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for email.
     *
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Setter for email.
     *
     * @param email
     *            the email to set
     */
    public final void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for mobile.
     *
     * @return the mobile
     */
    public final String getMobile() {
        return mobile;
    }

    /**
     * Setter for mobile.
     *
     * @param mobile
     *            the mobile to set
     */
    public final void setMobile(String mobile) {
        this.mobile = mobile;
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
