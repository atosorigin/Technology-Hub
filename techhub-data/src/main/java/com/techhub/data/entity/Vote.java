/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.techhub.common.enums.VotingType;

/**
 * JPA Entity representing the voting information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "vote")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Vote.fetchVoteByUserAndVoteType", query = "SELECT v FROM Vote v where v.user.userId = :userId AND v.voteType = :voteType")})
public class Vote extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -6557666770366079700L;

    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type", nullable = false)
    private VotingType voteType;

    @OneToOne
    private User user;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private Poster poster;

    @ManyToOne
    private Video video;

    /**
     * Getter for voteType.
     *
     * @return the voteType
     */
    public VotingType getVoteType() {
        return voteType;
    }

    /**
     * Setter for voteType.
     *
     * @param voteType
     *            the voteType to set
     */
    public void setVoteType(VotingType voteType) {
        this.voteType = voteType;
    }

    /**
     * Getter for user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for user.
     *
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter for topic.
     *
     * @return the topic
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * Setter for topic.
     *
     * @param topic
     *            the topic to set
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * Getter for poster.
     *
     * @return the poster
     */
    public Poster getPoster() {
        return poster;
    }

    /**
     * Setter for poster.
     *
     * @param poster
     *            the poster to set
     */
    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    /**
     * Getter for video.
     *
     * @return the video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Setter for video.
     *
     * @param video
     *            the video to set
     */
    public void setVideo(Video video) {
        this.video = video;
    }

}
