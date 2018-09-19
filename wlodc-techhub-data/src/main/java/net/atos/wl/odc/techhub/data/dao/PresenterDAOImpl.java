/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import javax.persistence.Query;

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

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.PresenterDAO#findPresenterByUserId(java.
     * lang.String)
     */
    @Override
    public Presenter findPresenterByUserId(final String userId) {
        final Query query = this.entityManager
                        .createNamedQuery("net.atos.wl.odc.techhub.data.entity.Presenter.fetchPresenterByUserId");
        query.setParameter("userId", userId);
        return (Presenter) query.getSingleResult();
    }
}
