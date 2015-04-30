package app.cal.schedule.business.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.cal.schedule.business.entity.Corporate;

@Repository
@Transactional
public class HibernateCorpDaoImpl extends AggregateBaseDao<Corporate> implements CorporateInfoDao {

	public HibernateCorpDaoImpl(){}
	
	public HibernateCorpDaoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveCorporateEntity( Corporate entity ) {
		saveNew(entity);
	}

	@Override
	public void deleteCorporateEntity( Corporate entity ) {
		delete(entity);
	}

	@Override
	public Corporate findCorporateInfoByRefId(String refId) {
		final String HQL = "SELECT C FROM Corporate C where refId=:refId";
		final Query query = getSession().createQuery(HQL).setParameter("refId", refId);
		final Corporate corporate = executeQuery( query,  "Corporate");
		return corporate;
	}

	
}
