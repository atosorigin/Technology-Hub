package com.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techhub.business.mapper.ObjectMapper;
import com.techhub.common.dto.PresenterDto;
import com.techhub.data.dao.PresenterDAO;
import com.techhub.data.entity.Presenter;

/**
 * Presenter Service Implementation.
 */
@Service
@Transactional
public class PresenterServiceImpl implements PresenterService {

    /**
     * Presenter DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private PresenterDAO presenterDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.PresenterService#create(net.atos
     * .wl.odc.techhub.common.dto.PresenterDto)
     */
    @Override
    public PresenterDto create(final PresenterDto presenterDto) {

        // First map all information passed from PresenterDto to Presenter
        // entity.
        final Presenter presenter = this.getObjectMapper().map(presenterDto, Presenter.class);

        // Invoke DAO to persist the presenter data.
        this.getPresenterDAO().create(presenter);

        // Finally reverse map entity information to the PresenterDto.
        return this.getObjectMapper().map(presenter, PresenterDto.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.PresenterService#read(java.lang.
     * Integer)
     */
    @Override
    public PresenterDto read(final Integer id) {

        // Fetch presenter record for the given Id.
        final Presenter presenter = this.getPresenterDAO().read(id);

        // If presenter exists then map entity information to PresenterDto.
        if (presenter != null) {
            return this.getObjectMapper().map(presenter, PresenterDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.PresenterService#update(net.atos
     * .wl.odc.techhub.common.dto.PresenterDto)
     */
    @Override
    public void update(final PresenterDto presenterDto) {

        // Fetch presenter record for the given Id.
        final Presenter presenterFromDb = this.getPresenterDAO().read(presenterDto.getId());

        // Map updated information from PresenterDto to presenter entity.
        this.getObjectMapper().map(presenterDto, presenterFromDb);

        // Finally invoke DAO to update details.
        this.getPresenterDAO().update(presenterFromDb);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.PresenterService#delete(java.
     * lang.Integer)
     */
    @Override
    public void delete(Integer id) {
        this.getPresenterDAO().deleteById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.PresenterService#
     * findPresenterByUserId(java.lang.String)
     */
    @Override
    public PresenterDto findPresenterByUserId(final String userId) {

        // Fetch presenter record for the given Id.
        final Presenter presenter = this.getPresenterDAO().findPresenterByUserId(userId);

        // If presenter exists then map entity information to PresenterDto.
        if (presenter != null) {
            return this.getObjectMapper().map(presenter, PresenterDto.class);
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.PresenterService#
     * findAllPresenters()
     */
    @Override
    public List<PresenterDto> findAllPresenters() {
        // First fetch all presenters by invoking DAO.
        final List<Presenter> presenters = this.getPresenterDAO().findAll();

        // If presenters are found them iterate through the list and map all
        // entities to PresenterDto.
        if (presenters != null && !presenters.isEmpty()) {
            final List<PresenterDto> presenterDtos = new ArrayList<>();
            for (final Presenter presenter : presenters) {
                presenterDtos.add(this.getObjectMapper().map(presenter, PresenterDto.class));
            }

            return presenterDtos;
        }

        return new ArrayList<PresenterDto>();
    }

    /**
     * Getter for presenterDAO.
     *
     * @return the presenterDAO
     */
    public final PresenterDAO getPresenterDAO() {
        return presenterDAO;
    }

    /**
     * Setter for presenterDAO.
     *
     * @param presenterDAO
     *            the presenterDAO to set
     */
    public final void setPresenterDAO(PresenterDAO presenterDAO) {
        this.presenterDAO = presenterDAO;
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
