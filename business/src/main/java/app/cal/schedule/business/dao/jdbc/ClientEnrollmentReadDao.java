package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ClientEnrollmentDetails;
import app.cal.schedule.api.ListMessage;

public interface ClientEnrollmentReadDao {

	ListMessage<ClientEnrollmentDetails> findAllEnrollmentsFor( long clientId );
	
	ClientEnrollmentDetails findEnrollmentByRefId( String refId );
		
}
