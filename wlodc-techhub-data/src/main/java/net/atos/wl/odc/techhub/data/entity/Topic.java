/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * JPA Entity representing the topic information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "topic")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchAllTopics", query = "SELECT t FROM Topic t"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicById", query = "SELECT t FROM Topic t where t.id = :id"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByRoom", query = "SELECT t FROM Topic t where t.roomNumber = :roomNumber"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsBySlot", query = "SELECT t FROM Topic t where t.timeSlot = :timeSlot"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByPresenter", query = "SELECT t FROM Presenter p JOIN p.topics t where p.id = :presenterId"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicsByUser", query = "SELECT t FROM User u JOIN u.topics t where u.userId = :userId"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Topic.fetchTopicByIdAndUser", query = "SELECT t FROM User u JOIN u.topics t where u.userId = :userId AND t.id = :topicId")})
public class Topic extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 4641162454535635911L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "time_slot", nullable = true)
    private String timeSlot;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_number", nullable = false)
    private RoomNumber roomNumber;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "topic_presenter_table", joinColumns = {@JoinColumn(name = "topic_id")}, inverseJoinColumns = {
            @JoinColumn(name = "presenter_id")})
    @JsonManagedReference
    private List<Presenter> presenters = new ArrayList<Presenter>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "topic_user_table", joinColumns = {@JoinColumn(name = "topic_id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id")})
    @JsonManagedReference
    private List<User> users = new ArrayList<User>();

    @OneToMany(mappedBy = "topic", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<Question>();

    @OneToMany(mappedBy = "topic")
    private List<Vote> votes = new ArrayList<Vote>();

    @ManyToOne
    private Event event;

    /**
     * Custom method to register user with topic.
     * 
     * @param address
     *            <code>net.atos.wl.odc.techhub.data.entity.User</code>.
     */
    public void addUser(final User user) {
        if (user != null) {
            if (this.users != null) {
                this.users.add(user);
            } else {
                this.users = new ArrayList<>();
                this.users.add(user);
            }
        }
    }

    /**
     * Custom method to un-register user from topic.
     * 
     * @param address
     *            <code>net.atos.wl.odc.techhub.data.entity.User</code>.
     */
    public void removeUser(final User user) {
        if (user != null) {
            if (this.users != null) {
                this.users.remove(user);
            }
        }
    }

    /**
     * Custom method to add presenter to a topic.
     * 
     * @param address
     *            <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     */
    public void addPresenter(final Presenter presenter) {
        if (presenter != null) {
            if (this.presenters != null) {
                this.presenters.add(presenter);
            } else {
                this.presenters = new ArrayList<>();
                this.presenters.add(presenter);
            }
        }
    }

    /**
     * Custom method to remove presenter from a topic.
     * 
     * @param address
     *            <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     */
    public void removePresenter(final Presenter presenter) {
        if (presenter != null) {
            if (this.presenters != null) {
                this.presenters.remove(presenter);
            }
        }
    }

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
     * Getter for imageUrl.
     *
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter for imageUrl.
     *
     * @param imageUrl
     *            the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Getter for timeSlot.
     *
     * @return the timeSlot
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Setter for timeSlot.
     *
     * @param timeSlot
     *            the timeSlot to set
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Getter for roomNumber.
     *
     * @return the roomNumber
     */
    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    /**
     * Setter for roomNumber.
     *
     * @param roomNumber
     *            the roomNumber to set
     */
    public void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Getter for presenters.
     *
     * @return the presenters
     */
    public List<Presenter> getPresenters() {
        return presenters;
    }

    /**
     * Setter for presenters.
     *
     * @param presenters
     *            the presenters to set
     */
    public void setPresenters(List<Presenter> presenters) {
        this.presenters = presenters;
    }

    /**
     * Getter for users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Setter for users.
     *
     * @param users
     *            the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Getter for questions.
     *
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Setter for questions.
     *
     * @param questions
     *            the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Getter for votes.
     *
     * @return the votes
     */
    public List<Vote> getVotes() {
        return votes;
    }

    /**
     * Setter for votes.
     *
     * @param votes
     *            the votes to set
     */
    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * Getter for event.
     *
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Setter for event.
     *
     * @param event
     *            the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }
}
