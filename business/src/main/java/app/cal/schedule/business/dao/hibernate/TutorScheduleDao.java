package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.TutorSchedule;

public interface TutorScheduleDao extends AggregateDataAccess<TutorSchedule> {

	void saveTutorScheduleEntity(TutorSchedule entity);
	
	void deleteTutorSchedule(TutorSchedule entity);
	
	TutorSchedule findTutorScheduleEntityByRefId( String refId );
	
	TutorSchedule findTutorScheduleByTSId( long tutorScheduleId );
}
