/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.business.mapper.ObjectMapper;
import net.atos.wl.odc.techhub.common.dto.VideoDto;
import net.atos.wl.odc.techhub.data.dao.VideoDAO;
import net.atos.wl.odc.techhub.data.entity.Video;

/**
 * Video Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    /**
     * Poster DAO instance that will be initialized by spring using constructor
     * injection.
     */
    @Autowired
    private VideoDAO videoDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.VideoService#findAllVideos()
     */
    @Override
    public List<VideoDto> findAllVideos() {
        // First fetch all videos by invoking DAO.
        final List<Video> videos = this.getVideoDAO().findAll();

        // If questions are found them iterate through the list and map all
        // entities to VideoDto.
        if (CollectionUtils.isNotEmpty(videos)) {
            final List<VideoDto> videoDtos = new ArrayList<VideoDto>();
            for (final Video video : videos) {
                videoDtos.add(this.objectMapper.map(video, VideoDto.class));
            }

            return videoDtos;
        }

        return new ArrayList<VideoDto>();
    }

    /**
     * Getter for videoDAO.
     *
     * @return the videoDAO
     */
    public final VideoDAO getVideoDAO() {
        return videoDAO;
    }

    /**
     * Setter for videoDAO.
     *
     * @param videoDAO
     *            the videoDAO to set
     */
    public final void setVideoDAO(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
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
