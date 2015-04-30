package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import app.cal.schedule.business.entity.TutorSchedule;

public class HibernateTutorScheduleDaoImpl extends AggregateBaseDao<TutorSchedule>
		implements TutorScheduleDao {
	
	public HibernateTutorScheduleDaoImpl() {}

	public HibernateTutorScheduleDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}

	@Override
	public void saveTutorScheduleEntity(TutorSchedule entity) {
		saveNew(entity);
	}

	@Override
	public void deleteTutorSchedule(TutorSchedule entity) {
		delete(entity);
	}

	@Override
	public TutorSchedule findTutorScheduleEntityByRefId(String refId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TutorSchedule findTutorScheduleByTSId(long tutorScheduleId) {
		final String hql = "SELECT T FROM TutorSchedule T WHERE T.id=:tutorScheduleId";
		final Query query = getSession().createQuery(hql).setParameter("tutorScheduleId", tutorScheduleId);
		final TutorSchedule tutorSchedule = executeQuery(query, "TutorSchedule");
		return tutorSchedule;
	}

	/*@Override
	public Tutor findTutorByTutorId(long tutorId) {
		final String hql = "SELECT T FROM TutorSchedule T WHERE T.tutorId=:tutorId";
		final Query query = getSession().createQuery(hql).setParameter("tutorId", tutorId);
		final Tutor tutor = executeQuery(query, "TutorSchedule");
		return tutor;
	}*/
	
	
	

}
