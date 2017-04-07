package com.gamaset.sonicbot.collector.repository.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaQuery;

public class JpaGenericDao<T, ID extends Serializable> implements Dao<T, ID> {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager = null;

	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	public void delete(T entity) {
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
	}
	
	public T detachedToPersist(T entity) {
		return entityManager.merge(entity);
	}
	
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public T findById(ID primaryKey) {
		return entityManager.find(getGenericClass(), primaryKey);
	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
