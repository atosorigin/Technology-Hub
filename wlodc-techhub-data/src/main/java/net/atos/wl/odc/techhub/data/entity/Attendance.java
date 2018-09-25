/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * JPA Entity representing the attendance information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "attendance")
@NamedQueries({
        @NamedQuery(name = "net.atos.wl.odc.techhub.data.entity.Attendance.fetchAttendanceByUser", query = "SELECT a FROM Attendance a WHERE a.user.userId = :userId")})
public class Attendance extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -1444104657894313645L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;

    /**
     * Getter for user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for user.
     *
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
