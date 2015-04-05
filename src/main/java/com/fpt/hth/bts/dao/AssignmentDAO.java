package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.Assignment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by dinhquangtrung on 4/5/15.
 */
public class AssignmentDAO extends GenericDaoJpaImpl<Assignment, Integer> {
    public Assignment getLatestAssignment(int issueId) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT a FROM Assignment a " +
                "WHERE a.issueId = :issueId ORDER BY a.assignDate DESC");
        query.setParameter("issueId", issueId);
        try {
            return (Assignment) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
