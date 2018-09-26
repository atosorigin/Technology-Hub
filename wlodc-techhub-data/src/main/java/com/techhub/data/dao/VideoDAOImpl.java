/*
 * Copyright (C) 2018 Worldline ODC.
 */
package com.techhub.data.dao;

import org.springframework.stereotype.Repository;

import com.techhub.data.entity.Video;

/**
 * Video DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class VideoDAOImpl extends AbstractJpaDAO<Video> implements VideoDAO {

    /**
     * Default constructor.
     */
    public VideoDAOImpl() {
        this.setClazz(Video.class);
    }
}
