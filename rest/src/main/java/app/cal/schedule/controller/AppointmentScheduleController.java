package app.cal.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
}
