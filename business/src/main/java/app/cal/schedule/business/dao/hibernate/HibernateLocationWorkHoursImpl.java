package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.LocationWorkHours;


@Repository
@Transactional
public class HibernateLocationWorkHoursImpl extends AggregateBaseDao<LocationWorkHours>
		implements LocationWrkHrsDao {

	public HibernateLocationWorkHoursImpl() {}
	
	public HibernateLocationWorkHoursImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveLocationWorkHoursEntity(LocationWorkHours entity) {
		saveNew(entity);
	}

	@Override
	public void deleteLocationWorkHoursEntity(LocationWorkHours entity) {
		delete(entity);
	}

	@Override
	public LocationWorkHours findLocationWorkHoursByRefId(long timeSlotId) {
		final String hql = "SELECT L FROM LocationWorkHours L WHERE L.timeSlotId=:timeSlotId";
		final Query query = getSession().createQuery(hql).setParameter("timeSlotId", timeSlotId);
		final LocationWorkHours lwh = executeQuery(query, "LocationWorkHours");
		return lwh;
	}
}
