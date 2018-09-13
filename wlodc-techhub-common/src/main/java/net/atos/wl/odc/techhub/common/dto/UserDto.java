/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

/**
 * Data transfer object for user details.
 * 
 * @author a120065
 */
public class UserDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -604018936275238886L;

    private String userId;

    private String firstName;

    private String lastName;

    private String location;

    private String email;

    private String mobile;

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
