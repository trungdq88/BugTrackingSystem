package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.Label;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dinhquangtrung on 4/6/15.
 */
public class LabelDAO extends GenericDaoJpaImpl<Label, Integer>{
    public List getAllByProject(int projectId) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT l FROM Label l WHERE l.projectId = :projectId");
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }
}
