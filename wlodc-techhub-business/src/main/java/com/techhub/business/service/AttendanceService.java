/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.AttendanceDto;

/**
 * Attendance Service.
 * 
 * @author a120065
 */
public interface AttendanceService {

    /**
     * Method to mark the attendance for the given user.
     * 
     * @param userId
     *            String.
     */
    void markAttendance(final String userId);

    /**
     * Method to get attendance for the event.
     * 
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.AttendanceDto</code>.
     */
    List<AttendanceDto> getAttendance();
}
