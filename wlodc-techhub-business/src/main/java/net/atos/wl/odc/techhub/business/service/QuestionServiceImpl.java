/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.business.mapper.ObjectMapper;
import net.atos.wl.odc.techhub.common.dto.QuestionDto;
import net.atos.wl.odc.techhub.data.dao.QuestionDAO;
import net.atos.wl.odc.techhub.data.entity.Question;

/**
 * Question Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    /**
     * Question DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private QuestionDAO questionDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.QuestionService#create(net.atos.
     * wl. odc.techhub.common.dto.QuestionDto)
     */
    @Override
    public QuestionDto create(final QuestionDto questionDto) {

        // First map all information passed from QuestionDto to Question
        // entity.
        final Question question = this.getObjectMapper().map(questionDto, Question.class);

        // Invoke DAO to persist the question data.
        this.getQuestionDAO().create(question);

        // Finally reverse map entity information to the QuestionDto.
        return this.getObjectMapper().map(question, QuestionDto.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.QuestionService#read(java.lang.
     * Integer)
     */
    @Override
    public QuestionDto read(final Integer id) {

        // Fetch question record for the given Id.
        final Question question = this.getQuestionDAO().read(id);

        // If question exists then map entity information to QuestionDto.
        if (question != null) {
            return this.getObjectMapper().map(question, QuestionDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.QuestionService#update(net.atos.
     * wl. odc.techhub.common.dto.QuestionDto)
     */
    @Override
    public void update(final QuestionDto questionDto) {

        // Fetch question record for the given Id.
        final Question questionFromDb = this.getQuestionDAO().read(questionDto.getId());

        // Map updated information from QuestionDto to question entity.
        this.getObjectMapper().map(questionDto, questionFromDb);

        // Finally invoke DAO to update details.
        this.getQuestionDAO().update(questionFromDb);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.QuestionService#delete(java.
     * lang. Integer)
     */
    @Override
    public void delete(final Integer id) {
        this.getQuestionDAO().deleteById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.QuestionService#findAllQuestions
     * ()
     */
    @Override
    public List<QuestionDto> findAllQuestions() {

        // First fetch all questions by invoking DAO.
        final List<Question> questions = this.getQuestionDAO().findAll();

        // If questions are found them iterate through the list and map all
        // entities to QuestionDto.
        if (questions != null && !questions.isEmpty()) {
            final List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
            for (final Question question : questions) {
                questionDtos.add(this.objectMapper.map(question, QuestionDto.class));
            }

            return questionDtos;
        }

        return new ArrayList<QuestionDto>();
    }

    /**
     * Getter for questionDAO.
     *
     * @return the questionDAO
     */
    public final QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    /**
     * Setter for questionDAO.
     *
     * @param questionDAO
     *            the questionDAO to set
     */
    public final void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    /**
     * Getter for objectMapper.
     *
     * @return the objectMapper
     */
    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Setter for objectMapper.
     *
     * @param objectMapper
     *            the objectMapper to set
     */
    public final void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
