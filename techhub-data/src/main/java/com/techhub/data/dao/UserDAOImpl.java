package com.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.techhub.data.entity.User;
import com.techhub.data.entity.WhiteListUser;

/**
 * User DAO Implementation.
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

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.data.dao.UserDAO#findUsersByTopic(java.lang.
     * Integer)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> findUsersByTopic(final Integer topicId) {
        final Query query = this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.User.fetchUsersByTopic");
        query.setParameter("topicId", topicId);
        return query.getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.UserDAO#findWhiteListUserByUserId(java.
     * lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public WhiteListUser findWhiteListUserByUserId(String userId) {
        final Query query =
                        this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.WhiteListUser.fetchUserByUserId");
        query.setParameter("userId", userId);
        final List<WhiteListUser> users = (List<WhiteListUser>) query.getResultList();
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }
        return null;
    }
}
