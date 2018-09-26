package com.techhub.data.dao;

import com.techhub.data.entity.Presenter;

/**
 * Presenter DAO.
 */
public interface PresenterDAO extends GenericDAO<Presenter> {

    /**
     * Method to fetch the presenter details by given user Id.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     */
    Presenter findPresenterByUserId(final String userId);
}
