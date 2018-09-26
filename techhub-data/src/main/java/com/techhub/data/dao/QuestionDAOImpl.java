package com.techhub.data.dao;

import org.springframework.stereotype.Repository;

import com.techhub.data.entity.Question;

/**
 * Question DAO Implementation.
 */
@Repository
public class QuestionDAOImpl extends AbstractJpaDAO<Question> implements QuestionDAO {

    /**
     * Default constructor.
     */
    public QuestionDAOImpl() {
        this.setClazz(Question.class);
    }
}
