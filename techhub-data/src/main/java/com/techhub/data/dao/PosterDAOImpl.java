package com.techhub.data.dao;

import org.springframework.stereotype.Repository;

import com.techhub.data.entity.Poster;

/**
 * Poster DAO Implementation.
 */
@Repository
public class PosterDAOImpl extends AbstractJpaDAO<Poster> implements PosterDAO {

    /**
     * Default constructor.
     */
    public PosterDAOImpl() {
        this.setClazz(Poster.class);
    }
}
