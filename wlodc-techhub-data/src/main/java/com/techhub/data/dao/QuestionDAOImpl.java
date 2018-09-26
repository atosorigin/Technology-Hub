/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import org.springframework.stereotype.Repository;

import com.techhub.data.entity.Question;

/**
 * Question DAO Implementation.
 * 
 * @author a120065
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
