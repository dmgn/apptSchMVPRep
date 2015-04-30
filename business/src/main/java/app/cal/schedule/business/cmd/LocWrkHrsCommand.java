package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.LocationWrkHrsDtls;

public class LocWrkHrsCommand extends BaseCommand {

	protected LocWrkHrsCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public LocationWrkHrsDtls getMsg(){
		
		return (LocationWrkHrsDtls)baseMsg;
	}
	
	public long getTimeSlotId(){
		return getMsg() == null ? null : getMsg().getTimeSlotId();
	}
	
	public String getStartTime(){
		return getMsg() == null ? null : getMsg().getStartTime();
	}
	
	public String getEndTime(){
		return getMsg() == null ? null : getMsg().getEndTime();
	}
	
	public long getLocationId(){
		return getMsg() == null ? null : getMsg().getLocationId();
	}
}
