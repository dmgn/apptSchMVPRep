package app.cal.schedule.business.cmd;

import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.CorporateDetails;

public class CorporateCommand extends BaseCommand {

	protected CorporateCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String getCorpName(){
		return getMsg() == null ? null : getMsg().getCorporateName();
	}
	
	protected CorporateDetails getMsg(){
		return (CorporateDetails)baseMsg;
	}
	
	public List<CorpLocDetails> getCorpLocations(){
		return getMsg().getCorpLocDetails();
	}
}
