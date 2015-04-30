package app.cal.schedule.business.cmd;

import java.util.Date;

import app.cal.schedule.api.AppointmentScheduleDetails;
import app.cal.schedule.api.BaseMessage;

public class ClientScheduleCommand extends BaseCommand {

	protected ClientScheduleCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public AppointmentScheduleDetails getMsg(){
		
		return (AppointmentScheduleDetails)baseMsg;
	}
	
	public long getTutorScheduleId(){
		return getMsg() == null ? null : getMsg().getTutSchdId();
	}
	
	public long getClientId(){
		return getMsg() == null ? null : getMsg().getClientId();
	}
	
	public long getGroupId(){
		return getMsg() == null ? null : getMsg().getGroupId();
	}
	
	public Date getStartDt(){
		return getMsg() == null ? null : getMsg().getStartDt();
	}

	public Date getEndDt(){
		return getMsg() == null ? null : getMsg().getEndDt();
	}
	
	public boolean isRecurring(){
		return getMsg() == null ? null : getMsg().isRecurring();
	}
	
	public String getStatus(){
		return getMsg() == null ? null : getMsg().getStatus();
	}
}
