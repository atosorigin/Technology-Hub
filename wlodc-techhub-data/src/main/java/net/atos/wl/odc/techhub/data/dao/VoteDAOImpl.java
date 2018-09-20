/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import net.atos.wl.odc.techhub.common.dto.VoteDto;
import net.atos.wl.odc.techhub.data.entity.Topic;
import net.atos.wl.odc.techhub.data.entity.User;
import net.atos.wl.odc.techhub.data.entity.Vote;

/**
 * Vote DAO Implementation.
 * 
 * @author a120065
 */
@Repository
public class VoteDAOImpl extends AbstractJpaDAO<Vote> implements VoteDAO {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TopicDAO topicDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.VoteDAO#postUserVote(net.atos.wl.odc.
     * techhub.common.dto.VoteDto)
     */
    @Override
    public void postUserVote(final VoteDto voteDto) {

        // First get the user details for which vote is to be marked.
        final User user = this.getUserDAO().findUserByUserId(voteDto.getUserId());

        // Then get the topic record based on the id.
        final Topic topic = this.getTopicDAO().read(voteDto.getTopicId());

        // Create the vote instance and persist the same.
        final Vote vote = this.getVoteByUser(voteDto.getUserId());
        vote.setVoteType(voteDto.getVoteType());
        vote.setUser(user);
        vote.setTopic(topic);

        this.persistOrMerge(vote);
    }

    /**
     * Method to fetch the vote record based on the user id and topic id.
     * 
     * @param userId
     *            String.
     * @return <code>net.atos.wl.odc.techhub.data.entity.Vote</code>.
     */
    @SuppressWarnings("unchecked")
    private Vote getVoteByUser(final String userId) {
        final Query query =
                        this.entityManager.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Vote.fetchVoteByUser");
        query.setParameter("userId", userId);
        final List<Vote> votes = (List<Vote>) query.getResultList();
        if (!CollectionUtils.isEmpty(votes)) {
            return votes.get(0);
        }
        return new Vote();
    }

    /**
     * Getter for userDAO.
     *
     * @return the userDAO
     */
    public final UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Setter for userDAO.
     *
     * @param userDAO
     *            the userDAO to set
     */
    public final void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Getter for topicDAO.
     *
     * @return the topicDAO
     */
    public final TopicDAO getTopicDAO() {
        return topicDAO;
    }

    /**
     * Setter for topicDAO.
     *
     * @param topicDAO
     *            the topicDAO to set
     */
    public final void setTopicDAO(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

}
