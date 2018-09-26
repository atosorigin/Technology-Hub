package com.techhub.data.dao;

import java.util.List;

import com.techhub.data.entity.Attendance;

/**
 * Attendance DAO.
 */
public interface AttendanceDAO extends GenericDAO<Attendance> {

    /**
     * Method to mark the attendance for the given user and room.
     * 
     * @param userId
     *            String.
     */
    void markAttendance(final String userId);

    /**
     * Method to get attendance for the event.
     * 
     * @return List of
     *         <code>net.atos.wl.odc.techhub.data.entity.Attendance</code>.
     */
    List<Attendance> getAttendance();
}
