package app.cal.schedule.business.dao.hibernate;

public interface DataAccess<T> {

	T findById(Long id, Class<T> returnType);
	
	void update(T entity);
	
	void saveNew(T entity);
	
	void delete(T entity);
	
	void flush();
	
	void clear();
}
