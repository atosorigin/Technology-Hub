/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;
import net.atos.wl.odc.techhub.data.entity.Attendance;
import net.atos.wl.odc.techhub.data.entity.User;

/**
 * Attendance DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class AttendanceDAOImpl extends AbstractJpaDAO<Attendance> implements AttendanceDAO {

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
     * String, net.atos.wl.odc.techhub.common.enums.RoomNumber)
     */
    @Override
    public void markAttendance(final String userId, final RoomNumber roomNumber) {
        
        // First get the user details for which attendance is to be marked.
        final Query query = this.entityManager.createNamedQuery("net.atos.wl.odc.techhub.data.entity.User.fetchUserByUserId");
        query.setParameter("userId", userId);
        final User user = (User) query.getSingleResult();
        
        // Create the attendance instance and persist the same.
        final Attendance attendance = new Attendance();
        attendance.setRoomNumber(roomNumber);
        attendance.setUser(user);
        this.create(attendance);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.AttendanceDAO#getAttendanceByRoomNumber(
     * net.atos.wl.odc.techhub.common.enums.RoomNumber)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Attendance> getAttendanceByRoomNumber(final RoomNumber roomNumber) {
        final Query query = this.entityManager.createQuery("from Attendance a where a.roomNumber = :roomNumber");
        query.setParameter("roomNumber", roomNumber);
        return query.getResultList();
    }

}
