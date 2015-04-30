package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.AggregateRoot;

public interface AggregateDataAccess<T extends AggregateRoot> extends DataAccess<T> {

	
}
