package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.ClientGroup;

@Repository
@Transactional
public class HibernateClientGrpDaoImpl extends AggregateBaseDao<ClientGroup> implements ClientGrpDao{

	public HibernateClientGrpDaoImpl() {}
	
	public HibernateClientGrpDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveClientGrpEntity(ClientGroup entity) {
		saveNew(entity);
	}

	@Override
	public void deleteClientGrpEntity(ClientGroup entity) {
		delete(entity);
	}

	@Override
	public ClientGroup findClientGrpByRefId(String refId) {
		final String hql = "SELECT C FROM ClientGroup C WHERE C.refId=:refId";
		final Query query = getSession().createQuery(hql).setParameter("refId", refId);
		final ClientGroup cg = executeQuery(query, "ClientGroup");
		return cg;
	}

}
