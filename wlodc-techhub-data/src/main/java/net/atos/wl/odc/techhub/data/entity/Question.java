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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.atos.wl.odc.techhub.common.enums.QuestionType;

/**
 * JPA Entity representing the question information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "question")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Question.fetchQuestionByTopic", query = "SELECT q FROM Topic t JOIN t.questions q where t.id = :id"),
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Question.fetchQuestionById", query = "SELECT q FROM Question q where q.id = :id")})
public class Question extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 8870114206734198057L;

    @Column(name = "number", nullable = false)
    private short number;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "correct_option", nullable = true)
    private short correctOption;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Choice> choices = new ArrayList<Choice>();

    @ManyToOne
    private Topic topic;

    /**
     * Getter for number.
     *
     * @return the number
     */
    public short getNumber() {
        return number;
    }

    /**
     * Setter for number.
     *
     * @param number
     *            the number to set
     */
    public void setNumber(short number) {
        this.number = number;
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
     * Getter for correctOption.
     *
     * @return the correctOption
     */
    public short getCorrectOption() {
        return correctOption;
    }

    /**
     * Setter for correctOption.
     *
     * @param correctOption
     *            the correctOption to set
     */
    public void setCorrectOption(short correctOption) {
        this.correctOption = correctOption;
    }

    /**
     * Getter for questionType.
     *
     * @return the questionType
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Setter for questionType.
     *
     * @param questionType
     *            the questionType to set
     */
    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * Getter for choices.
     *
     * @return the choices
     */
    public List<Choice> getChoices() {
        return choices;
    }

    /**
     * Setter for choices.
     *
     * @param choices
     *            the choices to set
     */
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
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
     * Custom method to bind choice with question.
     * 
     * @param address
     *            <code>net.atos.wl.odc.techhub.data.entity.Choice</code>.
     */
    public void addChoice(final Choice choice) {
        if (choice != null) {
            choice.setQuestion(this);
            if (this.choices != null) {
                this.choices.add(choice);
            } else {
                this.choices = new ArrayList<>();
                this.choices.add(choice);
            }
        }
    }
}
