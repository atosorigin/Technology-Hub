/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JPA Entity representing the location information.
 */
@Entity
@Table(name = "location")
@NamedQueries({
        @NamedQuery(name = "com.techhub.data.entity.Location.fetchLocationByCode", query = "SELECT l FROM Location l where l.code = :code")})
public class Location extends PersistableEntity {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 8500121331716474258L;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "location", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<Room>();

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
     * Getter for address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for address.
     *
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for rooms.
     *
     * @return the rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Setter for rooms.
     *
     * @param rooms
     *            the rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
