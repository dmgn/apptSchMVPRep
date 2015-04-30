package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.cal.schedule.business.entity.Package;


@Repository
@Transactional
public class HibernatePackageDaoImpl extends AggregateBaseDao<Package> implements PackageDao {

	public HibernatePackageDaoImpl() {
	}
	
	public HibernatePackageDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void savePackageEntity(Package pkg) {
		saveNew(pkg);
	}

	@Override
	public void deletePackageEntityByRefId(Package pkg) {
		delete(pkg);
	}

	@Override
	public Package findEntityByRefId(String refId) {
		final String hql = "SELECT P FROM Package P WHERE P.refId=:refId";
		final Query query = getSession().createQuery(hql).setParameter("refId", refId);
		final Package pkg = executeQuery(query, "Package");
		return pkg;
	}

	


}
