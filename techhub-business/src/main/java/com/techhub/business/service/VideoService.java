/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.business.service;

import java.util.List;

import com.techhub.common.dto.VideoDto;

/**
 * Poster Service.
 * 
 * @author a120065
 */
public interface VideoService {

    /**
     * Method to find all videos.
     * 
     * @return List of <code>net.atos.wl.odc.techhub.common.dto.VideoDto</code>.
     */
    List<VideoDto> findAllVideos();
}
