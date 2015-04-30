package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.Tutor;

public interface TutorDao extends AggregateDataAccess<Tutor> {

	void saveTutorEntity(Tutor entity);
	
	void deleteTutor(Tutor entity);
	
	Tutor findTutorEntityByRefId( String refId );
}
