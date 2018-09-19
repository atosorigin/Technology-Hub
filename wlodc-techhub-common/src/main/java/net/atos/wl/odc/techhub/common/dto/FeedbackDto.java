/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

/**
 * Data transfer object for feedback details.
 * 
 * @author a120065
 */
public class FeedbackDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -21413749808090539L;

    private UserDto user;

    private QuestionDto question;

    private ChoiceDto choice;

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
     * Getter for question.
     *
     * @return the question
     */
    public final QuestionDto getQuestion() {
        return question;
    }

    /**
     * Setter for question.
     *
     * @param question
     *            the question to set
     */
    public final void setQuestion(QuestionDto question) {
        this.question = question;
    }

    /**
     * Getter for choice.
     *
     * @return the choice
     */
    public final ChoiceDto getChoice() {
        return choice;
    }

    /**
     * Setter for choice.
     *
     * @param choice
     *            the choice to set
     */
    public final void setChoice(ChoiceDto choice) {
        this.choice = choice;
    }

}
