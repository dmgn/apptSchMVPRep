package app.cal.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.cal.schedule.api.AppointmentScheduleDetails;
import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.business.centre.AppointmentScheduleService;

@Controller
@RequestMapping(value="/appt")
public class AppointmentScheduleController {

	@Autowired
	AppointmentScheduleService appointmentScheduleService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/confirm")
	public ResponseEntity<BaseMessage> bookTimeSlot( @RequestBody AppointmentScheduleDetails apptSchdDtls ){		
		return new ResponseEntity<BaseMessage>(appointmentScheduleService.bookAppointments( apptSchdDtls ), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/status")
	public ResponseEntity<BaseMessage> findScheduleStatus( @RequestParam(value="emailId", required=true) String emailId ){
		return new ResponseEntity<BaseMessage>(appointmentScheduleService.findScheduleStatus(emailId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/view/tslots")
	public ResponseEntity<BaseMessage> findAllBookedTimeSlots( @RequestParam(value="status", required=false) int status,
			@RequestParam(value="startDt", required=false) String startDt,
			@RequestParam(value="endDt", required=false) String endDt,
			@RequestParam(value="viewType", required=false) String viewType){
		if ( viewType != null && viewType.equals("Grid") ){
			return new ResponseEntity<BaseMessage>(appointmentScheduleService.findAllAppointments(status) , HttpStatus.OK);
		}else{
			return new ResponseEntity<BaseMessage>(appointmentScheduleService.displayAppointmentsInCalView(startDt, endDt) , HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/view/info")
	public ResponseEntity<BaseMessage> viewCandidateInfoForTimeSlot( @RequestParam(value="tutorSchId", required=true) long tutorSchdId ){
		return new ResponseEntity<BaseMessage>(appointmentScheduleService.viewCandidatesForTimeSlot(tutorSchdId), HttpStatus.OK);
	}
	
	
}
