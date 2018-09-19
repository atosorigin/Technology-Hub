/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.QuestionDto;

/**
 * Question Service.
 * 
 * @author a120065
 */
public interface QuestionService {

    /**
     * Method create a new question record in DB.
     * 
     * @param questionDto
     *            <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code> .
     * @return <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code>.
     */
    QuestionDto create(final QuestionDto questionDto);

    /**
     * Method to fetch question details for the given question Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code>.
     */
    QuestionDto read(final Integer id);

    /**
     * Method to update question details.
     * 
     * @param questionDto
     *            <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code> .
     */
    void update(final QuestionDto questionDto);

    /**
     * Method to delete the given question record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find all questions.
     * 
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code>.
     */
    List<QuestionDto> findAllQuestions();
}
