package com.techhub.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data transfer object for room details.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto implements Serializable {

    /**
     * Generated serial version.
     */
    private static final long serialVersionUID = -8239758584759728112L;

    private String code;

    private String name;

    private String floor;

    private Integer capacity;

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
     * Getter for floor.
     *
     * @return the floor
     */
    public final String getFloor() {
        return floor;
    }

    /**
     * Setter for floor.
     *
     * @param floor
     *            the floor to set
     */
    public final void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * Getter for capacity.
     *
     * @return the capacity
     */
    public final Integer getCapacity() {
        return capacity;
    }

    /**
     * Setter for capacity.
     *
     * @param capacity
     *            the capacity to set
     */
    public final void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}
