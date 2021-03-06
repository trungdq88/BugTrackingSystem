/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.hth.bts.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author http://stackoverflow.com/a/3889814/1420186
 * @param <T>
 * @param <PK>
 */
public class GenericDaoJpaImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    protected Class<T> entityClass;

    EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("com.fpt.hth_BTS_war_1.0-SNAPSHOTPU");

    public GenericDaoJpaImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
        manager.close();
        return t;
    }

    @Override
    public T read(PK id) {
        EntityManager manager = factory.createEntityManager();
        return manager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        T result = manager.merge(t);
        manager.getTransaction().commit();
        manager.close();
        return result;
    }

    @Override
    public void delete(T t) {
        EntityManager manager = factory.createEntityManager();
        t = manager.merge(t);
        manager.remove(t);
        manager.close();
    }
}
