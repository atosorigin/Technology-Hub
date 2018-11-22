/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import com.techhub.common.dto.LocationDto;

/**
 * Location Service.
 */
public interface LocationService {

    /**
     * Method to find a location by given code.
     * 
     * @param code
     *            String.
     * @return <code>com.techhub.common.dto.LocationDto</code>.
     */
    LocationDto findLocationByCode(final String code);
}
