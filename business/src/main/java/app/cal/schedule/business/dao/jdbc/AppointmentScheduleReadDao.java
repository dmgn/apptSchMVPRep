package app.cal.schedule.business.dao.jdbc;

import java.util.Date;
import java.util.List;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.ListMessage;

public interface AppointmentScheduleReadDao {

	List<AppointmentResponseDtls> bookAppointments(  long prodId, Date startDt, Date endDt, long locId, long timeSlotId, String selectedDays,
			long clientId, long groupId);
	
	ListMessage<AppointmentResponseDtls> findScheduleStatus( String emailId, long clientId, long groupId);
}
