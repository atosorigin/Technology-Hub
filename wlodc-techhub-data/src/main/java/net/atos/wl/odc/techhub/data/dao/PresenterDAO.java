/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import net.atos.wl.odc.techhub.data.entity.Presenter;

/**
 * Presenter DAO.
 * 
 * @author a120065
 */
public interface PresenterDAO extends GenericDAO<Presenter> {

    /**
     * Method to fetch the presenter details by given user Id.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    Presenter findPresenterByUserId(final String userId);
}
