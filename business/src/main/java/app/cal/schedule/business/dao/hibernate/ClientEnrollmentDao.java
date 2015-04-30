package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.ClientEnrollment;

public interface ClientEnrollmentDao extends AggregateDataAccess<ClientEnrollment> {

	void saveClientEnrollmentEntity( ClientEnrollment entity );
	
	void deleteClientEnrollmentEntity( ClientEnrollment entity );
	
	ClientEnrollment findClientEnrollmentByRefId( String refId );
	
	
}
