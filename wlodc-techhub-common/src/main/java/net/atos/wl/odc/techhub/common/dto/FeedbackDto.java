/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object for feedback details.
 * 
 * @author a120065
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -21413749808090539L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("questionId")
    private Integer questionId;

    @JsonProperty("choiceId")
    private Integer choiceId;

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
     * Getter for questionId.
     *
     * @return the questionId
     */
    public final Integer getQuestionId() {
        return questionId;
    }

    /**
     * Setter for questionId.
     *
     * @param questionId
     *            the questionId to set
     */
    public final void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * Getter for choiceId.
     *
     * @return the choiceId
     */
    public final Integer getChoiceId() {
        return choiceId;
    }

    /**
     * Setter for choiceId.
     *
     * @param choiceId
     *            the choiceId to set
     */
    public final void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }
}
