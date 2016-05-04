package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class DefaultGenericDao<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    @SuppressWarnings("unchecked")
    public DefaultGenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void create(T t) {
        entityManager.merge(t);
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(type, id);
    }

    @Override
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(Long id) {
        T t = entityManager.find(type, id);
        entityManager.remove(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM " + type.getSimpleName() + " e");
        List<T> objects = new ArrayList<T>();
        objects.addAll(query.getResultList());
        return objects;
    }
}
