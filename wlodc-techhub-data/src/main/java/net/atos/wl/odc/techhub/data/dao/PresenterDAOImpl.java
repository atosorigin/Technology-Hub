/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import org.springframework.stereotype.Repository;

import net.atos.wl.odc.techhub.data.entity.Presenter;

/**
 * Presenter DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class PresenterDAOImpl extends AbstractJpaDAO<Presenter> implements PresenterDAO {

    /**
     * Default constructor.
     */
    public PresenterDAOImpl() {
        this.setClazz(Presenter.class);
    }
}
