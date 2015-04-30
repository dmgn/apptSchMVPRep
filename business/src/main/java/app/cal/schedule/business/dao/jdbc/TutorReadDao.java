package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;
import app.cal.schedule.api.TutorScheduleResponseDtls;

public interface TutorReadDao {

	ListMessage<TutorDetails> findAllTutorsFor( long corpId );
	
	TutorDetails findTutorByRefId( String refId );
	
	ListMessage<TutorScheduleResponseDtls> findTutorSchedule ( long tutorId, long productId, long locationId );

}
