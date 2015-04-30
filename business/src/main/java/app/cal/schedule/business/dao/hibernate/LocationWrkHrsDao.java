package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.LocationWorkHours;

public interface LocationWrkHrsDao extends AggregateDataAccess<LocationWorkHours>{

	void saveLocationWorkHoursEntity( LocationWorkHours entity );
	
	void deleteLocationWorkHoursEntity( LocationWorkHours entity );
	
	LocationWorkHours findLocationWorkHoursByRefId( long timeSlotId );
	
}
