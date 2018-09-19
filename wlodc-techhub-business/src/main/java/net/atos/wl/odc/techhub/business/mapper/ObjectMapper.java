/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.odc.techhub.business.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.atos.wl.odc.techhub.common.dto.PresenterDto;
import net.atos.wl.odc.techhub.data.entity.Presenter;

/**
 * Dozer object mapper for mapping DTO to entity and vice versa.
 * 
 * @author a120065
 */
@Component
public class ObjectMapper {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    /**
     * Method to map PresenterDto to Presenter entity.
     * 
     * @param presenterDto
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     */
    public Presenter mapPresenterDtoToEntity(final PresenterDto presenterDto) {
        return this.dozerBeanMapper.map(presenterDto, Presenter.class);
    }

    /**
     * Method to map Presenter entity to PresenterDto.
     * 
     * @param presenter
     *            <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     * @return <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>.
     */
    public PresenterDto mapPresenterEntityToDto(final Presenter presenter) {
        return this.dozerBeanMapper.map(presenter, PresenterDto.class);
    }

    /**
     * Method to map information from PresenterDto to Presenter entity fetched
     * from DB.
     * 
     * @param presenterDto
     *            <code>net.atos.wl.odc.techhub.common.dto.PresenterDto</code>
     * @param presenterFromDb
     *            <code>net.atos.wl.odc.techhub.data.entity.Presenter</code>.
     */
    public void map(final PresenterDto presenterDto, final Presenter presenterFromDb) {
        this.dozerBeanMapper.map(presenterDto, presenterFromDb);
    }
}
