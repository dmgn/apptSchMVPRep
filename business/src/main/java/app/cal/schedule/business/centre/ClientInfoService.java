package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.api.ListMessage;

public interface ClientInfoService {

	BaseMessage addClientInfo( ClientGroupDetails cInfoDtls );
	
	BaseMessage deleteClientInfoByRefId ( String refId );
	
	BaseMessage updateClientInfo( ClientGroupDetails cInfoDtls );
	
	ClientInfoDetails findClientInfo ( String refId );
	
	ListMessage<ClientInfoDetails> findAllClientsFor( long corpId );
	
	ClientInfoDetails findClientByEmailId ( String emailId );
}
