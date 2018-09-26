/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.techhub.data.entity.Attendance;
import com.techhub.data.entity.User;

/**
 * Attendance DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class AttendanceDAOImpl extends AbstractJpaDAO<Attendance> implements AttendanceDAO {

    @Autowired
    private UserDAO userDAO;

    /**
     * Default constructor.
     */
    public AttendanceDAOImpl() {
        this.setClazz(Attendance.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.AttendanceDAO#markAttendance(java.lang.
     * String)
     */
    @Override
    public void markAttendance(final String userId) {

        // First get the user details for which attendance is to be marked.
        final User user = this.getUserDAO().findUserByUserId(userId);

        // Create the attendance instance and persist the same.
        final Attendance attendance = this.getAttendanceByUser(userId);
        attendance.setUser(user);

        this.persistOrMerge(attendance);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.data.dao.AttendanceDAO#getAttendance()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Attendance> getAttendance() {
        final Query query =
                        this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Attendance.fetchAttendanceByUser");
        return query.getResultList();
    }

    /**
     * Method to fetch the attendance record based on the id.
     * 
     * @param userId
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Attendance</code>.
     */
    @SuppressWarnings("unchecked")
    private Attendance getAttendanceByUser(final String userId) {
        final Query query =
                        this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Attendance.fetchAttendanceByUser");
        query.setParameter("userId", userId);
        final List<Attendance> attendances = (List<Attendance>) query.getResultList();
        if (!CollectionUtils.isEmpty(attendances)) {
            return attendances.get(0);
        }
        return new Attendance();
    }

    /**
     * Getter for userDAO.
     *
     * @return the userDAO
     */
    public final UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Setter for userDAO.
     *
     * @param userDAO
     *            the userDAO to set
     */
    public final void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
