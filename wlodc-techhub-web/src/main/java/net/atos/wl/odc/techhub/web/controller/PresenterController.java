/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

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

import net.atos.wl.odc.techhub.business.service.PresenterService;
import net.atos.wl.odc.techhub.common.dto.PresenterDto;

/**
 * Spring REST Controller for exposing presenter APIs.
 * 
 * @author a120065
 */
@RestController
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
    public ResponseEntity<PresenterDto> getPresenter(@PathVariable("id") final String userId) {
        log.info("Getting presenter details with user Id", userId);
        final PresenterDto presenterDto = this.presenterService.findPresenterByUserId(userId);

        if (presenterDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
        return new ResponseEntity<>(presenterDto, HttpStatus.OK);
    }

    /**
     * REST service to delete presenter by given id.
     * 
     * @param id
     *            Integer of the presenter to be searched.
     * @return ResponseEntity with presenter and HTTP status.
     */
    @RequestMapping(value = "/api/presenters/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PresenterDto> deletePresenter(@PathVariable("id") final Integer id) {

        final PresenterDto presenterDto = this.presenterService.read(id);

        if (presenterDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.presenterService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
