package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.Corporate;

public interface CorporateInfoDao extends AggregateDataAccess<Corporate> {

	void saveCorporateEntity( Corporate entity );
	
	void deleteCorporateEntity( Corporate entity );
	
	Corporate findCorporateInfoByRefId( String refId );
	
		
}
