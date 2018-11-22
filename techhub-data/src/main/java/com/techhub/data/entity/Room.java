/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA Entity representing the room information.
 */
@Entity
@Table(name = "room")
public class Room extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = -3280970819560533246L;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne
    private Location location;

    /**
     * Getter for code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for code.
     *
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for capacity.
     *
     * @return the capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Setter for capacity.
     *
     * @param capacity
     *            the capacity to set
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter for location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setter for location.
     *
     * @param location
     *            the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
