/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import net.atos.wl.odc.techhub.data.entity.User;

/**
 * User DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class UserDAOImpl extends AbstractJpaDAO<User> implements UserDAO {

    /**
     * Default constructor.
     */
    public UserDAOImpl() {
        this.setClazz(User.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.data.dao.UserDAO#findUserByUserId(java.lang.
     * String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public User findUserByUserId(final String userId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.User.fetchUserByUserId");
        query.setParameter("userId", userId);
        final List<User> users = (List<User>) query.getResultList();
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }
        return null;
    }
}
