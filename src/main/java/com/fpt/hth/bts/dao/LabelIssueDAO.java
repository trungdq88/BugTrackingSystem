package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.LabelIssue;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dinhquangtrung on 4/6/15.
 */
public class LabelIssueDAO extends GenericDaoJpaImpl<LabelIssue, Integer> {
    public List getAllByIssueId(int issueId) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT li FROM LabelIssue li WHERE li.issueId = :issueId");
        query.setParameter("issueId", issueId);
        return query.getResultList();
    }
}
