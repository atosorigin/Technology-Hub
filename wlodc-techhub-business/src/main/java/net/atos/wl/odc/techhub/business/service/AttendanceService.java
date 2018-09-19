/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.AttendanceDto;
import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * Attendance Service.
 * 
 * @author a120065
 */
public interface AttendanceService {

    /**
     * Method to mark the attendance for the given user and room.
     * 
     * @param userId
     *            String.
     * @param roomNumber
     *            <code>net.atos.wl.odc.techhub.common.enums.RoomNumber</code>.
     */
    void markAttendance(final String userId, final RoomNumber roomNumber);

    /**
     * Method to get attendance by room number.
     * 
     * @param roomNumber
     *            <code>net.atos.wl.odc.techhub.common.enums.RoomNumber</code>.
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.AttendanceDto</code>.
     */
    List<AttendanceDto> getAttendanceByRoomNumber(final RoomNumber roomNumber);
}
