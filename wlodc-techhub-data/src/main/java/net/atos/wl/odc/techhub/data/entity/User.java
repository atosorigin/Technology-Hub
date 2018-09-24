/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import net.atos.wl.odc.techhub.common.enums.UserType;

/**
 * JPA Entity representing the presenter information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.User.fetchUsersByTopic", query = "SELECT u FROM Topic t JOIN t.users u where t.id = :topicId"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.User.fetchUserByUserId", query = "SELECT u FROM User u where u.userId = :userId")})
public class User extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 6490416745249648193L;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "location", nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @ManyToMany(mappedBy = "users")
    @JsonBackReference
    private List<Topic> topics = new ArrayList<Topic>();

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
     * Getter for userType.
     *
     * @return the userType
     */
    public final UserType getUserType() {
        return userType;
    }

    /**
     * Setter for userType.
     *
     * @param userType
     *            the userType to set
     */
    public final void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * Getter for topics.
     *
     * @return the topics
     */
    public final List<Topic> getTopics() {
        return topics;
    }

    /**
     * Setter for topics.
     *
     * @param topics
     *            the topics to set
     */
    public final void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

}
