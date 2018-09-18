/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * JPA Entity representing the attendance information.
 * 
 * @author a120065
 */
@Entity
@Table(name = "attendance")
public class Attendance extends AuditableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -1444104657894313645L;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_number", nullable = false)
    private RoomNumber roomNumber;

    @ManyToOne
    private User user;

    /**
     * Getter for roomNumber.
     *
     * @return the roomNumber
     */
    public RoomNumber getRoomNumber() {
        return roomNumber;
    }

    /**
     * Setter for roomNumber.
     *
     * @param roomNumber
     *            the roomNumber to set
     */
    public void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

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
