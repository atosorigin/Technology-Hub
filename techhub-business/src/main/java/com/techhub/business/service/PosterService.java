package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.PosterDto;

/**
 * Poster Service.
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
