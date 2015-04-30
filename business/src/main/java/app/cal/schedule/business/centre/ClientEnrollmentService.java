package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientEnrollmentDetails;

public interface ClientEnrollmentService {
	
	BaseMessage addClientEnrollmentInfo( ClientEnrollmentDetails cInfoDtls );
	
	BaseMessage deleteClientEnrollmentByRefId ( String refId );
	
	BaseMessage updateClientEnrollment( ClientEnrollmentDetails cInfoDtls );
	
	ClientEnrollmentDetails findClientEnrollment( String refId );
}
