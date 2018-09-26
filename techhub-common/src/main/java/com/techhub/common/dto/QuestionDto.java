package com.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techhub.common.enums.AnswerType;
import com.techhub.common.enums.QuestionType;

/**
 * Data transfer object for question details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 2926166567525737111L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("number")
    private short number;

    @JsonProperty("description")
    private String description;

    @JsonProperty("correctOption")
    private Integer correctOption;

    @JsonProperty("questionType")
    private QuestionType questionType;

    @JsonProperty("answerType")
    private AnswerType answerType;

    private List<ChoiceDto> choices;

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
    public final Integer getCorrectOption() {
        return correctOption;
    }

    /**
     * Setter for correctOption.
     *
     * @param correctOption
     *            the correctOption to set
     */
    public final void setCorrectOption(Integer correctOption) {
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
     * Getter for answerType.
     *
     * @return the answerType
     */
    public final AnswerType getAnswerType() {
        return answerType;
    }

    /**
     * Setter for answerType.
     *
     * @param answerType
     *            the answerType to set
     */
    public final void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
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
