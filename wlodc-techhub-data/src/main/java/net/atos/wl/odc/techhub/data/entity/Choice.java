/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * JPA Entity representing the various options available for given question.
 * 
 * @author a120065
 */
@Entity
@Table(name = "choice")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Choice.fetchChoiceById", query = "SELECT c FROM Choice c where c.id = :id")})
public class Choice extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -7814062361274452275L;

    @Column(name = "number", nullable = false)
    private short number;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    private Question question;

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
     * Getter for question.
     *
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Setter for question.
     *
     * @param question
     *            the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

}
