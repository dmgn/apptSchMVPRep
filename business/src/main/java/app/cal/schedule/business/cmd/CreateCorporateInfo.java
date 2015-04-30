package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorporateDetails;

public class CreateCorporateInfo extends CorporateCommand {

	public CreateCorporateInfo(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	public String toString(){		
		return new StringBuilder(" A request was received to create Corporate info with name " )
		.append( ((CorporateDetails)baseMsg).getCorporateName()  )
		.toString();
	}

}
