/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.business.mapper.ObjectMapper;
import com.techhub.common.dto.LocationDto;
import com.techhub.data.dao.LocationDAO;
import com.techhub.data.entity.Location;

/**
 * Location Service Implementation.
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    /**
     * Location DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private LocationDAO locationDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.techhub.business.service.LocationService#findLocationByCode(java.lang
     * .String)
     */
    @Override
    public LocationDto findLocationByCode(final String code) {

        // Fetch location record for the given code.
        final Location location = this.getLocationDAO().findLocationByCode(code);

        // If location exists then map entity information to LocationDto.
        if (location != null) {
            return this.getObjectMapper().map(location, LocationDto.class);
        }
        return null;
    }

    /**
     * Getter for locationDAO.
     *
     * @return the locationDAO
     */
    public final LocationDAO getLocationDAO() {
        return locationDAO;
    }

    /**
     * Setter for locationDAO.
     *
     * @param locationDAO
     *            the locationDAO to set
     */
    public final void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    /**
     * Getter for objectMapper.
     *
     * @return the objectMapper
     */
    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Setter for objectMapper.
     *
     * @param objectMapper
     *            the objectMapper to set
     */
    public final void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
