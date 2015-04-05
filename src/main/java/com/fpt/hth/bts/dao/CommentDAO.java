package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dinhquangtrung on 4/5/15.
 */
public class CommentDAO extends GenericDaoJpaImpl<Comment, Integer> {
    public List getAllByIssue(int issueId) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT c FROM Comment c WHERE " +
                "c.issueId = :issueId ORDER BY c.createdDate");
        query.setParameter("issueId", issueId);
        return query.getResultList();
    }
}
