/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.common.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data transfer object for location details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 7034857670893679636L;

    private String code;

    private String name;

    private String address;

    private List<RoomDto> rooms;

    /**
     * Getter for code.
     *
     * @return the code
     */
    public final String getCode() {
        return code;
    }

    /**
     * Setter for code.
     *
     * @param code
     *            the code to set
     */
    public final void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name
     *            the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for address.
     *
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Setter for address.
     *
     * @param address
     *            the address to set
     */
    public final void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for rooms.
     *
     * @return the rooms
     */
    public final List<RoomDto> getRooms() {
        return rooms;
    }

    /**
     * Setter for rooms.
     *
     * @param rooms
     *            the rooms to set
     */
    public final void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
