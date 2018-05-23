package com.tsystems.javaschool.brajnikov.internetstore.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * The Abstract generic dao with common methods for all DAO classes.
 *
 * @param <T>  generic parameter to Entity class
 * @param <PK> generic parameter to primary key of Entity class
 */
public abstract class AbstractGenericDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private final Class<T> entityClass;

    /**
     * Instantiates a new Abstract generic dao.
     */
    @SuppressWarnings("unchecked")
    public AbstractGenericDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets session.
     *
     * @return the session
     */
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public PK create(T newInstance) {
        return (PK)getSession().save(newInstance);
    }

    public T read(PK id) {
        return getSession().get(this.entityClass, id);
    }

    public void update(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    /**
     * Create entity criteria criteria.
     *
     * @return the criteria
     */
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(entityClass);
    }

    @SuppressWarnings("unchecked")
    public List<T> getList() {
        return getSession().createCriteria(this.entityClass).list();
    }
}
