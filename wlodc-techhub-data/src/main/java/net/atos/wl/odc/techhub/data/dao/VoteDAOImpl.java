/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import net.atos.wl.odc.techhub.common.dto.VoteDto;
import net.atos.wl.odc.techhub.common.dto.VoteStatsDto;
import net.atos.wl.odc.techhub.common.enums.VotingType;
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

    @Autowired
    private PosterDAO posterDAO;

    @Autowired
    private VideoDAO videoDAO;

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

        // Create the vote instance and persist the same.
        final Vote vote = this.getVoteByUserAndVoteType(voteDto.getUserId(), voteDto.getVoteType());
        vote.setVoteType(voteDto.getVoteType());
        vote.setUser(user);

        if (voteDto.getTopicId() != null) {
            vote.setTopic(this.getTopicDAO().read(voteDto.getTopicId()));
        } else if (voteDto.getPosterId() != null) {
            vote.setPoster(this.getPosterDAO().read(voteDto.getPosterId()));
        } else if (voteDto.getVideoId() != null) {
            vote.setVideo(this.getVideoDAO().read(voteDto.getVideoId()));
        }

        this.persistOrMerge(vote);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.data.dao.VoteDAO#getVoteStatsByVoteType(net.atos.
     * wl.odc.techhub.common.enums.VotingType)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<VoteStatsDto> getVoteStatsByVoteType(final VotingType voteType) {

        Query query = null;
        if (voteType == VotingType.POSTER) {
            query = this.entityManager.createQuery(
                            "SELECT v.poster.id AS posterId, COUNT(v) AS totalVotes FROM Vote AS v WHERE v.voteType = :voteType GROUP BY v.poster.id");
        } else if (voteType == VotingType.TEASER) {
            query = this.entityManager.createQuery(
                            "SELECT v.topic.id AS topicId, COUNT(v) AS totalVotes FROM Vote AS v WHERE v.voteType = :voteType GROUP BY v.topic.id");
        } else if (voteType == VotingType.VIDEO) {
            query = this.entityManager.createQuery(
                            "SELECT v.video.id AS videoId, COUNT(v) AS totalVotes FROM Vote AS v WHERE v.voteType = :voteType GROUP BY v.video.id");
        }

        final List<VoteStatsDto> votesStats = new ArrayList<>();
        if (query != null) {
            query.setParameter("voteType", voteType);
            final List<Object[]> results = query.getResultList();
            for (final Object[] result : results) {
                final VoteStatsDto voteStatsDto = new VoteStatsDto();
                if (voteType == VotingType.POSTER) {
                    voteStatsDto.setPosterId((Integer) result[0]);
                } else if (voteType == VotingType.TEASER) {
                    voteStatsDto.setTopicId((Integer) result[0]);
                } else if (voteType == VotingType.VIDEO) {
                    voteStatsDto.setVideoId((Integer) result[0]);
                }
                voteStatsDto.setTotalVotes(((Number) result[1]).intValue());
                votesStats.add(voteStatsDto);
            }
        }
        return votesStats;
    }

    /**
     * Method to fetch the vote record based on the user id and topic id.
     * 
     * @param userId
     *            String.
     * @param votingType
     *            <code>net.atos.wl.odc.techhub.common.enums.VotingType</code>
     * @return <code>net.atos.wl.odc.techhub.data.entity.Vote</code>.
     */
    @SuppressWarnings("unchecked")
    private Vote getVoteByUserAndVoteType(final String userId, final VotingType votingType) {
        final Query query =
                        this.createNamedQuery("net.atos.wl.odc.techhub.data.entity.Vote.fetchVoteByUserAndVoteType");
        query.setParameter("userId", userId);
        query.setParameter("voteType", votingType);
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

    /**
     * Getter for posterDAO.
     *
     * @return the posterDAO
     */
    public final PosterDAO getPosterDAO() {
        return posterDAO;
    }

    /**
     * Setter for posterDAO.
     *
     * @param posterDAO
     *            the posterDAO to set
     */
    public final void setPosterDAO(PosterDAO posterDAO) {
        this.posterDAO = posterDAO;
    }

    /**
     * Getter for videoDAO.
     *
     * @return the videoDAO
     */
    public final VideoDAO getVideoDAO() {
        return videoDAO;
    }

    /**
     * Setter for videoDAO.
     *
     * @param videoDAO
     *            the videoDAO to set
     */
    public final void setVideoDAO(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
    }
}
