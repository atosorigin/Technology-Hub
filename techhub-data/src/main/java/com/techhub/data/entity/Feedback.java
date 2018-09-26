package com.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * JPA Entity representing the feedback information.
 */
@Entity
@Table(name = "feedback")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Feedback.fetchFeedbackByUserAndQuestion", query = "SELECT f FROM Feedback f where f.user.userId = :userId AND f.question.id = :questionId")})
public class Feedback extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 1937708998850202227L;

    @Column(name = "text")
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Choice choice;

    /**
     * Getter for text.
     *
     * @return the text
     */
    public final String getText() {
        return text;
    }

    /**
     * Setter for text.
     *
     * @param text
     *            the text to set
     */
    public final void setText(String text) {
        this.text = text;
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

    /**
     * Getter for choice.
     *
     * @return the choice
     */
    public Choice getChoice() {
        return choice;
    }

    /**
     * Setter for choice.
     *
     * @param choice
     *            the choice to set
     */
    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
