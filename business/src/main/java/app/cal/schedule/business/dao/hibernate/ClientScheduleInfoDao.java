package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.ClientScheduleInfo;

public interface ClientScheduleInfoDao extends
		AggregateDataAccess<ClientScheduleInfo> {

	void saveClientScheduleInfoEntity( ClientScheduleInfo clientSchdinfo );
}
