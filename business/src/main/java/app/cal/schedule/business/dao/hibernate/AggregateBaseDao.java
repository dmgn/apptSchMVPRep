package app.cal.schedule.business.dao.hibernate;

import org.hibernate.SessionFactory;

import app.cal.schedule.business.entity.AggregateRoot;

public class AggregateBaseDao<T extends AggregateRoot> extends BaseDao<T> implements
		AggregateDataAccess<T> {

	Object eventStore;
	
	public AggregateBaseDao(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory);
		this.eventStore = eventStore;
	}

	public AggregateBaseDao(){}
}
