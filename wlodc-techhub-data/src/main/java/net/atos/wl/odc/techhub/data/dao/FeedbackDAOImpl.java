/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import net.atos.wl.odc.techhub.common.dto.FeedbackDto;
import net.atos.wl.odc.techhub.data.entity.Choice;
import net.atos.wl.odc.techhub.data.entity.Feedback;
import net.atos.wl.odc.techhub.data.entity.Question;
import net.atos.wl.odc.techhub.data.entity.User;

/**
 * Feedback DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class FeedbackDAOImpl extends AbstractJpaDAO<Feedback> implements FeedbackDAO {

    /**
     * Default constructor.
     */
    public FeedbackDAOImpl() {
        this.setClazz(Feedback.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.FeedbackDAO#postUserFeedback(java.util.
     * List)
     */
    @Override
    public void postUserFeedback(final List<FeedbackDto> userFeedbacks) {

        // First get the user Id for which feedback has to be persisted.
        final String userId = userFeedbacks.get(0).getUserId();

        // First get the user details for which attendance is to be marked.
        final Query query = this.entityManager
                        .createNamedQuery("net.atos.wl.odc.techhub.data.entity.User.fetchUserByUserId");
        query.setParameter("userId", userId);
        final User user = (User) query.getSingleResult();

        for (final FeedbackDto feedbackDto : userFeedbacks) {
            final Feedback feedback = this.getUserFeedback(feedbackDto.getUserId(), feedbackDto.getQuestionId());
            final Question question = this.getQuestion(feedbackDto.getQuestionId());
            final Choice choice = this.getChoice(feedbackDto.getChoiceId());

            feedback.setUser(user);
            feedback.setQuestion(question);
            feedback.setChoice(choice);

            this.persistOrMerge(feedback);
        }
    }

    /**
     * Method to fetch the feedback record for given user Id and question Id if
     * it exists else return emtpy entity.
     * 
     * @param userId
     *            String.
     * @param questionId
     *            Int.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Feedback</code>.
     */
    @SuppressWarnings("unchecked")
    private Feedback getUserFeedback(final String userId, final Integer questionId) {
        final Query query = this.entityManager.createNamedQuery(
                        "net.atos.wl.odc.techhub.data.entity.Feedback.fetchFeedbackByUserAndQuestion");
        query.setParameter("userId", userId);
        query.setParameter("questionId", questionId);

        final List<Feedback> feedbacks = (List<Feedback>) query.getResultList();
        if (!CollectionUtils.isEmpty(feedbacks)) {
            return feedbacks.get(0);
        }
        return new Feedback();
    }

    /**
     * Method to fetch the question record based on the id.
     * 
     * @param questionId
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Question</code>.
     */
    private Question getQuestion(final Integer questionId) {
        final Query query = this.entityManager
                        .createNamedQuery("net.atos.wl.odc.techhub.data.entity.Question.fetchQuestionById");
        query.setParameter("id", questionId);
        return (Question) query.getSingleResult();
    }

    /**
     * Method to fetch the choice record based on the id.
     * 
     * @param choiceId
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Choice</code>.
     */
    private Choice getChoice(final Integer choiceId) {
        final Query query = this.entityManager
                        .createNamedQuery("net.atos.wl.odc.techhub.data.entity.Choice.fetchChoiceById");
        query.setParameter("id", choiceId);
        return (Choice) query.getSingleResult();
    }
}
