package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.cal.schedule.business.entity.ClientSvcPkgInfo;

@Repository
@Transactional
public class HibernateClientSvcPkgInfoImpl extends AggregateBaseDao<ClientSvcPkgInfo> implements ClientSvcPkgDao {

	
	public HibernateClientSvcPkgInfoImpl() {}
	
	public HibernateClientSvcPkgInfoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveCSPIEntity(ClientSvcPkgInfo cspi) {
		saveNew(cspi);
	}

	@Override
	public void deleteCSPIEntityByRefId(ClientSvcPkgInfo cspi) {
		delete(cspi);
	}

	@Override
	public ClientSvcPkgInfo findEntityByRefId(String refId) {
		final String hql = "SELECT C FROM ClientSvcPkgInfo C WHERE C.refId=:refId";
		final Query query = getSession().createQuery(hql).setParameter("refId", refId);
		final ClientSvcPkgInfo cspi = executeQuery(query, "ClientSvcPkgInfo");
		return cspi;
	}
	
	
	
	
}
