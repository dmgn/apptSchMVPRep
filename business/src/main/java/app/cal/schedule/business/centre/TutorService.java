package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;
import app.cal.schedule.api.TutorScheduleResponseDtls;

public interface TutorService {
	
	BaseMessage addTutor( TutorDetails tutorDtls);
	
	BaseMessage deleteTutorByRefId( String refId );
	
	BaseMessage updateTutor( TutorDetails tutorDtls );
	
	TutorDetails findTutorByRefId ( String refId );
	
	ListMessage<TutorDetails> findAllTutorsFor( long corpId );

	BaseMessage createTutorSchedule( TutorScheduleDetails tutSchDtls);
	
	BaseMessage updateTutorSchedule( TutorScheduleDetails tutSchDtls);

	BaseMessage deleteTutorScheduleByRefId( String refId );
	
	ListMessage<TutorScheduleResponseDtls> findTutorSchedule( long tutorId, long productId, long locationId );

}
