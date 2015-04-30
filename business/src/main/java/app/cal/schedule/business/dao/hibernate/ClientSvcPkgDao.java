package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.ClientSvcPkgInfo;

public interface ClientSvcPkgDao extends AggregateDataAccess<ClientSvcPkgInfo> {

	void saveCSPIEntity(ClientSvcPkgInfo cspi);
	
	void deleteCSPIEntityByRefId( ClientSvcPkgInfo cspi);
	
	ClientSvcPkgInfo findEntityByRefId( String refId );
}
