package app.cal.schedule.business.dao.hibernate;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.BaseEntity;

@Repository
@Transactional
public class BaseDao<T extends BaseEntity> implements DataAccess<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BaseDao(){}

	public BaseDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id, Class<T> returnType) {
		return (T) getSession().get(returnType, id);
	}

	protected T executeQuery( Query query, String entityName ){
		try {
			return (T) query.uniqueResult();
		} catch (Exception e) {
			throw new EntityNotFoundException(entityName);
		}
	}
	
	@Override
	public void update(T entity) {
		entity.auditChange();
		getSession().update(entity);		
	}

	@Override
	public void saveNew(T entity) {
		entity.auditChange();
		getSession().persist(entity);		
	}

	@Override
	public void delete(T entity) {
		entity.auditChange();
		getSession().delete(entity);		
	}

	@Override
	public void flush() {
		try {
			getSession().flush();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			throw new RuntimeException(" Optimistic locking error ");
		}
	}

	@Override
	public void clear() {
		getSession().clear();
	}

}
