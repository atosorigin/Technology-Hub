package com.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.techhub.data.entity.Presenter;

/**
 * Presenter DAO Implementation.
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
    @SuppressWarnings("unchecked")
    public Presenter findPresenterByUserId(final String userId) {
        final Query query = this.entityManager
                        .createNamedQuery("net.atos.wl.odc.techhub.data.entity.Presenter.fetchPresenterByUserId");
        query.setParameter("userId", userId);
        final List<Presenter> presenters = (List<Presenter>) query.getResultList();
        if (!CollectionUtils.isEmpty(presenters)) {
            return presenters.get(0);
        }
        return null;
    }
}
