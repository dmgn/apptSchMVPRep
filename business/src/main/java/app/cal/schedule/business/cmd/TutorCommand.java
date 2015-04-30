package app.cal.schedule.business.cmd;

import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.TutorDetails;

public class TutorCommand extends BaseCommand {

	public TutorCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String getTutorName(){
		return getMsg() == null ? null :getMsg().getTutorName();		
	}
	
	public long getTutorId(){
		return getMsg() == null ? null :getMsg().getTutorId();
	}
	
	public long getCorpId(){
		return getMsg() == null ? null :getMsg().getCorpId();
	}
	
	public List<Long> getProductIds(){
		return getMsg() == null ? null :getMsg().getProductIds();
	}
	
	protected TutorDetails getMsg(){
		return ((TutorDetails)baseMsg);
	}
}
