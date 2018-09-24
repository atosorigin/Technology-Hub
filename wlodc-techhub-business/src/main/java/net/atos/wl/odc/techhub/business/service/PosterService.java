/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.List;

import net.atos.wl.odc.techhub.common.dto.PosterDto;

/**
 * Poster Service.
 * 
 * @author a120065
 */
public interface PosterService {

    /**
     * Method to find all posters.
     * 
     * @return List of
     *         <code>net.atos.wl.odc.techhub.common.dto.PosterDto</code>.
     */
    List<PosterDto> findAllPosters();
}
