/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.Issue;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author dinhquangtrung
 */
public class IssueDAO extends GenericDaoJpaImpl<Issue, Integer>{

    public List getAllByProject(int projectId, boolean openOnly) {
        int status = openOnly ? 0 : 1;
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT i FROM Issue i " +
                "WHERE i.projectId = :projectId " +
                "AND i.status = :status ORDER BY i.createDate DESC");
        query.setParameter("projectId", projectId);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
