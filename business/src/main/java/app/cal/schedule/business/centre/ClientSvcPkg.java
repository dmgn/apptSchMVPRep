package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientSvcPkgInfoDetails;

public interface ClientSvcPkg  {

	BaseMessage addClientSvcPkg( ClientSvcPkgInfoDetails cspiDtls );
	
	BaseMessage deleteCSPIDtlsByRefId ( String refId );
	
	BaseMessage updateClientSvcPkg( ClientSvcPkgInfoDetails cspiDtls );

	ClientSvcPkgInfoDetails findPkgDtlsForProductByClientId( long corpId, long prodId, long clientId);
}
