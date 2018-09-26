package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.PresenterDto;

/**
 * Presenter Service.
 */
public interface PresenterService {

    /**
     * Method create a new presenter record in DB.
     * 
     * @param presenter
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code> .
     * @return <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    PresenterDto create(final PresenterDto presenter);

    /**
     * Method to fetch presenter details for the given presenter Id.
     * 
     * @param id
     *            Integer.
     * @return <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    PresenterDto read(final Integer id);

    /**
     * Method to update presenter details.
     * 
     * @param presenter
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code> .
     */
    void update(final PresenterDto presenter);

    /**
     * Method to delete the given presenter record from DB.
     * 
     * @param id
     *            Integer.
     */
    void delete(final Integer id);

    /**
     * Method to find a particular presenter for the given userId.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    PresenterDto findPresenterByUserId(final String userId);

    /**
     * Method to find all presenters.
     * 
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    List<PresenterDto> findAllPresenters();

}
