package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ClientSvcPkgInfoDetails;

public interface ClientSvcPkgReadDao {
	
	ClientSvcPkgInfoDetails findPkgDtlsForProductByClientId( long corpId, long prodId, long clientId);


}
