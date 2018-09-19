/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.common.dto;

import java.io.Serializable;

import net.atos.wl.odc.techhub.common.enums.RoomNumber;

/**
 * Data transfer object for attendance details.
 * 
 * @author a120065
 */
public class AttendanceDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -7213220166365549430L;

    private RoomNumber roomNumber;

    private UserDto user;

    /**
     * Getter for roomNumber.
     *
     * @return the roomNumber
     */
    public final RoomNumber getRoomNumber() {
        return roomNumber;
    }

    /**
     * Setter for roomNumber.
     *
     * @param roomNumber
     *            the roomNumber to set
     */
    public final void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Getter for user.
     *
     * @return the user
     */
    public final UserDto getUser() {
        return user;
    }

    /**
     * Setter for user.
     *
     * @param user
     *            the user to set
     */
    public final void setUser(UserDto user) {
        this.user = user;
    }
}
