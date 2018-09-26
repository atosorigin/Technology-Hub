package com.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.business.mapper.ObjectMapper;
import com.techhub.common.dto.PosterDto;
import com.techhub.data.dao.PosterDAO;
import com.techhub.data.entity.Poster;

/**
 * Poster Service Implementation.
 */
@Service
@Transactional
public class PosterServiceImpl implements PosterService {

    /**
     * Poster DAO instance that will be initialized by spring using constructor
     * injection.
     */
    @Autowired
    private PosterDAO posterDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.PosterService#findAllPosters()
     */
    @Override
    public List<PosterDto> findAllPosters() {
        // First fetch all posters by invoking DAO.
        final List<Poster> posters = this.getPosterDAO().findAll();

        // If questions are found them iterate through the list and map all
        // entities to PosterDto.
        if (CollectionUtils.isNotEmpty(posters)) {
            final List<PosterDto> posterDtos = new ArrayList<PosterDto>();
            for (final Poster poster : posters) {
                posterDtos.add(this.objectMapper.map(poster, PosterDto.class));
            }

            return posterDtos;
        }

        return new ArrayList<PosterDto>();
    }

    /**
     * Getter for posterDAO.
     *
     * @return the posterDAO
     */
    public final PosterDAO getPosterDAO() {
        return posterDAO;
    }

    /**
     * Setter for posterDAO.
     *
     * @param posterDAO
     *            the posterDAO to set
     */
    public final void setPosterDAO(PosterDAO posterDAO) {
        this.posterDAO = posterDAO;
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
