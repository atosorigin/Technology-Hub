/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

import net.atos.wl.odc.techhub.common.enums.VotingType;

/**
 * Data transfer object for vote details.
 * 
 * @author a120065
 */
public class VoteDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 1763986856498563110L;

    private VotingType voteType;

    private UserDto user;

    private TopicDto topic;

    /**
     * Getter for voteType.
     *
     * @return the voteType
     */
    public final VotingType getVoteType() {
        return voteType;
    }

    /**
     * Setter for voteType.
     *
     * @param voteType
     *            the voteType to set
     */
    public final void setVoteType(VotingType voteType) {
        this.voteType = voteType;
    }

    /**
     * Getter for user.
     *
     * @return the user
     */
    public final UserDto getUser() {
        return user;
    }

    /**
     * Setter for user.
     *
     * @param user
     *            the user to set
     */
    public final void setUser(UserDto user) {
        this.user = user;
    }

    /**
     * Getter for topic.
     *
     * @return the topic
     */
    public final TopicDto getTopic() {
        return topic;
    }

    /**
     * Setter for topic.
     *
     * @param topic
     *            the topic to set
     */
    public final void setTopic(TopicDto topic) {
        this.topic = topic;
    }
}
