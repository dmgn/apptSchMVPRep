package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.ClientEnrollment;

@Repository
@Transactional
public class HibernateClientEnrollmentImpl extends AggregateBaseDao<ClientEnrollment>
		implements ClientEnrollmentDao {

	public HibernateClientEnrollmentImpl() {}
	
	public HibernateClientEnrollmentImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveClientEnrollmentEntity(ClientEnrollment entity) {
		saveNew(entity);
	}

	@Override
	public void deleteClientEnrollmentEntity(ClientEnrollment entity) {
		delete(entity);
	}

	@Override
	public ClientEnrollment findClientEnrollmentByRefId(String refId) {
		final String hql = "SELECT C FROM ClientEnrollment C WHERE C.refId=:refId";
		final Query query = getSession().createQuery(hql).setParameter("refId", refId);
		final ClientEnrollment ce = executeQuery(query, "ClientEnrollment");
		return ce;		
	}
}
