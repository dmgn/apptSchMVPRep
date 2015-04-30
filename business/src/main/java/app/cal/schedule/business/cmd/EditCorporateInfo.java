package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorporateDetails;

public class EditCorporateInfo extends CorporateCommand {

	public EditCorporateInfo(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String toString(){		
		return new StringBuilder(" A request was received to update Corporate info with name " )
		.append( ((CorporateDetails)baseMsg).getCorporateName()  )
		.toString();
	}
}
