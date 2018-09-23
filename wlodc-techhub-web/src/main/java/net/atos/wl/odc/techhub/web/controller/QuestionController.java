/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.wl.odc.techhub.business.service.QuestionService;
import net.atos.wl.odc.techhub.common.dto.QuestionDto;

/**
 * Spring REST Controller for exposing Questions APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/questions", tags = "Questions API")
public class QuestionController {

    private static Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    /**
     * REST service to create question.
     * 
     * @param questionDto
     *            <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/questions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a new question with choices.")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody final QuestionDto questionDto) {
        Preconditions.checkNotNull(questionDto);
        log.info("Adding a new question with description " + questionDto.getDescription());
        final QuestionDto persistedQuestionDto = this.questionService.create(questionDto);
        log.info("Topic detail was added successfully.");
        return new ResponseEntity<>(persistedQuestionDto, HttpStatus.CREATED);
    }

    /**
     * REST service to get question by given id.
     * 
     * @param id
     *            String of the question to be searched.
     * @return ResponseEntity with question and HTTP status.
     */
    @RequestMapping(value = "/api/questions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a question by id.")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("id") final Integer id) {
        log.info("Getting question details with id " + id);
        final QuestionDto questionDto = this.questionService.read(id);
        if (questionDto == null) {
            log.info("Question not found with id " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Question exists. Returning the detail for the same.");
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    /**
     * REST service to update question by given details.
     * 
     * @param questionDto
     *            <code>net.atos.wl.odc.techhub.common.dto.QuestionDto</code>.
     * @return ResponseEntity with question and HTTP status.
     */
    @RequestMapping(value = "/api/questions", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update question detail.")
    public ResponseEntity<QuestionDto> updateQuestion(@RequestBody final QuestionDto questionDto) {
        Preconditions.checkNotNull(questionDto);
        log.info("Updating question details with id " + questionDto.getId());
        this.questionService.update(questionDto);
        log.info("Question detail was updated successfully.");
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    /**
     * REST service to get all questions.
     * 
     * @return ResponseEntity with questions and HTTP status.
     */
    @RequestMapping(value = "/api/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all questions.")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        log.info("Getting all questions.");
        final List<QuestionDto> questions = this.questionService.findAllQuestions();
        log.info("Total number of questions found " + questions.size());
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
