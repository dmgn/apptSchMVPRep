package app.cal.schedule.business.cmd;

import java.util.Date;
import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.TutorScheduleDetails;

public class TutorScheduleCommand extends BaseCommand {

	protected TutorScheduleCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	protected TutorScheduleDetails getMsg(){
		return (TutorScheduleDetails)baseMsg;
	}
	
	public long getTutorId(){		
		return getMsg() == null ? null : getMsg().getTutorId();
	}
	
	public long getTutorScheduleId(){		
		return getMsg() == null ? null : getMsg().getTutorScheduleId();
	}
	
	public long getLocationId(){
		return getMsg() == null ? null : getMsg().getLocationId();
	}

	public List<Long> getProductIds(){
		return getMsg() == null ? null : getMsg().getProdIds();
	}
	
	public List<Long> getTimeSlotIds(){
		return getMsg() == null ? null : getMsg().getTimeSlotIds();
	}
	
	public Date getStartDate(){
		return getMsg() == null ? null : getMsg().getStartDate();
	}
	
	public Date getEndDate(){
		return getMsg() == null ? null : getMsg().getEndDate();
	}
}
