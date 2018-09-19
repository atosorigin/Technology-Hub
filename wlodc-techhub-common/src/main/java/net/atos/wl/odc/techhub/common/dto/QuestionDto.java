/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import net.atos.wl.odc.techhub.common.enums.QuestionType;

/**
 * Data transfer object for question details.
 * 
 * @author a120065
 */
public class QuestionDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 2926166567525737111L;

    private short number;

    private String description;

    private short correctOption;

    private QuestionType questionType;

    private List<ChoiceDto> choices;

    /**
     * Getter for number.
     *
     * @return the number
     */
    public final short getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param number
     *            the number to set
     */
    public final void setNumber(short number) {
        this.number = number;
    }

    /**
     * Getter for description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description
     *            the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for correctOption.
     *
     * @return the correctOption
     */
    public final short getCorrectOption() {
        return correctOption;
    }

    /**
     * Setter for correctOption.
     *
     * @param correctOption
     *            the correctOption to set
     */
    public final void setCorrectOption(short correctOption) {
        this.correctOption = correctOption;
    }

    /**
     * Getter for questionType.
     *
     * @return the questionType
     */
    public final QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Setter for questionType.
     *
     * @param questionType
     *            the questionType to set
     */
    public final void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * Getter for choices.
     *
     * @return the choices
     */
    public final List<ChoiceDto> getChoices() {
        return choices;
    }

    /**
     * Setter for choices.
     *
     * @param choices
     *            the choices to set
     */
    public final void setChoices(List<ChoiceDto> choices) {
        this.choices = choices;
    }
}
