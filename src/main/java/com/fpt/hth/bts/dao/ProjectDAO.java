package com.fpt.hth.bts.dao;

import com.fpt.hth.bts.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dinhquangtrung on 4/5/15.
 */
public class ProjectDAO extends GenericDaoJpaImpl<Project, Integer> {

    public List getAll() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT p FROM Project p");
        return query.getResultList();
    }

    public boolean isCodeExists(String code) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT p FROM Project p WHERE p.code = :code");
        query.setParameter("code", code);
        return query.getResultList().size() > 0;
    }
}
