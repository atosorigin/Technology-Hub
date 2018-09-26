/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.techhub.business.service.AttendanceService;
import com.techhub.common.dto.AttendanceDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Spring REST Controller for exposing Attendance APIs.
 * 
 * @author a120065
 */
@RestController
@Api(value = "/api/attendance", tags = "Attendance API")
public class AttendanceController {

    private static Logger log = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    private AttendanceService attendanceService;

    /**
     * REST service to mark attendance of the user.
     * 
     * @param attendanceDto
     *            <code>net.atos.wl.odc.techhub.common.dto.AttendanceDto</code>.
     * @return ResponseEntity with headers and HTTP status.
     */
    @RequestMapping(value = "/api/attendance", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mark attendance of a user for a particular room.")
    public ResponseEntity<AttendanceDto> markAttendance(@RequestBody final AttendanceDto attendanceDto) {
        Preconditions.checkNotNull(attendanceDto);
        log.info("Marking attendance for user with id " + attendanceDto.getUserId());
        this.attendanceService.markAttendance(attendanceDto.getUserId());
        log.info("Attendance has been marked successfully.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * REST service to get attendance for the event.
     * 
     * @return ResponseEntity with attendance and HTTP status.
     */
    @RequestMapping(value = "/api/attendance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get attendance for the event.")
    public ResponseEntity<List<AttendanceDto>> getAttendance() {
        log.info("Getting attendance for the event");
        final List<AttendanceDto> attendance = this.attendanceService.getAttendance();
        log.info("Attendance size is " + attendance.size());
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }
}
