package com.techhub.data.entity;

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
import com.techhub.common.enums.UserType;

/**
 * JPA Entity representing the presenter information.
 */
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "com.techhub.data.entity.User.fetchUsersByTopic", query = "SELECT u FROM Topic t JOIN t.users u where t.id = :topicId"),
        @NamedQuery(name = "com.techhub.data.entity.User.fetchUserByUserId", query = "SELECT u FROM User u where u.userId = :userId")})
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
    public String getUserId() {
        return userId;
    }

    /**
     * Setter for userId.
     *
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter for firstName.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName.
     *
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName.
     *
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for mobile.
     *
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Setter for mobile.
     *
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Getter for email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email.
     *
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for location.
     *
     * @param location
     *            the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for userType.
     *
     * @return the userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Setter for userType.
     *
     * @param userType
     *            the userType to set
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
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
