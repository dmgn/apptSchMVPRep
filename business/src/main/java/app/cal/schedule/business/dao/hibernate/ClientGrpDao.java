package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.ClientGroup;

public interface ClientGrpDao extends AggregateDataAccess<ClientGroup> {


	void saveClientGrpEntity( ClientGroup entity );
	
	void deleteClientGrpEntity( ClientGroup entity );
	
	ClientGroup findClientGrpByRefId( String refId );
}
