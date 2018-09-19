/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for user details.
 * 
 * @author a120065
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -604018936275238886L;

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

}
