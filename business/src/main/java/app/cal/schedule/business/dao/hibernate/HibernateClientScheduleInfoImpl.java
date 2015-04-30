package app.cal.schedule.business.dao.hibernate;

import org.hibernate.SessionFactory;

import app.cal.schedule.business.entity.ClientScheduleInfo;

public class HibernateClientScheduleInfoImpl extends AggregateBaseDao<ClientScheduleInfo> implements ClientScheduleInfoDao {

	public HibernateClientScheduleInfoImpl(){
		
	}
	
	public HibernateClientScheduleInfoImpl(SessionFactory sessionFactory, Object eventStore) {
		super(sessionFactory, eventStore);
	}
	
	@Override
	public void saveClientScheduleInfoEntity(ClientScheduleInfo clientSchdInfo) {
		saveNew(clientSchdInfo);			
	}

}
