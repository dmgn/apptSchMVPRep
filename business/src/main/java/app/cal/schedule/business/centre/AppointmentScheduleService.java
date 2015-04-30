package app.cal.schedule.business.centre;

import java.util.Date;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.AppointmentScheduleDetails;
import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;

public interface AppointmentScheduleService {

	// The return type has to change for some of the below operations
		void fetchWeeklyScheduledAppointments();
		
		void fetchAvailableTimeSlotsByWeek( Date startDate );
		
		void cancelAppointment( String id );
		
		void markAppointmentAsComplete( String id );
		
		void notifyAllClientsByEmail();
		
		void notifyOneClientByEmail(int clientId);
		
		void notifyAllClientsBySMS();
		
		void notifyOneClientBySMS(int clientId);
	
		ListMessage<AppointmentResponseDtls> findScheduleStatus(String emailId);
		
		ListMessage<AppointmentResponseDtls> bookAppointments( AppointmentScheduleDetails apptSchdDtls );
}
