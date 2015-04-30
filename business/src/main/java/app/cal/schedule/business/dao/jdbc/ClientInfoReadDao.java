package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.api.ListMessage;

public interface ClientInfoReadDao {

	ListMessage<ClientInfoDetails> findAllClientsFor( long corpId );
	
	ClientInfoDetails findClientByRefId( String refId );
	
	ClientInfoDetails findClientByEmailId ( String emailId );
}
