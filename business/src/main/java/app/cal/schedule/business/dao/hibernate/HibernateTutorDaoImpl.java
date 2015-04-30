package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.Tutor;

@Repository
@Transactional
public class HibernateTutorDaoImpl extends AggregateBaseDao<Tutor> implements
		TutorDao {

	public HibernateTutorDaoImpl() {}
	
	public HibernateTutorDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveTutorEntity(Tutor entity) {
		saveNew(entity);
	}

	@Override
	public void deleteTutor(Tutor entity) {
		delete(entity);
	}

	@Override
	public Tutor findTutorEntityByRefId(String refId) {
		final String HQL = " SELECT T FROM Tutor T where refId=:refId";
		final Query query = getSession().createQuery(HQL).setParameter("refId", refId);
		final Tutor tutor = executeQuery(query, "Tutor");
		return tutor;
	}

}
