package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.LocationWrkHrsDtls;

public interface LocationWorkHoursReadDao {

	ListMessage<LocationWrkHrsDtls> findLocationWorkHours ( long corpId, long locId);
	
	ListMessage<LocationWrkHrsDtls> findWorkHoursForAllLocations (long corpId);
	
	ListMessage<CorpLocDetails> findAllLocations (long corpId);

	
}
