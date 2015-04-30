package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.PackageDetails;

public class CreatePackage extends PackageCommand {

	public CreatePackage(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String toString(){		
		return new StringBuilder(" A request was received to create a Package with name " )
		.append( ((PackageDetails)baseMsg).getPackageName()  )
		.toString();
	}
	
}
