/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.techhub.data.entity.Location;

/**
 * Location DAO Implementation.
 */
@Repository
public class LocationDAOImpl extends AbstractJpaDAO<Location> implements LocationDAO {

    /**
     * Default constructor.
     */
    public LocationDAOImpl() {
        this.setClazz(Location.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.techhub.data.dao.LocationDAO#findLocationByCode(java.lang.String)
     */
    @Override
    public Location findLocationByCode(final String code) {
        final Query query = this.entityManager.createNamedQuery("com.techhub.data.entity.Location.fetchLocationByCode");
        query.setParameter("code", code);
        return (Location) query.getSingleResult();
    }
}
