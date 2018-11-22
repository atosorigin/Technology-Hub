/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import com.techhub.data.entity.Location;

/**
 * Location DAO
 */
public interface LocationDAO extends GenericDAO<Location> {

    /**
     * Method to find a location by given code.
     * 
     * @param code
     *            String.
     * @return <code>com.techhub.data.entity.Location</code>.
     */
    Location findLocationByCode(final String code);
}
