package com.techhub.data.dao;

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
}
