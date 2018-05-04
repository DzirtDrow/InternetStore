package com.tsystems.javaschool.brajnikov.internetstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractGenericDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractGenericDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }


    public PK create(T newInstance) {
        return (PK)getSession().save(newInstance);
    }

    public T read(PK id) {
        return (T) getSession().get(this.entityClass, id);
    }

    public void update(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> getList() {
        return getSession().createCriteria(this.entityClass).list();
    }
}
