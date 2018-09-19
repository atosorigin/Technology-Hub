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
import net.atos.wl.odc.techhub.business.service.PresenterService;
import net.atos.wl.odc.techhub.common.dto.PresenterDto;

/**
 * Spring REST Controller for exposing presenter APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/presenters", tags = "Presenter API")
public class PresenterController {

    private static Logger log = LoggerFactory.getLogger(PresenterController.class);

    @Autowired
    private PresenterService presenterService;

    /**
     * REST service to create presenter.
     * 
     * @param presenterDto
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     * @param ucBuilder
     *            <code>org.springframework.web.util.UriComponentsBuilder</code>
     *            .
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/presenters", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PresenterDto> createPresenter(@RequestBody final PresenterDto presenterDto) {
        Preconditions.checkNotNull(presenterDto);
        log.info("Adding a new presenter details with user Id", presenterDto.getUserId());
        final PresenterDto persistedPresenterDto = this.presenterService.create(presenterDto);
        log.info("Presenter detail was added successfully.");
        return new ResponseEntity<>(persistedPresenterDto, HttpStatus.CREATED);
    }

    /**
     * REST service to get presenter by given userId.
     * 
     * @param userId
     *            String of the presenter to be searched.
     * @return ResponseEntity with presenter and HTTP status.
     */
    @RequestMapping(value = "/api/presenters/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PresenterDto> getPresenter(@PathVariable("userId") final String userId) {
        log.info("Getting presenter details with user Id", userId);
        final PresenterDto presenterDto = this.presenterService.findPresenterByUserId(userId);
        if (presenterDto == null) {
            log.info("Presenter not found with user Id", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.info("Presenter exists. Returning the detail for the same.");
        return new ResponseEntity<>(presenterDto, HttpStatus.OK);
    }

    /**
     * REST service to update presenter by given details.
     * 
     * @param presenterDto
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code> .
     * @return ResponseEntity with presenter and HTTP status.
     */
    @RequestMapping(value = "/api/presenters", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PresenterDto> updatePresenter(@RequestBody final PresenterDto presenterDto) {
        Preconditions.checkNotNull(presenterDto);
        log.info("Updating presenter details with user Id", presenterDto.getUserId());
        this.presenterService.update(presenterDto);
        log.info("Presenter detail was updated successfully.");
        return new ResponseEntity<>(presenterDto, HttpStatus.OK);
    }

    /**
     * REST service to get all presenters.
     * 
     * @param userId
     *            String of the presenter to be searched.
     * @return ResponseEntity with presenter and HTTP status.
     */
    @RequestMapping(value = "/api/presenters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PresenterDto>> getAllPresenters() {
        log.info("Getting all presenters.");
        final List<PresenterDto> presenters = this.presenterService.findAllPresenters();
        log.info("Total number of presenters found", presenters.size());
        return new ResponseEntity<>(presenters, HttpStatus.OK);
    }
}
